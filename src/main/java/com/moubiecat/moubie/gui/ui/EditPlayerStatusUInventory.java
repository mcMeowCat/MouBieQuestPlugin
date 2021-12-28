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

import com.moubiecat.api.MouBieQuest;
import com.moubiecat.api.data.quest.PlayerQuestDataFile;
import com.moubiecat.api.gui.button.Button;
import com.moubiecat.api.gui.ui.EditStatusGUI;
import com.moubiecat.api.gui.ui.QuestGUI;
import com.moubiecat.api.yaml.plugin.InventoryFile;
import com.moubiecat.moubie.gui.UInventoryAbstract;
import com.moubiecat.moubie.gui.button.UItemStackBuilder;
import com.moubiecat.MouBieCat;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個玩家有關任務狀態的設定介面
 * @author MouBieCat
 */
public final class EditPlayerStatusUInventory
        extends UInventoryAbstract
        implements EditStatusGUI {

    private static final int INVENTORY_QUEST_CLEAR_TITLE_BUTTON = 10;
    private static final int INVENTORY_QUEST_RECEIVE_MESSAGE_BUTTON = 11;
    private static final int INVENTORY_BACK_INVENTORY_BUTTON = 31;

    // 清除套用稱號
    @NotNull
    private final Button questClearTitleButton;

    // 接收通知按鈕
    @NotNull
    private final Button questReceiveMessageButton;

    // 返回介面按鈕
    @NotNull
    private final Button backInventoryButton;

    // 代表上一層介面
    @NotNull
    private final QuestGUI backer;

    /**
     * 建構子
     * @param player 玩家
     * @param backer 返回介面
     */
    public EditPlayerStatusUInventory(final @NotNull Player player, final @NotNull QuestGUI backer) {
        super(player.getName(), InventorySize.FOUR);
        this.backer = backer;

        final InventoryFile inventoryFile = MouBieCat.getInstance().getInventoryFile();

        UItemStackBuilder builder;

        // 解析通用按鈕 (清除套用稱號)
        builder = new UItemStackBuilder(inventoryFile.getCommonButton("quest_clear_title"), INVENTORY_QUEST_CLEAR_TITLE_BUTTON);
        this.questClearTitleButton = builder;

        // 解析通用按鈕 (顯示通知)
        builder = new UItemStackBuilder(inventoryFile.getCommonButton("quest_receive_message"), INVENTORY_QUEST_RECEIVE_MESSAGE_BUTTON);
        this.questReceiveMessageButton = builder;

        // 解析通用按鈕 (返回上一層介面)
        builder = new UItemStackBuilder(inventoryFile.getCommonButton("backer"), INVENTORY_BACK_INVENTORY_BUTTON);
        this.backInventoryButton = builder;
    }

    /**
     * 初始化介面
     * @param player 玩家
     */
    @Override
    protected void initInventory(final @NotNull Player player) {
        // 添加基本按鈕
        this.addUItem(this.questReceiveMessageButton)
                .addUItem(this.questClearTitleButton)
                .addUItem(this.backInventoryButton);
    }

    /**
     * 獲取返回介面
     * @return 返回介面
     */
    @NotNull
    public QuestGUI getBacker() {
        return this.backer;
    }

    /**
     * 返回上一層介面
     * @param player 玩家
     */
    public void goBack(final @NotNull Player player) {
        this.backer.open(player, this.backer.getPage());
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
                // 清除稱號套用
                case INVENTORY_QUEST_CLEAR_TITLE_BUTTON -> {
                    final PlayerQuestDataFile dataFile =
                            MouBieQuest.getAPI().getQuestData().get(clickPlayer);
                    dataFile.setPlayerTitle(null);

                    this.initInventory(clickPlayer);
                    clickPlayer.playSound(clickPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                    return false;
                }

                // 更改通知狀態
                case INVENTORY_QUEST_RECEIVE_MESSAGE_BUTTON -> {
                    final PlayerQuestDataFile dataFile =
                            MouBieQuest.getAPI().getQuestData().get(clickPlayer);
                    dataFile.setReceiveMessage(!dataFile.isReceiveMessage());

                    this.initInventory(clickPlayer);
                    clickPlayer.playSound(clickPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                    return false;
                }

                // 返回上一層介面
                case INVENTORY_BACK_INVENTORY_BUTTON -> {
                    this.goBack(clickPlayer);
                    clickPlayer.playSound(clickPlayer.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1f, 1f);
                    return false;
                }
            }
        }

        return true;
    }

}
