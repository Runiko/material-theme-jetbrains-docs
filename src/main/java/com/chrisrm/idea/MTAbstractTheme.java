/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Chris Magnussen and Elior Boukhobza
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

import com.chrisrm.idea.themes.LafTheme;
import com.chrisrm.idea.themes.MTThemeable;
import com.chrisrm.idea.utils.MTUiUtils;
import com.chrisrm.idea.utils.PropertiesParser;
import com.intellij.ide.ui.LafManager;
import com.intellij.ide.ui.laf.IntelliJLookAndFeelInfo;
import com.intellij.ide.ui.laf.darcula.DarculaLookAndFeelInfo;
import com.intellij.openapi.util.IconLoader;
import com.intellij.ui.ColorUtil;
import com.intellij.ui.JBColor;
import com.intellij.util.ObjectUtils;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.io.Serializable;

public abstract class MTAbstractTheme implements LafTheme, Serializable, MTThemeable {
  private final String id;
  private final String editorColorsScheme;
  private final boolean dark;
  private String name;

  protected MTAbstractTheme(@NotNull final String id, final String editorColorsScheme, final boolean dark, final String name) {
    this(id, editorColorsScheme, dark);
    this.name = name;
  }

  protected MTAbstractTheme(@NotNull final String id, final String editorColorsScheme, final boolean dark) {
    this.id = id;
    this.editorColorsScheme = editorColorsScheme;
    this.dark = dark;
    name = id;
  }

  //region LafManager methods
  @Override
  public String getSelectionBackground() {
    return null;
  }

  /**
   * Get disabled color
   */
  @Override
  public String getDisabled() {
    return null;
  }
  //endregion

  @Override
  public final void activate() {
    try {
      if (isDark()) {
        LafManager.getInstance().setCurrentLookAndFeel(new DarculaLookAndFeelInfo());
        UIManager.setLookAndFeel(new MTLaf(this));
      } else {
        LafManager.getInstance().setCurrentLookAndFeel(new IntelliJLookAndFeelInfo());
        UIManager.setLookAndFeel(new MTLightLaf(this));
      }
      JBColor.setDark(isDark());
      IconLoader.setUseDarkIcons(isDark());

      buildResources(getBackgroundResources(), getBackgroundColorString());
      buildResources(getForegroundResources(), getForegroundColorString());
      buildResources(getTextResources(), getTextColorString());
      buildResources(getSelectionBackgroundResources(), getSelectionBackgroundColorString());
      buildResources(getSelectionForegroundResources(), getSelectionForegroundColorString());
      buildResources(getInactiveResources(), getInactiveColorString());
      buildResources(getCaretResources(), getCaretColorString());
      buildResources(getSecondaryBackgroundResources(), getSecondaryBackgroundColorString());
      buildResources(getDisabledResources(), getDisabledColorString());
      buildResources(getContrastResources(), getContrastColorString());
      buildResources(getTableSelectedResources(), getTableSelectedColorString());
      buildResources(getSecondBorderResources(), getSecondBorderColorString());
      buildResources(getHighlightResources(), getHighlightColorString());

      buildResources(getButtonHighlightResources(), getButtonHighlightColorString());
      buildResources(getTreeSelectionResources(), getTreeSelectionColorString());
      buildResources(getNotificationsResources(), getNotificationsColorString());

    } catch (final UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }
  }

  /**
   * Iterate over theme resources and fill up the UIManager
   *
   * @param resources
   * @param color
   */
  private void buildResources(final String[] resources, final String color) {
    for (final String resource : resources) {
      UIManager.getDefaults().put(resource, PropertiesParser.parseColor(color));
    }
  }

  //region Theme resources and colors

