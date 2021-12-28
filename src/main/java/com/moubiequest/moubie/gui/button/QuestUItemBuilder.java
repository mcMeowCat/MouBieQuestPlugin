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

package com.moubiequest.moubie.gui.button;

import com.moubieapi.api.builder.NBTBuilder;
import com.moubieapi.moubieapi.inventory.UItemStackBuilder;
import com.moubieapi.moubieapi.itemstack.NBTTagBuilder;
import com.moubiequest.api.gui.button.QuestUItem;
import com.moubiequest.api.quests.Quest;
import com.moubiequest.api.quests.QuestType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一任務介面上的按鈕
 * @param <T> 繼承 Quest
 * @author MouBieCat
 */
public abstract class QuestUItemBuilder<T extends Quest>
        extends UItemStackBuilder
        implements QuestUItem<T> {

    // 任務介面物品主要TAG
    private static final String UI_ITEM_QUEST_MAIN_TAG = "UI_ITEM_QUEST_MAIN_TAG";

    // 任務介面物品任務類型TAG
    private static final String UI_ITEM_QUEST_QUEST_TYPE_TAG = "QUEST_TYPE";
    // 任務介面物品任務名稱TAG
    private static final String UI_ITEM_QUEST_QUEST_KEY_TAG = "QUEST_KEY";

    // 任務
    protected final T quest;

    /**
     * 建構子
     * @param quest 代表任務
     * @param slot 介面位置
     */
    public QuestUItemBuilder(final @NotNull T quest, final int slot) {
        super(quest.getQuestItemMaterial(), slot);
        this.quest = quest;
    }

    /**
     * 獲取按鈕代表的任務
     * @return 任務
     */
    @NotNull
    public final T getQuest() {
        return this.quest;
    }

    /**
     * 解析物品上的任務類型
     * @param itemStack 物品
     * @return 類型
     */
    @Nullable
    public static QuestType getItemStackQuestType(final @NotNull ItemStack itemStack) {
        if (NBTTagBuilder.hasTag(itemStack, UI_ITEM_QUEST_MAIN_TAG))
            return QuestType.valueOf(
                    NBTTagBuilder.getString(itemStack, UI_ITEM_QUEST_MAIN_TAG, UI_ITEM_QUEST_QUEST_TYPE_TAG)
            );

        return null;
    }

    /**
     * 解析物品上的任務識別名稱
     * @param itemStack 物品
     * @return 識別名稱
     */
    @NotNull
    public static String getItemStackQuestKey(final @NotNull ItemStack itemStack) {
        if (NBTTagBuilder.hasTag(itemStack, UI_ITEM_QUEST_MAIN_TAG))
            return NBTTagBuilder.getString(itemStack, UI_ITEM_QUEST_MAIN_TAG, UI_ITEM_QUEST_QUEST_KEY_TAG);

        return "";
    }

    /**
     * 將物品建置出來
     * @return 物品
     */
    @NotNull
    public final ItemStack build() {
        final NBTBuilder nbtTagBuilder = new NBTTagBuilder(UI_ITEM_QUEST_MAIN_TAG);

        // 配置 TAG 屬性
        nbtTagBuilder.setString(UI_ITEM_QUEST_QUEST_TYPE_TAG, this.quest.getQuestType().getName())
                .setString(UI_ITEM_QUEST_QUEST_KEY_TAG, this.quest.getQuestKey());

        // 寫入到物品中
        this.itemStack = nbtTagBuilder.build(this.itemStack);

        return super.build();
    }

}
