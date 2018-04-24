---
layout: docs
title: Custom Themes
description: Create your own custom theme
group: configuration
toc: true
comments: true

previous:
  url: '/docs/configuration/accents'
  title: Accents
next:
  url: '/docs/reference/color-palette'
  title: Color Palette
---

This section explains how you can customize the themes colors using Custom Themes.
{:class='title'}

{% include carbonads.html %}

## Introduction

The Material Theme plugin comes with a set of beautiful prebundled themes, suited for a good development experience. However, not everyone can be content with the choices made by the theme creator, and while the plugin offers a lot of customization, still, the ability to customize the themes themselves was one of the most requested features.

As of version 0.10.0, the plugin is giving the ability to do so by offering two "_boilerplate themes_", `Custom Theme` and `Light Custom Theme`, respectively based on `Material Oceanic` and `Material Lighter`, with the ability to customize most of the colors used by the themes!


## Configuration

### Settings

In order to use a custom theme, first you'll need to configure its colors. To do so open the Settings and navigate to **Appearance & Behavior** -> **Material Custom Theme**.

According to your current selected Look And Feel (`Darcula` or `IntelliJ`) you will respectively get the current colors of the `Material Oceanic` or `Material Lighter` themes.

{% include figure.html content="/screens/customTheme.png" caption="Custom Theme Colors" %}

{% include figure.html content="/screens/lightCustomTheme.png" caption="Light Custom Theme Colors" %}

**Note**: If you switch between the Light and Dark Custom Themes, since it is using the same settings page, a popup will appear asking if you'd like to replace the current custom theme colors with the selected theme's default colors, thus starting from scratch. You can decide to hide this popup for subsequent changes, but then you'll be needing to reset the colors manually.

{% include figure.html content="/screens/resetColors.png" caption="Reset Colors Popup" %}


Once you're done customizing your colors, you'll need to select **Custom Theme** or **Light Custom Theme** from the _Theme Switcher_ to see your colors in action. Enjoy!

----
### Colors Explanation

Here's a list of all the settings and what components they are affecting.

##### Background color

Affects the main background color of the IDE's panels, popups, controls...

##### Foreground color

Affects the main foreground color of the IDE's panels, popups, controls...

##### Secondary Text color

A secondary color used in some controls:
- Buttons Text
- Menu and Menu Items shortcut texts
- Text fields' border
- Disabled text in dropdowns
- Tree items

##### Selection Background Color

The background color of selections in controls:
- Menu and Menu Items selected items
- Selected List Items and Table Cells
- Selected tabs
- Autocomplete selected item
- Selected Tabbed Pane
- Selected text in documentation panels

##### Selection Foreground Color

The foreground color of selections in controls:
- Menu and Menu Items selected items
- Selected List Items and Table Cells
- Selected tabs
- Autocomplete selected item
- Selected text in text fields
- Selected text in documentation panels
- Focused buttons' text
- Dropdown selected item text
- Selected item in trees

##### Button Colors

Buttons colors and others:
- Buttons background color
- Merge commits text

##### Secondary background color

A secondary color used to contrast with the background color.
- Lists background color
- Active Tool Window Header Color
- Memory Indicator Unused color

##### Disabled color

A color used principally inside disabled items:
- Disabled menu and menu items' text
- Disabled text fields and password fields
- Disabled buttons
- Disabled checkboxes

##### Contrast color

The color used when contrast mode is enabled:
- Contrast mode affected controls (Tree, Text fields, Tabs...)
- Odd rows in striped tables
- Documentation panes
- Tool Window Headers selected tab
- Selected Tab in Tabbed Panes

##### Active component color

Another color to use for active component colors:
- Selected cells in tables
- Selected text in text fields and documentation panes
- Selected items in dropdowns
- Primary Buttons and Hovered buttons

##### Border Color

Color that affect the following components:
- Menu bar border
- Disabled checkboxes box color
- Button borders for non-material buttons
- Tabbed Panes border
- One Pixel Separators separating editors in Split Mode
- Menu Separators

##### Highlight color

Color that affect the following components:
- Text fields and dropdowns border
- Checkboxes' sign in disabled checkboxes
- Memory indicator's used memory color

##### Tree Selection color

Specific color used for selected items in trees.

##### Notifications color

Color used in the notification popups.

-----

## Frequently Asked Questions

**Q**: Can I use more than one custom theme?

**A**: No you can't. If you're confident with your theme, you can fork the project and submit a pull request with your theme as a predefined theme, or submit your theme in the form (not available yet).

**Q**: Where is stored my custom theme colors?

**A**: You can find your custom colors inside the config directory, just like the Material settings.

**Q**: Why do I get a popup asking me for "resetting the theme colors" at start?

**A**: This popup is used to reset the custom theme colors to their default ones and is popping up when switching from a dark theme to a light theme and vice-versa. However sometimes, like for instance when you install the plugin or reset your settings, because it doesn't know which theme you came from, it will ask even though you didn't ask for it. Simply press ok and it will not bother you anymore.

**Q**: I changed the colors but it doesn't look as good as the default themes.

**A**: Creating a theme is not an easy task, and the Material ones are the result of a long thought process about which colors are best suited for an UI. However you can check out other famous Sublime/Atom/Visual Studio themes as an inspiration and start from it.

**Q**: OK I have an idea of a theme, but there is not enough options in the settings for me to make it.

**A**: It's true that those settings are for color palettes of a few colors only, and regroup components of the same purpose under the same color group. If though you'd like to have a different color for checkboxes and radio buttons, or between lists and tables, or set the tree color different as the main background color, etc. - for this the best option would be to fork the project and create a brand new theme.