  /**
   * Get resources using the background color
   */
  protected String[] getBackgroundResources() {
    return new String[]{
        "mt.custom.background",
        "Menu.background",
        "mt.custom.textBackground",
        "mt.custom.inactiveBackground",
        "window",
        "activeCaption",
        "control",
        "PopupMenu.translucentBackground",
        "EditorPane.inactiveBackground",
        "Table.background",
        "Table.gridColor",
        "Desktop.background",
        "PopupMenu.background",
        "Separator.background",
        "MenuBar.background",
        "MenuBar.disabledBackground",
        "MenuBar.shadow",
        "TabbedPane.highlight",
        "TabbedPane.darkShadow",
        "TabbedPane.shadow",
        "TabbedPane.borderColor",
        "TextField.background",
        "PasswordField.background",
        "FormattedTextField.background",
        "TextArea.background",
        "CheckBox.background",
        "Slider.background",
        "Label.background",
        "TextPane.background",
        "RadioButton.background",
        "CheckBox.darcula.backgroundColor1",
        "CheckBox.darcula.backgroundColor2",
        "CheckBox.darcula.checkSignColor",
        "CheckBox.darcula.shadowColor",
        "CheckBox.darcula.shadowColorDisabled",
        "CheckBox.darcula.focusedArmed.backgroundColor1",
        "CheckBox.darcula.focusedArmed.backgroundColor2",
        "CheckBox.darcula.focused.backgroundColor1",
        "CheckBox.darcula.focused.backgroundColor2",
        "ComboBox.background",
        "ComboBox.disabledBackground",
        "ComboBox.arrowFillColor",
        "RadioButton.darcula.selectionDisabledColor",
        "StatusBar.topColor",
        "StatusBar.top2Color",
        "StatusBar.bottomColor",
        "Button.background",
        "Button.darcula.color1",
        "Button.darcula.color2",
        "Button.darcula.disabledText.shadow",
        "ToolTip.background",
        "Spinner.background",
        "SplitPane.highlight",
        //        "Panel.background",
        "SidePanel.background",
        "DialogWrapper.southPanelDivider",
        "OnePixelDivider.background",
        "Dialog.titleColor",
        "SearchEverywhere.background",
        "material.tab.backgroundColor"
    };
  }

  protected abstract String getBackgroundColorString();

  /**
   * Get resources using the foreground color
   */
  protected String[] getForegroundResources() {
    return new String[]{
        "mt.custom.foreground",
        "mt.custom.textForeground",
        "mt.custom.selectionForegroundInactive",
        "mt.custom.selectionInactiveForeground",
        "text",
        "textText",
        "textInactiveText",
        "infoText",
        "controlText",
        "Label.foreground",
        "CheckBox.foreground",
        "OptionPane.messageForeground",
        "Menu.foreground",
        "MenuItem.foreground",
        "EditorPane.inactiveForeground",
        "Table.sortIconColor",
        "TitledBorder.titleColor"
    };
  }

  protected abstract String getForegroundColorString();

  /**
   * Get resources using the label color
   */
  protected String[] getTextResources() {
    return new String[]{
        "Menu.acceleratorForeground",
        "MenuItem.acceleratorForeground",
        "TextField.separatorColorDisabled",
        "ComboBox.disabledForeground",
        "Button.foreground",
        "Button.mt.foreground",
        "Tree.foreground"
    };
  }

  protected abstract String getTextColorString();

  /**
   * Get resources using the selection background color
   */
  protected String[] getSelectionBackgroundResources() {
    return new String[]{
        "mt.custom.selectionBackgroundInactive",
        "mt.custom.selectionInactiveBackground",
        "Menu.selectionBackground",
        "MenuItem.selectionBackground",
        "Autocomplete.selectionbackground",
        "List.selectionBackground",
        "EditorPane.inactiveForeground",
        "ScrollBar.thumb"
    };
  }

  protected abstract String getSelectionBackgroundColorString();

  /**
   * Get resources using the selection foreground color
   */
  protected String[] getSelectionForegroundResources() {
    return new String[]{
        "mt.custom.selectionForeground",
        "Menu.selectionForeground",
        "Menu.acceleratorSelectionForeground",
        "MenuItem.selectionForeground",
        "MenuItem.acceleratorSelectionForeground",
        "Table.selectionForeground",
        "TextField.selectionForeground",
        "PasswordField.selectionForeground",
        "Button.mt.selectedForeground",
        "TextArea.selectionForeground",
        "Button.darcula.selectedButtonForeground"
    };
  }

  protected abstract String getSelectionForegroundColorString();

  /**
   * Get resources using the inactive color
   */
  protected String[] getInactiveResources() {
    return new String[]{
        "MenuBar.darcula.borderColor",
        "MenuBar.darcula.borderShadowColor",
        "Separator.foreground",
        "Button.mt.color1",
        "Button.mt.background",
        "material.disabled",
        "material.mergeCommits"
    };
  }

  protected abstract String getInactiveColorString();

  /**
   * Get resources using the caret color
   */
  protected String[] getCaretResources() {
    return new String[]{
        "mt.custom.caretForeground"
    };
  }

  protected abstract String getCaretColorString();

  /**
   * Get resources using the secondary background color
   */
  protected String[] getSecondaryBackgroundResources() {
    return new String[]{
        "inactiveCaption",
        "List.background"
    };
  }

