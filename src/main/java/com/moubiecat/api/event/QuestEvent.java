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

import com.moubiecat.api.quests.Quest;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個任務事件
 * @param <T> 任務類型
 * @author MouBieCat
 */
public abstract class QuestEvent<T extends Quest>
        extends Event {

    // 任務
    @NotNull
    private final T quest;

    /**
     * 建構子
     * @param quest 事件任務
     */
    public QuestEvent(final @NotNull T quest) {
        this.quest = quest;
    }

    /**
     * 獲取觸發事件的任務
     * @return 任務
     */
    @NotNull
    public final T getQuest() {
        return this.quest;
    }

}
