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

package com.cat.moubiequest.api.gui.ui;

import com.cat.moubiequest.api.gui.button.PlayerUItem;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個受編輯的任務操作介面
 * @author MouBieCat
 */
public interface QuestGUIBuilder
        extends GUIBuilder, QuestGUI {

    /**
     * 添加一個按鈕到介面
     * @param uItem 介面物品實例
     * @param player 玩家
     */
    void addUItem(final @NotNull PlayerUItem uItem, final @NotNull Player player);

}
