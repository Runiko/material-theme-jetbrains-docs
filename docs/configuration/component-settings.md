---
layout: docs
title: Component Settings
description: Enable or disable Material Theme features
group: configuration
comments: true
toc: true

previous:
  url: '/docs/configuration/panel-settings'
  title: Panel Settings
next:
  url: '/docs/configuration/quick-actions-panel'
  title: Quick Actions Panel
---

Here you can turn on and off specific features of the Material Theme for even further customization.
{:class='title'}

{% include carbonads.html %}

## Enabling and Disabling features

The following options allow you to enable and disable features provided by the Material Theme. This gives you the ability to specifically select features such as theme colors or icons while disabling the rest if you don't like it. For instance, if you like the icons but don't like the themes and components, just leave the icons on and disable the rest. If on the other hand you like everything but prefer to use the default icons, just disable the icons.
{:class='title'}

### Material Design Components

This toggles the theming of components inside the IDE such as *buttons*, *text fields* and *checkboxes*. This is nice if you like the theme colors and icons but don't like the Material Design flat components, padded rows and borderless boxes.

Specifically this option disables:
- Flat Buttons
- Borderless input, number, password and search boxes
- Borderless dropdowns
- Accent progress bars
- Trees' selected item indicator
- Trees' opened and closed folders chevrons (>)
- Padded Table Headers and Table Cells
- Padded List Items
- Borderless status bar
- Material Design progress circular loader/spinner
- Material Design Checkboxes, Radio Buttons and Sliders
- Search Everywhere's Switches
- Material Design Navigation Bar

But while these components are disabled, other features such as _Accent Colors_ and _Contrast Mode_ are still in action, meaning that you can have Darcula checkboxes and buttons with your accent color, or the contents of inputs being in contrasted color, for instance.

{% include figure.html content="/screens/componentsEnabled.png" caption="Material Components Enabled" %}

{% include figure.html content="/screens/componentsDisabled.png" caption="Material Components Disabled" %}

What it doesn't disable however, albeit Material Design components, are:
- Dialog boxes padded titles
- Toggled buttons indicators
- Run Configurations dropdown

This is because currently these components are not as themeable as the other ones, and theming occur at the start of the application, without having access to the user settings. If the API changes and they become easier to theme, they will be listed in the first list, but for now there is no way to disable theming of these components othen than removing the plugin.

**Note**: Because this option completely replaces the components UI, a complete restart of the application is needed in order to see them in action.

**Note 2**: Some of the features depend on this setting to work, therefore disabling this will result to disabling those features as well. These are:
- _Padded Statusbar_: The statusbar will revert to its default, compact design.

----

### Uppercase buttons

This setting sets the text of the buttons to be uppercase, just like the Material Design buttons. This is optimal for a full-fledged Material Design Experience.

{% include figure.html content="/screens/uppercaseButtons.png" caption="Uppercase Buttons" %}

**Note**: Because the UI was originally intended to be used with regular cased buttons, some buttons with longer text will have their text overflowing outside of the button. Since it's not possible to control the size of such buttons, there is no possibility to fix this. However, such cases are quite rare, but if it's absolutely bothers you, you can still disable this feature via this option.
{:class='card-panel warn'}

----
### Material Icons

This setting toggles the replacement of the icons provided by the plugin. Specifically this disables:
- File Icons
- Menu Icons
- Toolbar Icons
- Tool Window Icons
- Application Icons

Basically this replaces all icons provided by the plugin, including breakpoint icons, dialog icons and even icons inside documenation panels.

{% include figure.html content="/screens/iconsDisabled.png" caption="Material Icons Disabled" %}

**Note**: Because this option replaces IDE icons, a complete restart of the application is needed.

**Note 2**: Some of the features depend on this setting to work, therefore disabling this will result to disabling those features as well. These are:
- _Hide File Icons_: You won't be able to hide file icons anymore.

----
### Material Fonts

