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

package com.moubiecat.moubie.yaml;

import com.moubiecat.api.yaml.FileLoader;
import org.jetbrains.annotations.NotNull;

/**
 * 一個最基礎功能的檔案加載器 可被其他類繼承功能
 * @author MouBieCat
 */
public class Loader
        extends YamlModuleAbstract
        implements FileLoader {

    /**
     * 建構子
     * @param path      檔案路徑
     * @param name      檔案
     * @param isNewFile 是否新創建
     */
    public Loader(final @NotNull String path, final @NotNull String name, final boolean isNewFile) {
        super(path, name, isNewFile);
    }

    /**
     * 可用於重載
     */
    public void loadFile() {
        this.load();
    }

    /**
     * 可用於保存
     */
    public void saveFile() {
        this.save();
    }

}
