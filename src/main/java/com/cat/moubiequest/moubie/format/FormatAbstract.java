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

package com.cat.moubiequest.moubie.format;

import com.cat.moubiequest.api.format.FormatReplacer;
import com.cat.moubiequest.api.yaml.plugin.FormatFile;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 代表一個基礎佔位符格式轉換介面
 * @param <T> 任何類型
 * @author MouBieCat
 */
public abstract class FormatAbstract<T>
        implements FormatReplacer<T> {

    // 轉換的物件
    protected final T replacer;

    // 讀取格式的文件
    protected final FormatFile formatFile;

    /**
     * 建構子
     * @param obj 轉換物件
     * @param file 格式檔案
     */
    public FormatAbstract(final @NotNull T obj, final @NotNull FormatFile file) {
        this.replacer = obj;
        this.formatFile = file;
    }

    /**
     * 將文字集合的站位符轉換
     * @param list   訊息格式
     * @param player 轉換的玩家資訊
     * @return 轉換後的文字集合
     */
    @NotNull
    public final List<String> replaceList(final @NotNull List<String> list, final @NotNull Player player) {
        final List<String> newList = new ArrayList<>();

        // 迴圈轉換所有字串
        for (String str : list)
            newList.add(this.replace(str, player));

        return newList;
    }

    /**
     * 獲取轉換的物件類型
     * @return 轉換的物件
     */
    @NotNull
    public final T getReplacer() {
        return this.replacer;
    }

}
