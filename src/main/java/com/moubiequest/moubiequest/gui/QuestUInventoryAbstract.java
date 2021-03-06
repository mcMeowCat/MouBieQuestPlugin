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

package com.moubiequest.moubiequest.gui;

import com.moubieapi.api.inventory.InventorySize;
import com.moubieapi.api.inventory.Openable;
import com.moubieapi.api.inventory.button.Button;
import com.moubieapi.api.inventory.button.PageButton;
import com.moubieapi.moubieapi.inventory.PageUInventoryAbstract;
import com.moubieapi.moubieapi.inventory.PageUItemStack;
import com.moubieapi.moubieapi.inventory.UItemStackBuilder;
import com.moubiequest.api.gui.button.PlayerUItem;
import com.moubiequest.api.gui.QuestView;
import com.moubiequest.api.gui.ui.QuestGUI;
import com.moubiequest.api.manager.QuestManager;
import com.moubiequest.api.quests.Quest;
import com.moubiequest.api.quests.QuestType;
import com.moubiequest.api.yaml.plugin.InventoryLoader;
import com.moubiequest.moubiequest.gui.button.PlayerQuestDataBuilder;
import com.moubiequest.moubiequest.gui.ui.EditPlayerStatusUInventory;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

/**
 * 代表一個基礎的任務介面操作類
 * @author MouBieCat
 */
