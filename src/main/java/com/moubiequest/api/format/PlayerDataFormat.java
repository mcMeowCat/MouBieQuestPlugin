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

package com.moubiequest.api.format;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 有關轉換玩家紀錄的站位符介面
 * @author MouBoeCat
 */
public interface PlayerDataFormat
        extends FormatReplacer<Player> {

    /**
     * 將文字的站位符轉換
     * @param msg 訊息格式
     * @param player 轉換的玩家資訊
     */
    @Deprecated
    @NotNull String replace(final @NotNull String msg, final @NotNull Player player);

    /**
     * 將文字集合的站位符轉換
     * @param list 訊息格式
     * @param player 轉換的玩家資訊
     * @return 轉換後的文字集合
     */
    @Deprecated
    @NotNull List<String> replaceList(final @NotNull List<String> list, final @NotNull Player player);

    /**
     * 將文字的站位符轉換
     * @param msg 訊息格式
     */
    @NotNull String replace(final @NotNull String msg);

    /**
     * 將文字集合的站位符轉換
     * @param list 訊息格式
     * @return 轉換後的文字集合
     */
    @NotNull List<String> replaceList(final @NotNull List<String> list);

}