  protected abstract String getSecondaryBackgroundColorString();

  /**
   * Get resources using the disabled color
   */
  protected String[] getDisabledResources() {
    return new String[]{
        "MenuItem.disabledForeground",
        "TextField.inactiveForeground",
        "PasswordField.inactiveForeground",
        "Button.disabledText",
        "CheckBox.darcula.checkSignColorDisabled"
    };
  }

  protected abstract String getDisabledColorString();

  /**
   * Get resources using the contrast color
   */
  protected String[] getContrastResources() {
    return new String[]{
        "Table.stripedBackground",
        "material.contrast"
    };
  }

  protected abstract String getContrastColorString();

  /**
   * Get resources using the table/button selection color
   */
  protected String[] getTableSelectedResources() {
    return new String[]{
        "Table.selectionBackground",
        "TextField.selectionBackground",
        "PasswordField.selectionBackground",
        "Button.darcula.selection.color1",
        "Button.darcula.selection.color2",
        "Button.mt.selection.color1",
        "MemoryIndicator.unusedColor"
    };
  }

  protected abstract String getTableSelectedColorString();

  /**
   * Get resources using the second border color
   */
  protected String[] getSecondBorderResources() {
    return new String[]{
        "MenuBar.darcula.borderShadowColor",
        "CheckBox.darcula.disabledBorderColor1",
        "CheckBox.darcula.disabledBorderColor2"
    };
  }

  protected abstract String getSecondBorderColorString();

  /**
   * Get resources using the highlight color
   */
  protected String[] getHighlightResources() {
    return new String[]{
        "TextField.separatorColor",
        "ProgressBar.halfColor",
        "CheckBox.darcula.inactiveFillColor",
        "MemoryIndicator.usedColor"
    };
  }

  protected abstract String getHighlightColorString();

  /**
   * Get resources using the button highlight color
   */
  protected String[] getButtonHighlightResources() {
    return new String[]{
        "Button.mt.color2",
        "Button.mt.selection.color2"
    };
  }

  protected abstract String getButtonHighlightColorString();

  /**
   * Get resources using the tree selected row color
   */
  protected String[] getTreeSelectionResources() {
    return new String[]{
        "Tree.selectionBackground"
    };
  }

  protected abstract String getTreeSelectionColorString();

  /**
   * Get notifications colors resources
   *
   * @return
   */
  protected String[] getNotificationsResources() {
    return new String[]{
        "Notifications.background",
        "Notifications.borderColor"
    };
  }

  protected abstract String getNotificationsColorString();
  //endregion

  //region MTThemeable methods
  @NotNull
  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public String getEditorColorsScheme() {
    return editorColorsScheme;
  }

  @Override
  @NotNull
  public String getId() {
    return id;
  }

  @Override
  public boolean isDark() {
    return dark;
  }
  //endregion

  //region Helper methods

  /**
   * Get background color custom property
   */
  @Override
  @NotNull
  public Color getBackgroundColor() {
    final Color defaultValue = MTUiUtils.getColor(
        new ColorUIResource(0x263238),
        ObjectUtils.notNull(UIManager.getColor("darcula.background"), new ColorUIResource(0x3c3f41)),
        ObjectUtils.notNull(UIManager.getColor("intellijlaf.background"), new ColorUIResource(0xe8e8e8)));
    return ObjectUtils.notNull(UIManager.getColor("material.tab.backgroundColor"), defaultValue);
  }

  /**
   * Get border color custom property
   */
  @Override
  @NotNull
  public Color getBorderColor() {
    return ObjectUtils.notNull(UIManager.getColor("material.tab.borderColor"), new ColorUIResource(0x80cbc4));
  }

  /**
   * Get border thickness custom property
   */
  @Override
  public int getBorderThickness() {
    return ObjectUtils.notNull(UIManager.getInt("material.tab.borderThickness"), 2);
  }

  /**
   * Get contrast color custom property
   */
  @Override
  @NotNull
  public Color getContrastColor() {
    final Color defaultValue = MTUiUtils.getColor(
        new ColorUIResource(0x1E272C),
        ColorUtil.withAlpha(new Color(0x262626), .5),
        ColorUtil.withAlpha(new Color(0x262626), .2));
    return ObjectUtils.notNull(UIManager.getColor("material.contrast"), defaultValue);
  }
  //endregion

  /**
   * Get the theme id
   */
  @Override
  public String toString() {
    return getId();
  }
}
