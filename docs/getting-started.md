---
layout: docs
title: Getting Started
description: Installing and configuring the plugin
group: getting-started
toc: true

next:
  url: '/docs/configuration/settings'
  title: Configuration
---

This section describes how to download and use the Material Theme UI plugin in your IDE.
{:class='title'}

{% include carbonads.html %}

## Installation

### Plugin Manager

The easiest way to install the Material Theme plugin is through IntelliJ's **plugin manager**. The plugin manager
usually contains stable releases that made it through testing and feedback.
{:class='title'}

<img src="{{ site.img_folder | prepend: site.baseurl | replace: '//', '/' }}/screens/plugins.png">

Steps:
1. Open Settings/Preferences (Windows/Linux: `Ctrl-S`, Mac: `Cmd-,`)
2. On the left, select **Plugins**
3. Click on the button `Browse repositories`
4. In the search field, type `Material Theme`
5. Double click on `Material Theme UI` to install it.
6. Click the `OK` button and restart the IDE.

<img src="{{ site.img_folder | prepend: site.baseurl | replace: '//', '/' }}/screens/listplugin.png">

### Manual Installation

If for some reason you don't want to use the plugin repository, or if you want to run your fork of the plugin, you can decide to install it manually.

<a href="https://plugins.jetbrains.com/plugin/8006-material-theme-ui">
  <button class="btn">Download <icon class="fa fa-download"></icon></button>
</a>

Steps:
1. Select the version you want to install. Please note the _Compatible Builds_ column to ensure that your IDE is compatible with the selected version.
2. Download the zip archive of the plugin.
3. Open Plugins settings (`Preferences -> Plugins`)
4. Instead of selecting `Browse repositories`, select **Install plugin from disk** and select the zip file.
5. Click OK and restart the IDE.

----

## Usage

Once the plugin is installed, you will immediately notice that the color of your IDE changed to a nice oceanic blue color! But the Material Plugin is much more than that.

### Setting the color scheme

The first thing to set is to change the color scheme to fit your current _UI Theme_.

To do so, open the `Quick Switch Panel` by typing `Ctrl + ``/Cmd + ~` and select `Color Scheme`. Besides the color schemes provided by the IDE and your own custom color schemes, you will find seven more color schemes provided by the plugin:

Material Themes:

{% for theme in site.data.themes.material %}
- {{theme.name}}
{% endfor %}

Other Themes:

{% for theme in site.data.themes.other %}
- {{theme.name}}
{% endfor %}

These schemes are adapted to the UI Theme of the same name, plus, for Atom One Dark, a complete port of the original [Atom One Dark](https://github.com/atom/one-dark-syntax) color scheme.

You can see more in the [Color Schemes]({{site.baseurl}}/docs/configuration/color-schemes) section.

### Configuring the plugin

The plugin also comes with a bunch of configurable settings to suit all flavors. There you can disable certain features, change the colors, sizes and appearance of the elements and so on.

These settings are found inside `Settings -> Appearance and Behavior -> Material Theme Settings`.

{% include figure.html content="/screens/settings.png" caption="Material Theme Settings" %}

Check [Settings]({{site.baseurl}}/docs/configuration/settings) for more info.

### Material Theme Quick Panel

Last but not least, the plugin is also providing 4 action groups to quickly customize the theme. These action groups are found in:
- The IDE menu, under `Tools -> Material Theme`
- The main toolbar, at the end of the toolbar
- By invoking the `Quick Switch Panel`

{% include figure.html content="/screens/toolbar.png" caption="Material Theme Toolbar" %}

Check [Actions]({{site.baseurl}}/docs/configuration/quick-actions-panel}}) for more info

## Support

The plugin is supported on all IDEs, but because of changes of the SDK specific versions are available only on latest builds:

- IDEs versions 2016.X and lower > up until version `0.2.3`
- IDEs versions 2017.1-2 > up until version `0.10.6`
- IDEs versions 2017.3+ > up until version `1.6.0.4`
- IDEs versions 2018.1+ > from version `1.7.0` and above

Because Android Studio is made by another team, it has it own plugin, `Material Theme UI for Android Studio`. However, it only features versions from `2.1.7.2` and above. For older versions please download the `Material UI` plugin.
- Android Studio 2.2.3 > up until version `0.2.3`
- Android Studio 3.0.0 - 3.1 > up until version `2.7.1.2.android`
- Android Studio 3.2+ > from version `2.7.1.2.android`
