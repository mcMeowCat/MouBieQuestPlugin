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

package com.moubiecat.api.gui.button;

import com.moubiecat.api.quests.Quest;
import com.moubiecat.api.quests.QuestType;
import com.moubiecat.moubie.gui.button.QuestUItemBuilder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

    /**
     * 解析物品上的任務類型
     * @param itemStack 物品
     * @return 類型
     */
    static @Nullable QuestType getItemStackQuestType(final @NotNull ItemStack itemStack) {
        return QuestUItemBuilder.getItemStackQuestType(itemStack);
    }

    /**
     * 解析物品上的任務識別名稱
     * @param itemStack 物品
     * @return 識別名稱
     */
    static @NotNull String getItemStackQuestKey(final @NotNull ItemStack itemStack) {
        return QuestUItemBuilder.getItemStackQuestKey(itemStack);
    }

}