This setting switches the default font used in the editor with the usual font used in Material Design, [Roboto](https://fonts.google.com/specimen/Roboto).

This setting changes the font you see in *Settings -> Appearance and Behavior -> Appearance*. When unchecked, it will restore the original default font, e.g. `Tahoma` in Windows, `SF_Text` in Mac and `Lucida Sans` in Linux. When checked, it will replace it with `Roboto` (only if the font is already installed in the machine though).

This setting is also making the font in the Project View to be __slightly bigger (2px more)__.

**Note**: This setting is requiring that **default fonts are not overriden**, e.g. that the setting at `Appearance and Behavior -> Appearance -> Override default font` is unchecked, in which case it will use the font set there.
{:class='card-panel'}


**Note 2**: This setting will replace the font with Roboto only if that font is already installed in the machine. If not, you can download it here: https://material.io/guidelines/resources/roboto-noto-fonts.html
{:class='card-panel'}

**Note 3**: If you want to use Roboto and want to cancel the "bigger fonts" option, just disable the setting and select Roboto in the `Override default font` option in Appearance settings.
{:class='card-panel'}

----
### Material Theme

This option simply disabled the Material Theme Styling, e.g. leave components and icons intact but revert to the original Darcula/IntelliJ Look And Feel.

{% include figure.html content="/screens/themeDisabled.png" caption="Material Theme Disabled" %}

**Note**: The IDE will revert back to the most appropriated Look And Feel, e.g. if you were on Material Oceanic or Darker, you will revert back to **Darcula**. If you were on Material Lighter, you will be reverted to **IntelliJ**.

**Note 2**: Some of the features depend on this setting to work, therefore disabling this will result to disabling those features as well. These are:
- _Themes and Custom Themes_: You won't be able to switch themes (obviously)
- _Contrast Mode_: There is no contrast mode for native themes
- _Custom Sidebar Height_: You will be reverted to Darcula/IntelliJ native sidebar height
- _Custom Tree Indent_: You will be reverted to Darcula/IntelliJ native indent
- _Bold Directories_: There is no way to bold directories in native themes
- Other components will also revert back to their default values, such as checkboxes signs, tabbed pane insets, etc.

----

## Other Component features

These features are additional extras to the plugin, not related to the themes nor Material Design but simply nice addons for the IDE.
{:class = 'title'}

### Project View Decorators

This feature is adding decorations to the Project View to mimic the original Material Sublime Theme decorations.

###### Open and closed directories

When this option is on, files that are _opened_ in the editor and that are _edited_ will have their containing directories have a __hollow directory icon__ (or outline directory) instead of the original icon.

{% include figure.html content="/screens/folderDecorators.png" caption="Opened folder decorators" %}

**Note**: This feature requires *Material Icons* feature to work.

###### Accent colored opened directories

Same as the hollow directory icon, files that are _opened_ and _edited_ will have their containing directories be colored with the selected _accent color_.

##### Decorated Folders

Assign specific folder icons to folders with commonly used names to add yet more visual grepping than with file icons. For instance, `tmp`, `logs`, `src`, `lib` or `test` are folders found within most projects.

{% include figure.html content="/screens/decoFolders.png" caption="Decorated Folders" %}

Note that excluded/resource root/test root/package folders will not be decorated.

**Note**: This feature depends on the *Project View Decorators* feature.

-----

### Theme in Status Bar

This setting add a "widget" to the status bar to indicate which theme you are currently on.

{% include figure.html content="/screens/widgetStatusbar.png" caption="Status Bar Widget" %}

-----
### Transparent Scrollbars and Accent Scrollbars

These options control the appearance of the scrollbars. Note: This feature works completely on Windows and Linux, but on Mac it is only working for non-native scrollbars (e.g. scrollbars that appear only while scrolling).

*Transparent scrollbars* will add transparency to the scrollbars and set it as the same color as the current theme's background color. This is adding _50% opacity_ and there is no way to change it.

*Accent scrollbars* will replace the scrollbar color with the _current accent color_.

{% include figure.html content="/screens/scrollbars.png" caption="Accent Scrollbars" %}

**Note**: These options are mutually exclusive, and _Accent Scrollbars_ take precedence over _Transparent Scrollbars_.

**Note 2**: Accent colors are set at the start of the application. If you change the accent color, you will need a full restart to see it reflected on the scrollbars. Same for the _Transparent Scrollbars_, if you switch themes you will need a full restart to see it taking the new theme's color.

----
### Dark/Themed Title Bar

##### Mac OSX
Dark Title bar is an experimental feature to set a dark title bar to the application for dark themes (such as Material Oceanic, Palenight, Darker). It is experimental because it depends on a feature that could disappear in the future as it is an experimental feature even in the IDE.

{% include figure.html content="/screens/customTheme.png" caption="Dark title bar" %}

Note that this works only for 2017.3+ versions. It doesn't work on Android Studio yet.

##### Windows 10

This setting also allows the theming of the application title bar in Windows 10. To do so, it is actually setting the [Windows Accent Color](https://www.howtogeek.com/225893/how-to-personalize-windows-10s-appearance/) set by Windows.

**Note**: Since this modifies the color OS-wide, the color set by the plugin will stick even if you close the IDE/uninstall the plugin. Just follow the instructions at https://www.howtogeek.com/225893/how-to-personalize-windows-10s-appearance/ to set it to another color of your choice.

-----
## FAQ/Troubleshooting

**Q**: I've set "Material Fonts" but now my texts are all scrambled!

**A**: This is a rare bug that occurs and honestly I don't know why it happens. It could be because the JDK caches fonts or because there are conflicts between Roboto fonts, or that you have a bad version of Roboto. Try to reinstall the Roboto font and restart the computer. If it still doesn't work, just disable the option or select another font in the settings.

**Q**: **I've disabled the plugin but I still get the bigger fonts/dark title bar!**

**A**: This happens because this is not a feature implemented by the plugin, but instead makes use of a feature implemented by the IDE. Theoretically it should disable these settings on project unloading, therefore when uninstalling the plugin. But if for some reason it doesn't happen, here is how you can disable them manually:
- Open Command Panel (Cmd+Shift-A/Ctrl-Shift-A) and type `Registry`
- Look for keys `bigger.fonts.in.project.view` or `ide.mac.allowDarkDecorations` and set them to false.
- Change the color of the title bar in Windows by following the instructions at https://www.howtogeek.com/225893/how-to-personalize-windows-10s-appearance/
