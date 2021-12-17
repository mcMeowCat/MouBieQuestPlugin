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

package com.cat.moubiequest.api.event;

import com.cat.moubiequest.api.quests.Quest;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 有關玩家任務事件
 * @author MouBieCat
 */
public abstract class PlayerQuestEvent
        extends PlayerEvent {

    private final Quest quest;

    public PlayerQuestEvent(final @NotNull Player who, final @NotNull Quest quest) {
        super(who);
        this.quest = quest;
    }

    @NotNull
    public final Quest getQuest() {
        return this.quest;
    }

}
