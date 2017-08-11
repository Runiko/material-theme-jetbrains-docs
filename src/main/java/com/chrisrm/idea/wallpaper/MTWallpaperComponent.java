/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Chris Magnussen and Elior Boukhobza
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *
 */

package com.chrisrm.idea.wallpaper;

import com.chrisrm.idea.MTConfig;
import com.chrisrm.idea.MTProjectConfig;
import com.chrisrm.idea.config.ConfigNotifier;
import com.intellij.ide.AppLifecycleListener;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.impl.IdeBackgroundUtil;
import com.intellij.util.messages.MessageBusConnection;
import org.jetbrains.annotations.NotNull;

public final class MTWallpaperComponent extends AbstractProjectComponent {

  private final PropertiesComponent propertiesComponent = PropertiesComponent.getInstance();
  private MTProjectConfig mtConfig;

  protected MTWallpaperComponent(final Project project) {
    super(project);
  }

  @Override
  public void initComponent() {
    mtConfig = MTProjectConfig.getInstance(myProject);

    /*
     We need to handle the case where the user set a custom background prior to installing the plugin.
     In this case, we save his current value inside the configuration file and we modify another value throughout the plugin lifetime.
     If he deletes the plugin, the configuration file will still be there, however if he deletes the value everything will be alright.
     */
    if (mtConfig.getDefaultBackground() == null) {
      mtConfig.setDefaultBackground(propertiesComponent.getValue(IdeBackgroundUtil.FRAME_PROP));
    }

    this.reloadWallpaper(myProject);

    final MessageBusConnection connect = ApplicationManager.getApplication().getMessageBus().connect();
    connect.subscribe(ConfigNotifier.CONFIG_TOPIC, new ConfigNotifier() {
      @Override
      public void configChanged(final MTConfig mtConfig) {
        //        reloadWallpaper();
      }

      @Override
      public void configChanged(final Project project, final MTProjectConfig mtProjectConfig) {
        reloadWallpaper(project);
      }
    });

    connect.subscribe(AppLifecycleListener.TOPIC, new AppLifecycleListener() {
      /**
       * Restore original background at evey close
       *
       * @param isRestart
       */
      @Override
      public void appWillBeClosed(final boolean isRestart) {
        final String defaultBackground = mtConfig.getDefaultBackground();
        if (defaultBackground == null) {
          propertiesComponent.unsetValue(IdeBackgroundUtil.FRAME_PROP);
        } else {
          propertiesComponent.unsetValue(IdeBackgroundUtil.FRAME_PROP);
          propertiesComponent.setValue(IdeBackgroundUtil.FRAME_PROP, defaultBackground);
        }
      }
    });
  }

  private void reloadWallpaper(final Project project) {
    final String wallpaper = mtConfig.getWallpaper();
    final String defaultBackground = mtConfig.getDefaultBackground();

    // If the wallpaper option is set, change the wallpaper
    if (mtConfig.isWallpaperSet()) {
      // If no value, remove the wallpaper
      if (wallpaper == null) {
        propertiesComponent.unsetValue(IdeBackgroundUtil.FRAME_PROP);
      } else {
        propertiesComponent.unsetValue(IdeBackgroundUtil.FRAME_PROP);
        propertiesComponent.setValue(IdeBackgroundUtil.FRAME_PROP, wallpaper);
      }
    } else {
      // Restore the original value
      if (defaultBackground == null) {
        propertiesComponent.unsetValue(IdeBackgroundUtil.FRAME_PROP);
      } else {
        propertiesComponent.unsetValue(IdeBackgroundUtil.FRAME_PROP);
        propertiesComponent.setValue(IdeBackgroundUtil.FRAME_PROP, defaultBackground);
      }
    }

    IdeBackgroundUtil.repaintAllWindows();
  }

  @Override
  public void disposeComponent() {

  }

  @NotNull
  @Override
  public String getComponentName() {
    return "MTWallpaperComponent";
  }
}