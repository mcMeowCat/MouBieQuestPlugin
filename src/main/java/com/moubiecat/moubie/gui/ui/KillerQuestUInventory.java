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

package com.moubiecat.moubie.gui.ui;

import com.moubiecat.api.gui.button.QuestUItem;
import com.moubiecat.api.gui.ui.KillerQuestGUI;
import com.moubiecat.api.quests.KillerQuest;
import com.moubiecat.api.quests.QuestType;
import com.moubiecat.moubie.gui.QuestUInventoryAbstract;
import com.moubiecat.moubie.gui.button.KillerUItemBuilder;
import com.moubiecat.MouBieCat;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 代表一個擊殺任務選單
 * @author MouBieCat
 */
public final class KillerQuestUInventory
        extends QuestUInventoryAbstract
        implements KillerQuestGUI {

    /**
     * 建構子
     */
    public KillerQuestUInventory() {
        super(MouBieCat.getInstance().getInventoryFile(), QuestType.KILLER);
    }

    /**
     * 初始化介面
     * @param player 玩家
     * @param page   頁數
     */
    @Override
    protected void initPageInventory(final @NotNull Player player, final int page) {
        // 先回去運行基本代碼
        super.initPageInventory(player, page);

        // 如果頁數 >0 則添加上一頁按鈕
        if (page > 0) this.addUItem(this.previousButton);

        // 任務排序結果
        final List<KillerQuest> sortQuests = this.getSortQuests(MouBieCat.getInstance().getKillerQuestManager(), player);

        try {
            // 如果沒有任何任務，顯示空任務按鈕
            if (sortQuests.size() == 0)
                this.addUItem(this.questShowNothingButton);

            else {
                // 計算迴圈任務起始
                int startQuest = page * 36;

                // 迴圈開始編排任務
                for (int slot = 9; slot < 45; slot++) {
                    final KillerQuest quest = sortQuests.get(startQuest++);
                    this.addUItem(new KillerUItemBuilder(quest, slot), player);
                }
            }
        } catch (final IndexOutOfBoundsException e) { return; }

        // 沒有 IndexOutOfBoundsException 意外也就代表還有更多任務需要顯示。因此添加下一頁按鈕
        this.addUItem(this.nextButton);
    }

    /**
     * 代表當介面被點擊的事件
     * @param event 介面點擊事件
     * @return 回傳false不繼續運行
     */
    @Override
    public boolean clickInventory(final @NotNull InventoryClickEvent event) {
        if (!super.clickInventory(event))
            return false;

        final HumanEntity whoClicked = event.getWhoClicked();
        final ItemStack currentItem = event.getCurrentItem();

        if (whoClicked instanceof final Player clickPlayer && currentItem != null) {
            // 獲取物品按鈕上的任務專屬名稱
            final String itemStackQuestKey = QuestUItem.getItemStackQuestKey(currentItem);
            final KillerQuest killerQuest = MouBieCat.getInstance().getKillerQuestManager().get(itemStackQuestKey);

            // 如果任務不為空、嘗試套用稱號成功
            if (killerQuest != null && killerQuest.setPlayerTitle(clickPlayer))
                this.initPageInventory(clickPlayer, this.getPage());
        }

        return false;
    }

}
