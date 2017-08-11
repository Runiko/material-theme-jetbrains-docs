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

package com.chrisrm.idea;

import com.chrisrm.idea.messages.MaterialThemeBundle;
import com.chrisrm.idea.utils.MTUiUtils;
import com.chrisrm.idea.utils.UIReplacer;
import com.google.common.collect.ImmutableList;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.ide.ui.UISettings;
import com.intellij.ide.ui.laf.IntelliJLaf;
import com.intellij.ide.ui.laf.darcula.DarculaInstaller;
import com.intellij.ide.ui.laf.darcula.DarculaLaf;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.impl.ActionToolbarImpl;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.fileTypes.ex.FileTypeManagerEx;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.openapi.wm.impl.status.IdeStatusBarImpl;
import com.intellij.ui.JBColor;
import com.intellij.util.ui.JBUI;
import com.intellij.util.ui.UIUtil;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class MTThemeManager {

  private static final String[] FONT_RESOURCES = new String[]{
      "Button.font",
      "ToggleButton.font",
      "RadioButton.font",
      "CheckBox.font",
      "ColorChooser.font",
      "ComboBox.font",
      "Label.font",
      "List.font",
      "MenuBar.font",
      "MenuItem.font",
      "MenuItem.acceleratorFont",
      "RadioButtonMenuItem.font",
      "CheckBoxMenuItem.font",
      "Menu.font",
      "PopupMenu.font",
      "OptionPane.font",
      "Panel.font",
      "ProgressBar.font",
      "ScrollPane.font",
      "Viewport.font",
      "TabbedPane.font",
      "Table.font",
      "TableHeader.font",
      "TextField.font",
      "FormattedTextField.font",
      "Spinner.font",
      "PasswordField.font",
      "TextArea.font",
      "TextPane.font",
      "EditorPane.font",
      "TitledBorder.font",
      "ToolBar.font",
      "ToolTip.font",
      "Tree.font"};

  private static final String[] CONTRASTED_RESOURCES = new String[]{
      "Tree.background",
      "Tree.textBackground",
      //      "Table.background",
      "Viewport.background",
      "ToolBar.background",
      "SidePanel.background",
      "TabbedPane.background",
      "TextField.background",
      "PasswordField.background",
      "TextArea.background",
      "TextPane.background",
      "EditorPane.background",
      "ToolBar.background",
      "FormattedTextField.background",
      //      "RadioButton.darcula.selectionDisabledColor",
      //      "RadioButton.background",
      //      "Spinner.background",
      //      "CheckBox.background",
      //      "CheckBox.darcula.backgroundColor1",
      //      "CheckBox.darcula.backgroundColor2",
      //      "CheckBox.darcula.shadowColor",
      //      "CheckBox.darcula.shadowColorDisabled",
      //      "CheckBox.darcula.focusedArmed.backgroundColor1",
      //      "CheckBox.darcula.focusedArmed.backgroundColor2",
      //      "CheckBox.darcula.focused.backgroundColor1",
      //      "CheckBox.darcula.focused.backgroundColor2",
      //      "ComboBox.disabledBackground",
      //      "control",
      "ComboBox.background",
      "ComboBox.disabledBackground",
      "ComboBox.arrowFillColor",
      "window",
      "activeCaption",
      "desktop",
      "MenuBar.shadow",
      "MenuBar.background",
      "TabbedPane.darkShadow",
      "TabbedPane.shadow",
      "TabbedPane.borderColor",
      "StatusBar.background",
      "SplitPane.highlight",
      "ActionToolbar.background"
  };


  private final List<String> editorColorsSchemes;

  public MTThemeManager() {
    final Collection<String> schemes = new ArrayList<>();
    for (final MTTheme theme : MTTheme.values()) {
      schemes.add(theme.getEditorColorsScheme());
    }
    editorColorsSchemes = ImmutableList.copyOf(schemes);
  }

  public static MTThemeManager getInstance() {
    return ServiceManager.getService(MTThemeManager.class);
  }

  private static String getSettingsPrefix() {
    final PluginId pluginId = PluginManager.getPluginByClassName(MTTheme.class.getName());
    return pluginId == null ? "com.chrisrm.idea.MaterialThemeUI" : pluginId.getIdString();
  }


  //region Action Toggles
  public void toggleMaterialDesign() {
    final MTConfig mtConfig = MTConfig.getInstance();
    mtConfig.setIsMaterialDesign(!mtConfig.getIsMaterialDesign());

    askForRestart();
  }

  public void toggleProjectViewDecorators() {
    final MTConfig mtConfig = MTConfig.getInstance();
    mtConfig.setUseProjectViewDecorators(!mtConfig.isUseProjectViewDecorators());
    this.updateFileIcons();
  }

  public void toggleMaterialTheme() {
    MTConfig.getInstance().setIsMaterialTheme(!MTConfig.getInstance().isMaterialTheme());
    getInstance().activate();
  }

  public void toggleCompactStatusBar() {
    final boolean compactStatusBar = MTConfig.getInstance().isCompactStatusBar();
    MTConfig.getInstance().setIsCompactStatusBar(!compactStatusBar);

    this.setStatusBarBorders();
  }

  public void toggleHideFileIcons() {
    final boolean hideFileIcons = MTConfig.getInstance().getHideFileIcons();
    MTConfig.getInstance().setHideFileIcons(!hideFileIcons);

    this.updateFileIcons();
  }

  public void toggleCompactSidebar() {
    final boolean isCompactSidebar = MTConfig.getInstance().isCompactSidebar();
    MTConfig.getInstance().setCompactSidebar(!isCompactSidebar);

    this.applyCompactSidebar(true);
  }

  public void toggleMaterialIcons() {
    final boolean useMaterialIcons = MTConfig.getInstance().isUseMaterialIcons();
    MTConfig.getInstance().setUseMaterialIcons(!useMaterialIcons);

    this.updateFileIcons();
  }

  //endregion

  //region File Icons support
  public void updateFileIcons() {
    ApplicationManager.getApplication().runWriteAction(() -> {
      final FileTypeManagerEx instanceEx = FileTypeManagerEx.getInstanceEx();
      instanceEx.fireFileTypesChanged();
      ActionToolbarImpl.updateAllToolbarsImmediately();
    });
  }
  //endregion

  //region Status bar support

  /**
   * Change status bar borders
   */
  public void setStatusBarBorders() {
    final boolean compactSidebar = MTConfig.getInstance().isCompactStatusBar();

    ApplicationManager.getApplication().invokeLater(() -> {
      final JComponent component = WindowManager.getInstance().findVisibleFrame().getRootPane();
      if (component != null) {
        final IdeStatusBarImpl ideStatusBar = UIUtil.findComponentOfType(component, IdeStatusBarImpl.class);
        if (ideStatusBar != null) {
          ideStatusBar.setBorder(compactSidebar ? JBUI.Borders.empty() : JBUI.Borders.empty(8, 0));
        }
      }
    });
  }
  //endregion

  //region Theme activation and deactivation

  /**
   * Activate selected theme or deactivate current
   */
  public void activate() {
    final MTTheme mtTheme = MTTheme.DEFAULT;
    if (!MTConfig.getInstance().isMaterialTheme()) {
      removeTheme(mtTheme);
      return;
    }

    this.activate(mtTheme);
  }

  /**
   * Activate theme
   *
   * @param mtTheme
   */
  public void activate(final MTTheme mtTheme) {
    MTTheme newTheme = mtTheme;
    if (newTheme == null) {
      newTheme = MTTheme.DEFAULT;
    }

    try {
      UIManager.setLookAndFeel(new MTLaf(newTheme));
      JBColor.setDark(newTheme.isDark());
      IconLoader.setUseDarkIcons(newTheme.isDark());

      PropertiesComponent.getInstance().setValue(getSettingsPrefix() + ".theme", newTheme.name());
      applyCompactSidebar(false);
    } catch (final UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }

    final String currentScheme = EditorColorsManager.getInstance().getGlobalScheme().getName();

    final String makeActiveScheme = !editorColorsSchemes.contains(currentScheme) ?
                                    currentScheme : newTheme.getEditorColorsScheme();

    final EditorColorsScheme scheme = EditorColorsManager.getInstance().getScheme(makeActiveScheme);

    // We need this to update parts of the UI that do not change
    DarculaInstaller.uninstall();
    if (newTheme.isDark()) {
      DarculaInstaller.install();
    }

    if (scheme != null) {
      EditorColorsManager.getInstance().setGlobalScheme(scheme);
    }

    applyFonts();

    UIReplacer.patchUI();
  }

  private void askForRestart() {
    final String title = MaterialThemeBundle.message("mt.restartDialog.title");
    final String message = MaterialThemeBundle.message("mt.restartDialog.content");

    final int answer = Messages.showYesNoDialog(message, title, Messages.getQuestionIcon());
    if (answer == Messages.YES) {
      MTUiUtils.restartIde();
    }
  }


  /**
   * Completely remove theme
   *
   * @param mtTheme
   */
  private void removeTheme(final MTTheme mtTheme) {
    try {
      resetContrast();

      if (mtTheme.isDark()) {
        UIManager.setLookAndFeel(new DarculaLaf());
      } else {
        UIManager.setLookAndFeel(new IntelliJLaf());
      }

      JBColor.setDark(mtTheme.isDark());
      IconLoader.setUseDarkIcons(mtTheme.isDark());
      PropertiesComponent.getInstance().unsetValue(getSettingsPrefix() + ".theme");

      // We need this to update parts of the UI that do not change
      DarculaInstaller.uninstall();
      if (mtTheme.isDark()) {
        DarculaInstaller.install();
      }
    } catch (final UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }
  }

  /**
   * Apply custom fonts
   *
   * @param uiDefaults
   * @param fontFace
   * @param fontSize
   */
  private void applyCustomFonts(final UIDefaults uiDefaults, final String fontFace, final int fontSize) {
    uiDefaults.put("Tree.ancestorInputMap", null);
    final FontUIResource uiFont = new FontUIResource(fontFace, Font.PLAIN, fontSize);
    final FontUIResource textFont = new FontUIResource("Serif", Font.PLAIN, fontSize);
    final FontUIResource monoFont = new FontUIResource("Monospaced", Font.PLAIN, fontSize);

    for (final String fontResource : FONT_RESOURCES) {
      uiDefaults.put(fontResource, uiFont);
    }

    uiDefaults.put("PasswordField.font", monoFont);
    uiDefaults.put("TextArea.font", monoFont);
    uiDefaults.put("TextPane.font", textFont);
    uiDefaults.put("EditorPane.font", textFont);
  }

  private void applyFonts() {
    final UISettings uiSettings = UISettings.getInstance();
    final UIDefaults lookAndFeelDefaults = UIManager.getLookAndFeelDefaults();

    if (uiSettings.getOverrideLafFonts()) {
      applyCustomFonts(lookAndFeelDefaults, uiSettings.getFontFace(), uiSettings.getFontSize());
    } else {
      final Font roboto = MTUiUtils.findFont("Roboto");
      if (roboto != null) {
        applyCustomFonts(lookAndFeelDefaults, "Roboto", JBUI.scale(12));
      }
    }
  }
  //endregion

  //region Contrast support

  /**
   * Reset contrast
   */
  private void resetContrast() {
    for (final String resource : CONTRASTED_RESOURCES) {
      UIManager.put(resource, null);
    }
  }
  //endregion

  //region Compact Sidebar support

  /**
   * Use compact sidebar option
   */
  void applyCompactSidebar(final boolean reloadUI) {
    final boolean compactSidebar = MTConfig.getInstance().isCompactSidebar();
    final int rowHeight = compactSidebar ? JBUI.scale(18) : JBUI.scale(28);
    UIManager.put("Tree.rowHeight", rowHeight);

    if (reloadUI) {
      reloadUI();
    }
  }
  //endregion


  /**
   * Trigger a reloadUI event
   */
  private void reloadUI() {
    applyFonts();
    DarculaInstaller.uninstall();
    DarculaInstaller.install();
  }
}