public abstract class QuestUInventoryAbstract
        extends PageUInventoryAbstract
        implements QuestGUI {

    protected static final int PLAYER_QUEST_DATA_BUTTON = 49;

    protected static final int INVENTORY_PREVIOUS_PAGE_BUTTON = 52;
    protected static final int INVENTORY_NEXT_PAGE_BUTTON = 53;

    protected static final int INVENTORY_QUEST_ALL_BUTTON = 3;
    protected static final int INVENTORY_QUEST_SUCCESS_BUTTON = 4;
    protected static final int INVENTORY_QUEST_NO_SUCCESS_BUTTON = 5;

    protected static final int INVENTORY_NOTHING_QUESTS_BUTTON = 31;

    // 顯示方式 (預設=所有)
    @NotNull
    protected QuestView viewType = QuestView.ALL;

    // 玩家資料頭顱
    @NotNull
    protected final PlayerUItem playerUItem;

    // 下一頁按鈕
    @NotNull
    protected final PageButton nextButton;

    // 上一頁按鈕
    @NotNull
    protected final PageButton previousButton;

    // 顯示方式按鈕(所有)
    @NotNull
    protected final Button questAllButton;

    // 顯示方式按鈕(完成)
    @NotNull
    protected final Button questSuccessButton;

    // 顯示方式按鈕(未完成)
    @NotNull
    protected final Button questNoSuccessButton;

    // 沒有顯示出任何任務按鈕
    @NotNull
    protected final Button questShowNothingButton;

    /**
     * 建構子
     * @param inventoryFile 介面檔案
     * @param type 任務類型
     */
    public QuestUInventoryAbstract(final @NotNull InventoryLoader inventoryFile, final @NotNull QuestType type) {
        super(inventoryFile.getQuestInventoryTitle(type), InventorySize.SIX);

        // 玩家資料頭顱
        this.playerUItem = new PlayerQuestDataBuilder(PLAYER_QUEST_DATA_BUTTON);

        UItemStackBuilder builder;

        // 解析通用按鈕 (上一頁)
        builder = new PageUItemStack(inventoryFile.getCommonButton("previous"), INVENTORY_PREVIOUS_PAGE_BUTTON);
        this.previousButton = (PageButton) builder;

        // 解析通用按鈕 (下一頁)
        builder = new PageUItemStack(inventoryFile.getCommonButton("next"), INVENTORY_NEXT_PAGE_BUTTON);
        this.nextButton = (PageButton) builder;

        // 解析通用按鈕 (顯示方式按鈕(所有))
        builder = new UItemStackBuilder(inventoryFile.getCommonButton("quest_all"), INVENTORY_QUEST_ALL_BUTTON);
        this.questAllButton = builder;

        // 解析通用按鈕 (顯示方式按鈕(完成))
        builder = new UItemStackBuilder(inventoryFile.getCommonButton("quest_success"), INVENTORY_QUEST_SUCCESS_BUTTON);
        this.questSuccessButton = builder;

        // 解析通用按鈕 (顯示方式按鈕(未完成))
        builder = new UItemStackBuilder(inventoryFile.getCommonButton("quest_no_success"), INVENTORY_QUEST_NO_SUCCESS_BUTTON);
        this.questNoSuccessButton = builder;

        // 解析通用按鈕 (沒有任何任務)
        builder = new UItemStackBuilder(inventoryFile.getCommonButton("nothing_quests"), INVENTORY_NOTHING_QUESTS_BUTTON);
        this.questShowNothingButton = builder;
    }

    /**
     * 初始化介面
     * @param player 玩家
     * @param page   頁數
     */
    @Override
    protected void initPageInventory(final @NotNull Player player, final int page) {
        // 清除介面所有按鈕
        this.clearInventory();

        // 添加基本按鈕
        this.addUItem(this.questAllButton)
                .addUItem(this.questSuccessButton)
                .addUItem(this.questNoSuccessButton);

        // 添加玩家資料頭顱
        this.addUItem(this.playerUItem, player);
    }

    /**
     * 添加一個按鈕到介面
     * @param uItem 介面物品實例
     * @param player 玩家
     */
    public void addUItem(final @NotNull PlayerUItem uItem, final @NotNull Player player) {
        this.addItem(uItem.build(player), uItem.getSlotId());
    }

    /**
     * 獲取當前的顯示方式類型
     * @return 顯示方式
     */
    @NotNull
    public final QuestView getViewType() {
        return this.viewType;
    }

    /**
     * 設定當前的顯示方式類型
     * @param viewType 顯示方式
     */
    public final void setViewType(final @NotNull QuestView viewType) {
        this.restPage();
        this.viewType = viewType;
    }

    /**
     * 獲取當前狀態對任務的排序方式
     * @param manager 任務管理器
     * @param player 玩家
     * @param <T> 繼承 Quest
     * @return 任務排序集合
     */
    @NotNull
    protected final<T extends Quest> List<T> getSortQuests(final @NotNull QuestManager<T> manager, final @NotNull Player player) {
        final List<T> quests = new LinkedList<>();
        switch (this.viewType) {
            case ALL -> {
                for (final T quest : manager.getValues())
                    if (!quest.isQuestVisible() || quest.isSuccess(player))
                        quests.add(quest);
            }

            case SUCCESS -> {
                for (final T quest : manager.getValues())
                    if (quest.isSuccess(player))
                        quests.add(quest);
            }

            case NO_SUCCESS -> {
                for (final T quest : manager.getValues())
                    if (!quest.isQuestVisible() && !quest.isSuccess(player))
                        quests.add(quest);
            }
        }

        return quests;
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

        if (whoClicked instanceof final Player clickPlayer && event.getCurrentItem() != null) {
            final int slot = event.getSlot();

            switch (slot) {
                // 上一頁按鈕
                case INVENTORY_PREVIOUS_PAGE_BUTTON -> {
                    this.previousPage(clickPlayer);
                    clickPlayer.playSound(clickPlayer.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1f, 1f);
                    return false;
                }

                // 下一頁按鈕
                case INVENTORY_NEXT_PAGE_BUTTON -> {
                    this.nextPage(clickPlayer);
                    clickPlayer.playSound(clickPlayer.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1f, 1f);
                    return false;
                }

                // 顯示全部任務
                case INVENTORY_QUEST_ALL_BUTTON -> {
                    this.setViewType(QuestView.ALL);
                    this.initPageInventory(clickPlayer, this.getPage());
                    clickPlayer.playSound(clickPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                    return false;
                }

                // 只顯示完成任務
                case INVENTORY_QUEST_SUCCESS_BUTTON -> {
                    this.setViewType(QuestView.SUCCESS);
                    this.initPageInventory(clickPlayer, this.getPage());
                    clickPlayer.playSound(clickPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                    return false;
                }

                // 只顯示未完成任務
                case INVENTORY_QUEST_NO_SUCCESS_BUTTON -> {
                    this.setViewType(QuestView.NO_SUCCESS);
                    this.initPageInventory(clickPlayer, this.getPage());
                    clickPlayer.playSound(clickPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                    return false;
                }

                case PLAYER_QUEST_DATA_BUTTON -> {
                    final Openable editGUI = new EditPlayerStatusUInventory(clickPlayer, this);
                    editGUI.open(clickPlayer);
                    return false;
                }
            }
        }

        return true;
    }

}
