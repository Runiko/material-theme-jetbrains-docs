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

import com.chrisrm.idea.themes.*;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public enum MTThemes implements MTThemesInterface {
  OCEANIC("OCEANIC", new MTOceanicTheme()),
  DARKER("DARKER", new MTDarkerTheme()),
  LIGHTER("LIGHTER", new MTLighterTheme()),
  PALENIGHT("PALENIGHT", new MTPalenightTheme()),
  CUSTOM("CUSTOM", new MTCustomTheme()),
  LIGHT_CUSTOM("LIGHT_CUSTOM", new MTLightCustomTheme()),
  MONOKAI("MONOKAI", new MonokaiTheme()),
  ARC_DARK("ARC_DARK", new ArcDarkTheme()),
  ONE_DARK("ONE_DARK", new OneDarkTheme());

  // Insert all our enum values into a THEMES_MAP
  private static final Map<String, MTThemesInterface> THEMES_MAP = new TreeMap<>();

  static {
    for (final MTThemesInterface theme : values()) {
      THEMES_MAP.put(theme.getName(), theme);
    }
  }

  private final String name;
  private final MTTheme mtTheme;

  MTThemes(final String name, final MTTheme mtTheme) {
    this.name = name;
    this.mtTheme = mtTheme;
  }

  @Override
  public String getEditorColorsScheme() {
    return mtTheme.getEditorColorsScheme();
  }

  @Override
  public MTTheme getTheme() {
    return mtTheme;
  }

  @Override
  public boolean isDark() {
    return mtTheme.isDark();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getId() {
    return mtTheme.getId();
  }

  public static MTThemesInterface getThemeFor(final String themeName) {
    return THEMES_MAP.get(themeName);
  }

  public static void addTheme(final MTThemesInterface themesInterface) {
    if (!THEMES_MAP.containsKey(themesInterface.getName())) {
      THEMES_MAP.put(themesInterface.getName(), themesInterface);
    }
  }

  public static Collection<MTThemesInterface> getAllThemes() {
    return THEMES_MAP.values();
  }
}
