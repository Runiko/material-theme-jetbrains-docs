---
layout: docs
title: Accents
description: Colorize important parts of the UI
group: configuration
comments: true
toc: true

previous:
  url: '/docs/configuration/file-status-colors'
  title: File Status Colors
next:
  url: '/docs/configuration/custom-themes'
  title: Custom Themes

gallery:
  - images:
    - filename: accents/actionButtons.png
      alttext: Action Buttons
    - filename: accents/checkboxes.png
      alttext: Checkboxes
    - filename: accents/containingDir.png
      alttext: Project View Directories
    - filename: accents/autocomplete.png
      alttext: Code Completion
    - filename: accents/documentation.png
      alttext: Documentation
    - filename: accents/editIndicator.png
      alttext: Edit Indicator
    - filename: accents/parameterInfo.png
      alttext: Parameter Info
    - filename: accents/progressBar.png
      alttext: Progress Bar
    - filename: accents/searchEverywhere.png
      alttext: Search Everywhere
    - filename: accents/searchInput.png
      alttext: Search Input
    - filename: accents/selectedItem.png
      alttext: Selected Item Indicator
    - filename: accents/selectedItemArrow.png
      alttext: Selected Item Arrow
    - filename: accents/radio.png
      alttext: Radio Buttons
    - filename: accents/slider.png
      alttext: Sliders
---

This section describes the **Accent Colors** feature and how is it used by the plugin.
{:class='title'}

## Definition

_Accent Color_ refers to a color used in accent key parts of the UI, such as the active tab, focused input texts, checked boxes and so on. The Material Theme plugin enables this feature in the IDE and gives the ability to customize it to your heart's content.

For more info about _Accent Colors_ in the Material Design guidelines, follow this link: https://material.io/guidelines/style/color.html#color-color-system

### Usage

Here is a list of components where accent color is used:
- Active Tab Indicator
- Close tab button on hover
- Tree View selected item indicator
- Checked boxes
- Selected Radio buttons
- Focused text inputs
- Focused/Hovered comboboxes
- Sliders
- Toggled Action buttons
- Edited file indicator
- Code Completion pane
- Parameter Info
- Documentation's links and bold texts
- Panels' links
- Hovered toolbar icons (not working on Mac)
- Tree's selected item expand and collapsed icons
- Progress Bar
- Circular progress indicator
- Opened files' containing directories (according to `Project View Decorators` setting)
- Scrollbars (according to `Accent Scrollbars` setting)
- VCS Log branches icon

### IMPORTANT NOTE

`Accent Color` is a **required** setting for the Material Theme plugin. As a result, if you encounter __errors__ coming from the plugin, it might be because you don't have an accent color set, or your accent color becoming unset as a result of plugin updates.
Please check your `Material Theme Settings` xml file to see if you have a configured accent. If not, simply preselect one from the `Accent Chooser` and restart the IDE.
{:class='card-panel warn'}

## Customization

There are two ways of customizing the current accent color:
- By selecting a color from the list of available colors
- By setting a custom color in the settings

### Accent Color chooser

A list of predefined accent colors is available in the `Material Config Toolbar`. These are colors frquently used from the Material Design color palette.

{% include figure.html content="/screens/accentChooser.png" caption="Accent Chooser" %}

Here is the list of predefined colors:

{% for color in site.data.accentColors %}
{% include color.html color=color %}
{% endfor %}

### Custom Accent Color

You can of course customize the accent color from the settings. Even when you choose a predefined color, you will see its value inside the settings.

{% include figure.html content="/screens/customAccentColor.png" caption="Custom Accent Color" %}

**Note**: Because components' colors are set at the start of the application, when changing the accent color some UI components will not get the change until next restart. Such examples of components are:
- Quick documentation panes
- Accent scrollbars
- Project View decorators
- Hovered icons
- ...


## Gallery

{% include gallery_lightbox.html %}


