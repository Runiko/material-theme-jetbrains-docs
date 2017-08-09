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

package com.chrisrm.idea.status;

import com.chrisrm.idea.MTConfig;
import com.chrisrm.idea.MTConfigInterface;
import com.chrisrm.idea.config.ConfigNotifier;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.util.messages.MessageBusConnection;
import org.jetbrains.annotations.NotNull;

public final class MTStatusBarManager implements Disposable, DumbAware {

  private final Project project;
  private boolean statusEnabled;
  private MTStatusWidget mtStatusWidget;
  private final MessageBusConnection connect;

  private MTStatusBarManager(@NotNull final Project project) {
    this.project = project;
    this.mtStatusWidget = new MTStatusWidget();
    this.statusEnabled = MTConfig.getInstance().isStatusBarTheme();

    connect = project.getMessageBus().connect();
    connect.subscribe(ConfigNotifier.CONFIG_TOPIC, this::refreshWidget);
  }

  public static MTStatusBarManager create(@NotNull final Project project) {
    return new MTStatusBarManager(project);
  }

  private void refreshWidget(final MTConfigInterface mtConfig) {
    if (mtConfig.isStatusBarThemeChanged(this.statusEnabled)) {
      statusEnabled = mtConfig.isStatusBarTheme();

      if (statusEnabled) {
        this.install();
      } else {
        this.uninstall();
      }
    }

    mtStatusWidget.refresh();
  }

  void install() {
    final StatusBar statusBar = WindowManager.getInstance().getStatusBar(project);
    if (statusBar != null) {
      statusBar.addWidget(mtStatusWidget, "before Position", project);
    }
  }


  void uninstall() {
    final StatusBar statusBar = WindowManager.getInstance().getStatusBar(project);
    if (statusBar != null) {
      statusBar.removeWidget(mtStatusWidget.ID());
    }
  }

  @Override
  public void dispose() {
    if (!ApplicationManager.getApplication().isHeadlessEnvironment()) {
      if (mtStatusWidget != null) {
        uninstall();
        mtStatusWidget = null;
      }
    }
    connect.disconnect();
  }


}
