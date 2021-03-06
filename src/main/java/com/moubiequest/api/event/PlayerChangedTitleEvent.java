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

package com.moubiequest.api.event;

import com.moubiequest.api.quests.Quest;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 代表玩家已經成功修改稱號
 * @author MouBieCat
 */
public final class PlayerChangedTitleEvent
        extends PlayerQuestEvent<Quest> {

    private static final HandlerList handlers = new HandlerList();

    /**
     * 建構子
     * @param quest 事件任務
     * @param who   玩家
     */
    public PlayerChangedTitleEvent(final @NotNull Quest quest, final @NotNull Player who) {
        super(quest, who);
    }

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return PlayerChangedTitleEvent.handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return PlayerChangedTitleEvent.handlers;
    }

}
