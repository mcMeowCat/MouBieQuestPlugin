/**
 * LICENSE
 * MouBieQuest
 * -------------
 * Copyright (C) 2021 MouBieCat(MouBie_Yuki)
 * -------------
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 */

package com.moubiecat.moubie.yaml.plugin;

import com.moubiecat.api.yaml.plugin.PluginFile;
import com.moubiecat.moubie.yaml.Loader;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個最基礎的插件嵌入式檔案載入器
 * @author MouBieCat
 */
public abstract class PluginLoader
        extends Loader
        implements PluginFile {

    /**
     * 建構子
     * @param path      檔案路徑
     * @param name      檔案
     */
    public PluginLoader(final @NotNull String path, final @NotNull String name) {
        super(path, name, false);
    }

}
