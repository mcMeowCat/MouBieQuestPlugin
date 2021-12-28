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

package com.moubiequest.api.gui.button;

import com.moubiequest.api.quests.Quest;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個任務介面按鈕
 * @param <T> 繼承 Quest
 * @author MouBieCat
 */
public interface QuestUItem<T extends Quest>
        extends PlayerUItem {

    /**
     * 獲取按鈕代表的任務
     * @return 任務
     */
    @NotNull T getQuest();

}
