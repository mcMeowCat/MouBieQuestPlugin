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

package moubiequest.core.itemstack.gui.ui;

import moubiequest.api.data.quest.PlayerQuestDataFile;
import moubiequest.api.itemstack.gui.button.PlayerDataUItem;
import moubiequest.api.itemstack.gui.button.PlayerUItem;
import moubiequest.api.itemstack.gui.button.UItem;
import moubiequest.api.itemstack.gui.quest.QuestGUIBuilder;
import moubiequest.api.itemstack.gui.QuestView;
import moubiequest.api.manager.QuestManager;
import moubiequest.api.quest.Quest;
import moubiequest.api.quest.QuestType;
import moubiequest.api.yaml.plugin.InventoryFile;
import moubiequest.core.itemstack.gui.button.PlayerQuestDataBuilder;
import moubiequest.core.itemstack.gui.button.UItemStackBuilder;
import moubiequest.main.MouBieCat;
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
        implements QuestGUIBuilder {

    protected static final int PLAYER_QUEST_DATA_BUTTON = 49;

    protected static final int INVENTORY_PREVIOUS_PAGE_BUTTON = 52;
    protected static final int INVENTORY_NEXT_PAGE_BUTTON = 53;

    protected static final int INVENTORY_QUEST_ALL_BUTTON = 3;
    protected static final int INVENTORY_QUEST_SUCCESS_BUTTON = 4;
    protected static final int INVENTORY_QUEST_NO_SUCCESS_BUTTON = 5;
    protected static final int INVENTORY_QUEST_RECEIVE_MESSAGE_BUTTON = 48;

    // 介面檔案
    protected final InventoryFile inventoryFile;

    // 顯示方式 (預設=所有)
    protected QuestView viewType = QuestView.ALL;

    // 玩家資料頭顱
    protected final PlayerDataUItem playerUItem;

    // 下一頁按鈕
    protected final UItem nextButton;

    // 上一頁按鈕
    protected final UItem previousButton;

    // 顯示方式按鈕(所有)
    protected final UItem questAllButton;

    // 顯示方式按鈕(完成)
    protected final UItem questSuccessButton;

    // 顯示方式按鈕(未完成)
    protected final UItem questNoSuccessButton;

    // 接收通知按鈕
    protected final UItem questReceiveMessageButton;

    /**
     * 建構子
     * @param inventoryFile 介面檔案
     * @param type 任務類型
     */
    public QuestUInventoryAbstract(final @NotNull InventoryFile inventoryFile, final @NotNull QuestType type) {
        super(inventoryFile.getQuestInventoryTitle(type), InventorySize.SIX);
        this.inventoryFile = inventoryFile;

        // 玩家資料頭顱
        this.playerUItem = new PlayerQuestDataBuilder(PLAYER_QUEST_DATA_BUTTON);

        UItemStackBuilder builder;

        // 解析通用按鈕 (上一頁)
        builder = new UItemStackBuilder(this.inventoryFile.getCommonButton("previous"), INVENTORY_PREVIOUS_PAGE_BUTTON);
        this.previousButton = builder;

        // 解析通用按鈕 (下一頁)
        builder = new UItemStackBuilder(this.inventoryFile.getCommonButton("next"), INVENTORY_NEXT_PAGE_BUTTON);
        this.nextButton = builder;

        // 解析通用按鈕 (顯示方式按鈕(所有))
        builder = new UItemStackBuilder(this.inventoryFile.getCommonButton("quest_all"), INVENTORY_QUEST_ALL_BUTTON);
        this.questAllButton = builder;

        // 解析通用按鈕 (顯示方式按鈕(完成))
        builder = new UItemStackBuilder(this.inventoryFile.getCommonButton("quest_success"), INVENTORY_QUEST_SUCCESS_BUTTON);
        this.questSuccessButton = builder;

        // 解析通用按鈕 (顯示方式按鈕(未完成))
        builder = new UItemStackBuilder(this.inventoryFile.getCommonButton("quest_no_success"), INVENTORY_QUEST_NO_SUCCESS_BUTTON);
        this.questNoSuccessButton = builder;

        // 解析通用按鈕 (顯示通知)
        builder = new UItemStackBuilder(this.inventoryFile.getCommonButton("quest_receive_message"), INVENTORY_QUEST_RECEIVE_MESSAGE_BUTTON);
        this.questReceiveMessageButton = builder;
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
                .addUItem(this.questNoSuccessButton)
                .addUItem(this.questReceiveMessageButton);

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
    public final @NotNull QuestView getViewType() {
        return this.viewType;
    }

    /**
     * 設定當前的顯示方式類型
     * @param viewType 顯示方式
     */
    public final void setViewType(final @NotNull QuestView viewType) {
        this.resetPage();
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
            case ALL:
                for (final T quest : manager.getQuests())
                    if (!quest.isQuestVisible() || quest.isSuccess(player))
                        quests.add(quest);
                break;
            case SUCCESS:
                for (final T quest : manager.getQuests())
                    if (quest.isSuccess(player))
                        quests.add(quest);
                break;
            case NO_SUCCESS:
                for (final T quest : manager.getQuests())
                    if (!quest.isQuestVisible() && !quest.isSuccess(player))
                        quests.add(quest);
                break;
        }
        return quests;
    }

    /**
     * 代表當介面被點擊的事件
     * @param event 介面點擊事件
     */
    @Override
    public void clickInventory(final @NotNull InventoryClickEvent event) {
        super.clickInventory(event);

        final HumanEntity whoClicked = event.getWhoClicked();

        if (whoClicked instanceof final Player clickPlayer && event.getCurrentItem() != null) {
            final int slot = event.getSlot();

            // 上一頁
            if (slot == INVENTORY_PREVIOUS_PAGE_BUTTON) {
                this.previousPage(clickPlayer);
                clickPlayer.playSound(clickPlayer.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1f, 1f);
            }

            // 下一頁
            else if (slot == INVENTORY_NEXT_PAGE_BUTTON) {
                this.nextPage(clickPlayer);
                clickPlayer.playSound(clickPlayer.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1f, 1f);
            }

            // 顯示全部任務
            else if (slot == INVENTORY_QUEST_ALL_BUTTON) {
                this.setViewType(QuestView.ALL);
                this.initPageInventory(clickPlayer, this.getPage());
                clickPlayer.playSound(clickPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
            }

            // 只顯示完成任務
            else if (slot == INVENTORY_QUEST_SUCCESS_BUTTON) {
                this.setViewType(QuestView.SUCCESS);
                this.initPageInventory(clickPlayer, this.getPage());
                clickPlayer.playSound(clickPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
            }

            // 只顯示未完成任務
            else if (slot == INVENTORY_QUEST_NO_SUCCESS_BUTTON) {
                this.setViewType(QuestView.NO_SUCCESS);
                this.initPageInventory(clickPlayer, this.getPage());
                clickPlayer.playSound(clickPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
            }

            // 改變通知
            else if (slot == INVENTORY_QUEST_RECEIVE_MESSAGE_BUTTON) {
                final PlayerQuestDataFile dataFile =
                        MouBieCat.getInstance().getPlayerDataManager().get(clickPlayer);
                dataFile.setReceiveMessage(!dataFile.isReceiveMessage());
                this.initPageInventory(clickPlayer, this.getPage());
                clickPlayer.playSound(clickPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
            }

        }
    }

}
