---
layout: docs
title: File Status Colors
description: Customize File Status Colors
group: configuration
toc: true
comments: true

previous:
  url: '/docs/configuration/excluded-files-colors'
  title: Excluded Files Colors
next:
  url: '/docs/configuration/accents'
  title: Accents
---

These settings allow you to customize the file status colors on a per color scheme basis.
{:class='title'}

{% include carbonads.html %}

## Introduction

__File Status Colors__ is a feature of the IDE to colorize certain parts of the UI displaying a file according to its status. Some of the most obvious examples are:
- Project View
- Editor Tabs
- Recent Files
- Navigate to file/class/symbol
- etc...

By status means relatively to version control systems, such as modified files, newly added files, deleted files, ignored files or conflicted files, for instance.

Originally these color settings were found inside the `Color Schemes` section of the settings, allowing color schemes designers to set their own file status colors, but at some point Jetbrains decided to remove this ability, having judged that it doesn't make sense to have colors affecting the UI found inside settings affecting the editor.

While it does make sense, it was still a good thing to let people change these colors according to their themes. Agreed, Jetbrains doesn't have custom UI Themes support, but why wouldn't the ++Monokai theme++ creator change the `Modified Files` color to his shade of cyan? Or the `Conflicted files` to his shade of magenta? A lot of scheme designers supplied those colors so why remove this feature?

So after reconsideration, Jetbrains decided to let people customize file colors anyway, but instead of a per-color scheme basis, it is now **per-application basis**, and not provided by color scheme designers.

Therefore this ability has now moved under **Version Control** -> **File Status Colors**. But because these colors are related to the UI (e.g. IntelliJ or Darcula Look And Feel), these are not independant standalone settings but instead coupled to the relevant ++look and feel++. That means that those colors are found inside **IntelliJ or Darcula Color Scheme** rather than inside application settings.

But here, at Material Theme, decided to restore that feature to again allow color scheme designers to provided their own set of file status colors!

## Material File Colors

These settings are not found inside the `Material Theme Settings` but instead in a specific section of the `Color Schemes`, just like before.

{% include figure.html content="/screens/fileStatusColors.png" caption="Material File Status Colors" %}

There you can override the File Status Colors from the _IntelliJ/Darcula_ color scheme to the ones specified by the color scheme.

Here's an explanation of the file statuses:

| Title                    | Material Color            | Explanation                                               |
|:-------------------------|:--------------------------|:----------------------------------------------------------|
| Added                    | #C3E88D (green)           | New file added to the repository in active changelist     |
| Added outside            | #C3E88D (green)           | New file added to the repository in non-active changelist |
| Changelist conflict      | #d5756c (red)             | File modified in two changelists                          |
| Copied                   | #C3E88D (green)           | File copied (Mercurial only)                              |
| Deleted                  | #808080 (gray)            | File removed from the repository                          |
| Deleted from FS          | #808080 (gray)            | File deleted from the file system                         |
| Have changed descendants | #80cbc4 (cyan)            | Directory has recursively changed files (not used)        |
| Have immediate changed   | #80cbc4 (cyan)            | Directory has immediate changed descendants (not used)    |
| Hijacked                 | #ffcb6b (yellow)          | File is modified without editing (Perforce only)          |
| Ignored                  | #ab7967 (brown)           | File is ignored                                           |
| Ignored (ignore plugin)  | #ab7967 (brown)           | File is ignored by the .ignore plugin                     |
| Merged                   | #C792EA (violet)          | File is modified by a merge                               |
| Merged with conflicts    | #d5756c (red)             | File has conflicts                                        |
| Modified                 | #80cbcf (cyan)            | File modified in active changelist                        |
| Modified outside         | #82AAFF (blue)            | File modified in non-active changelist                    |
| Obsolete                 | #ffcb6b (yellow)          | File is obsolete (SVN only)                               |
| Renamed                  | #80CBC4 (cyan)            | File renamed (Mercurial only)                             |
| Switched                 | #C792EA (violet)          | File from another branch (SVN only)                       |
| Suppressed               | #546E7A (comments color)  | File from a Virtual File System (like Scratches)          |
| Unknown                  | #d5756c (red)             | Unversioned file                                          |
| Up to date               | none (default tree color) | File unchanged                                            |

&nbsp;

Other statuses may come from 3rd-party plugins and will have the default color provided by the plugin.

**Note**: Because this feature overrides the one from the IDE, changing colors via the regular screen (VCS -> File Status Colors) doesn't make sense and will be overriden the next time you change the color scheme. So please use the `Material File Colors` from now on, even if you are on Darcula or a custom color scheme.
{:class='card-panel'}

## Advanced customization

If you're a color scheme designer and want to make use of this feature for your color scheme, please insert those keys inside your `.icls` or `.xml` file (after replacing the values). Note that if you already defined colors when the IDE feature was still working, it will work again when using the plugin.

```xml
  <colors>
        <option name="FILESTATUS_ADDED" value="C3E88D"/>
        <option name="FILESTATUS_COPIED" value="C3E88D"/>
        <option name="FILESTATUS_DELETED" value="808080"/>
        <option name="FILESTATUS_HIJACKED" value="ffcb6b"/>
        <option name="FILESTATUS_IDEA_FILESTATUS_DELETED_FROM_FILE_SYSTEM" value="808080"/>
        <option name="FILESTATUS_IDEA_FILESTATUS_IGNORED" value="ab7967"/>
        <option name="FILESTATUS_IDEA_SVN_FILESTATUS_EXTERNAL" value="c3e88d"/>
        <option name="FILESTATUS_IGNORE.PROJECT_VIEW.IGNORED" value="ab7967"/>
        <option name="FILESTATUS_MERGED" value="C792EA"/>
        <option name="FILESTATUS_MODIFIED" value="80cbc4"/>
        <!--<option name="FILESTATUS_NOT_CHANGED" value="626669"/>-->
        <option name="FILESTATUS_NOT_CHANGED_IMMEDIATE" value="80cbc4"/>
        <option name="FILESTATUS_NOT_CHANGED_RECURSIVE" value="80cbc4"/>
        <option name="FILESTATUS_SWITCHED" value="C792EA"/>
        <option name="FILESTATUS_SUPPRESSED" value="979FAD"/>
        <option name="FILESTATUS_UNKNOWN" value="f77669"/>
        <option name="FILESTATUS_addedOutside" value="C3E88D"/>
        <option name="FILESTATUS_changelistConflict" value="d5756c"/>
        <option name="FILESTATUS_modifiedOutside" value="82AAFF"/>
  </colors>
  ```

## Caveats

Because this feature modifies the original `VCS File Colors` feature, please bear in mind the following issues:
- When switching to other scheme that do not define file status colors, some defaults will be applied which are not the defaults provided by Darcula/IntelliJ, and therefore look bad.
- Uninstalling/Disabling the plugin will not revert back these settings, so you will still keep the last file colors even after restarting.

Thankfully there is an easy fix for that: in the `VCS File Colors` there is a button _Reset Default_ that will revert the value back to the Darcula/IntelliJ default. **Note however that as soon as you change a color scheme the values will change back again.**

{% include figure.html content="/screens/restoreDefault.png" caption="Restore Default" %}
