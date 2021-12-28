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

package com.moubiecat.api.event;

import com.moubiecat.api.quests.ProgressQuest;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 當玩家的進度任務被清除時調用
 * @author MouBieCat
 */
public final class PlayerProgressClearEvent
        extends PlayerQuestEvent<ProgressQuest> {

    private static final HandlerList handlers = new HandlerList();

    /**
     * 建構子
     * @param quest 事件任務
     * @param who   玩家
     */
    public PlayerProgressClearEvent(final @NotNull ProgressQuest quest, final @NotNull Player who) {
        super(quest, who);
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return PlayerProgressClearEvent.handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return PlayerProgressClearEvent.handlers;
    }

}
