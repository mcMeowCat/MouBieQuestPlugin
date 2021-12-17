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

package com.cat.moubiequest.moubie.quests.object;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 用於儲存任務稱號套用相關的物件
 * @author MouBieCat
 */
public final class Title {

    // 任務稱號名稱
    private final String quest_title;

    /**
     * 建構子
     * @param title 稱號
     */
    public Title(final @NotNull String title) {
        this.quest_title = title;
    }

    /**
     * 獲取稱號名
     * @return 稱號
     */
    @NotNull
    public String getTitle() {
        return quest_title;
    }

    /**
     * 套用稱號至玩家
     * @param player 玩家
     */
    public void usingTitleForPlayer(final @NotNull Player player) {
        //wait code....
    }

}
