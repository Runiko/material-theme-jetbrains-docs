---
layout: docs
title: Acknowledgements
comments: true
toc: true

previous:
  url: '/docs/other/roadmap'
  title: Roadmap
next:
  url: '/docs/configuration/custom-themes'
  title: Custom Themes
---

Even though the Material Plugin is the fruit of a handful of developers, it is actually the contribution of a lot of people that have made it awesome as it is!

{% include carbonads.html %}

#### Creators

First of all I want to thank the original creators of the theme and its derived products:

##### Mattia Astorino ([@equinusocio](https://github.com/equinusocio))

<img class="avatar-img" src="https://avatars1.githubusercontent.com/u/10454741?v=4&s=460">

The original creator of the Material Theme, and developer of the Material Theme for Sublime and for Visual Studio Code. He found the perfect color balance in his themes and followed the Material Design guidelines perfectly for a slick coding experience.

He is also my inspiration for the UI design and the many settings that he introduced, giving a lot of customization to the users.


##### Chris Magnussen ([@ChrisRM](https://github.com/chrisrm))

<img class="avatar-img" src="https://avatars3.githubusercontent.com/u/309292?v=4&s=460">

The original creator of the Jetbrains plugin. Thanks to his ingeniosity we finally had an alternative to the bland native themes that are Darcula and IntelliJ. He was curious enough to dig into the code in order to find the settings that let plugin developers control the theme colors and replace icons. I learnt a lot from him.


##### Ihor Oleksandrov ([@ihodev](https://github.com/ihodev))

<img class="avatar-img" src="https://avatars0.githubusercontent.com/u/9801624?s=460&v=4">

The main creator of the [*a-file-icon*](https://github.com/ihodev/a-file-icon) plugin for Sublime, which replaces the original file icons to their logo counterparts, making them easier to differentiate and greatly improving the visibility in projects. He created a whole lot of icons that the Material Theme Plugins are using, and provided an easy way to create new icons, thus allowing further customization of the Material Theme.

##### Elior Boukhobza ([@mallowigi](https://github.com/mallowigi))

<img class="avatar-img" src="https://avatars1.githubusercontent.com/u/5015756?v=4&s=460">

The current maintainer of the Material Theme UI plugin and for the documentation site as well. He is the guy who took the project as awesome as it is and made it much awesomer, with settings, custom components, custom themes, external themes and many other cool features.

----
#### Plugins and references

The second people I want to thank are a specific bunch of plugin developers, which helped me through peeking at their code developing the features I needed for the theme. These are:

##### AfterGlow Theme

[Afterglow Theme](https://plugins.jetbrains.com/plugin/8066-afterglow-theme)

This is another theme for Jetbrains which has its lot of uniques features too. Sadly it has not been updated for a while and would probably not work with current versions.

##### Nyan Progress Bar

[Nyan Progress Bar](https://plugins.jetbrains.com/plugin/8575-nyan-progress-bar)

A funny plugin which replaces the Progress Bar with a _Nyan Cat_. The inspiration for the [Material Components]({{site.baseurl}}/docs/reference/components) customization.

##### .ignore

[.ignore](https://plugins.jetbrains.com/plugin/7495--ignore)

A rather complete plugin for `.ignore` files, allowing easy creation of such files, with templates for many tools and frameworks. It uses a lot of features from the Plugin SDK which was an inspiration for many features of the Material Theme plugin.

##### Git Toolbox

[Git Toolbox](https://plugins.jetbrains.com/plugin/7499-gittoolbox)

A plugin extending the IDE with information from the current Git state: Git project, Git status, Git branch and so on. It was an inspiration for the Project View Decorators and also my main learning source for creating application and project settings.

##### Project Label

[Project Label](https://plugins.jetbrains.com/plugin/8032-project-label)

A rather simple plugin that shows the current project in the status bar which was the inspiration for the [Status Bar Indicator]({{site.baseurl}}/docs/configuration/component-settings#theme-in-status-bar) feature.

##### Browse Word At Caret

[Browse Word At Caret](https://plugins.jetbrains.com/plugin/201-browsewordatcaret)

A rather simple plugin that highlights all occurences of the word under caret. Its implementation of a settings page inside the Color Schemes settings was the inspiration for the [Material File Status Colors]({{site.baseurl}}/docs/configuration/file-status-colors) feature.

##### Material Icon Theme for Visual Studio Code

[Material Icon Theme for VSCode](https://marketplace.visualstudio.com/items?itemName=PKief.material-icon-theme)

The Material Theme Icons, but for Visual Studio Code. It's actually the _Decorated Folders_ feature that gave me the idea to implement it in the Jetbrains' plugin. Besides, the folder icons were taken from there, with some small changes in the colors.

----
#### Contributors

First of all I want to thank all icon designers who designed all the icons used by the theme:
* [File-Icons](https://github.com/file-icons/source/blob/master/charmap.md)
* [FontAwesome 4.7.0](http://fontawesome.io/cheatsheet/)
* [Mfizz](https://github.com/file-icons/MFixx/blob/master/charmap.md)
* [Devicons](https://github.com/file-icons/DevOpicons/blob/master/charmap.md)
* [Material Design Icons](https://materialdesignicons.com/)
* [Many FlatIcons authors](https://www.flaticon.com/)

Thanks also to [@yonnyz](https://twitter.com/yonnyz) for the logo and theme icons, and [@gidivigo](https://twitter.com/gidivigo) for helping me with the documentation design. And thanks to [@azdanov](https://github.com/azdanov) for some of the folder icons.

I also want to thank the guys at [Gridster Digitalmind](http://gridster.digitalmind.ch/) with their ++Material Jekyll template++ which was a solid base for the documentation design.

Thanks also for the guys at [Materialize CSS](http://materializecss.com) for the CSS and Javascript used in this documentation, as well as their beautiful website design.

Thanks for [Algolia](https://community.algolia.com/docsearch/) for the implementation of the search component and its easy installation.

Thanks also to all the [contributors](https://github.com/ChrisRM/material-theme-jetbrains/graphs/contributors) that helped in the development!

And of course thanks to Jetbrains for their IDEs, Google for their Material Design, Disqus for the comments plugin, Travis CI, JFormDesigner for the UI Designer plugin, [Vladsch](http://vladsch.com/product/markdown-navigator) for his Markdown navigator plugin, and of course all the other plugin creators for the plugins I use for development.

#### Pledgers

Last but not least, a big thanks to all the backers! Thanks to their contribution I've been able to purchase a license for the IDEs and plugins to help me work better and spread the word.

<div markdown="0" class="multi-column-3">
{% for contributor in site.data.contributors %}
<li>{{ contributor.name }}</li>
{% endfor %}
</div>
