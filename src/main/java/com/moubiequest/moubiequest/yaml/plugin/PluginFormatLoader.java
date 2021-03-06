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

package com.moubiequest.moubiequest.yaml.plugin;

import com.moubiequest.api.quests.Quest;
import com.moubiequest.api.quests.QuestType;
import com.moubiequest.api.yaml.plugin.FormatLoader;
import com.moubiequest.moubiequest.quests.object.Title;
import com.moubiequest.moubiequest.yaml.MouBieQuestPluginFileLoader;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 代表該插件的嵌入式文件(Format.yml)
 * @author MouBieCat
 */
public final class PluginFormatLoader
        extends MouBieQuestPluginFileLoader
        implements FormatLoader {

    private static final String FORMAT_QUEST_FORMAT_MAIN_PATH = "QuestFormat.";
    private static final String FORMAT_QUEST_HEAD_FORMAT_PATH = ".head";
    private static final String FORMAT_QUEST_BODY_FORMAT_PATH = ".body";

    private static final String FORMAT_PLAYER_DATA_HEAD_FORMAT_PATH = "PlayerQuestHead.head";
    private static final String FORMAT_PLAYER_DATA_BODY_FORMAT_PATH = "PlayerQuestHead.body";

    private static final String FORMAT_QUEST_TYPE_PATH = "Format.quest_type.";
    private static final String FORMAT_QUEST_ENABLE_PATH = "Format.quest_enable.";
    private static final String FORMAT_QUEST_VISIBLE_PATH = "Format.quest_visible.";
    private static final String FORMAT_QUEST_SUCCESS_PATH = "Format.success.";
    private static final String FORMAT_PROGRESS_QUEST_PERCENTAGE_IMAGE_PATH = "Format.percentage_image.";

    private static final String PLAYER_DATA_USE_TITLE = "Format.player_title.nothing";
    private static final String PLAYER_DATA_RECEIVE_MESSAGE = "Format.receive_message.";

    private static final String FORMAT_CHAT_TITLE_REPLACE = "HonorPointFormat.Format";

    private static final String FORMAT_HONOR_POINT_FORMAT = "HonorPointFormat";

    /**
     * 建構子
     */
    public PluginFormatLoader() {
        super("", "Format.yml", false);
    }

    /**
     * 獲取任務類型的字串
     * @param type 任務類型
     * @return 字串
     */
    @NotNull
    public String getQuestTypeString(final @NotNull QuestType type) {
        return this.getString(FORMAT_QUEST_TYPE_PATH + type.getName(), true);
    }

    /**
     * 獲取任務開放狀態的字串
     * @param isEnable 是否啟用
     * @return 字串
     */
    @NotNull
    public String getQuestEnableString(final boolean isEnable) {
        return this.getString(FORMAT_QUEST_ENABLE_PATH + isEnable, true);
    }

    /**
     * 獲取任務隱藏狀態的字串
     * @param isVisible 是否隱藏
     * @return 字串
     */
    @NotNull
    public String getQuestVisibleString(final boolean isVisible) {
        return this.getString(FORMAT_QUEST_VISIBLE_PATH + isVisible, true);
    }

    /**
     * 獲取玩家應該看到的任務訊息
     * @param quest 任務
     * @param player 玩家
     * @return 字串
     */
    @NotNull
    public String getPlayerQuestMessageString(final @NotNull Quest quest, final @NotNull Player player) {
        return quest.isSuccess(player) ? quest.getQuestSuccessMessage() : quest.getQuestMessage();
    }

    /**
     * 獲取任務進行中或是達成的訊息
     * @param isSuccess 是否完成
     * @return 字串
     */
    @NotNull
    public String getQuestSuccessString(final boolean isSuccess) {
        return this.getString(FORMAT_QUEST_SUCCESS_PATH + isSuccess, true);
    }

    /**
     * 獲取任務引王狀態的字串
     * @param progressNumber 百分比
     * @return 字串
     */
    @NotNull
    public String getQuestProgressImage(final int progressNumber) {
        for(int i = 100; i >= 0; i -= 10)
            if(progressNumber >= i)
                return this.getString(FORMAT_PROGRESS_QUEST_PERCENTAGE_IMAGE_PATH + i, true);

        return "§4ERROR";
    }

    /**
     * 獲取任務的介面物品標題
     * @param quest 任務
     * @return 字串
     */
    @NotNull
    public String getFormatHead(final @NotNull Quest quest) {
        return this.getString(
                FORMAT_QUEST_FORMAT_MAIN_PATH +
                        quest.getQuestType().getName() +
                        FORMAT_QUEST_HEAD_FORMAT_PATH,
                true
        );
    }

    /**
     * 獲取任務的介面物品說明
     * @param quest 任務
     * @return 字串
     */
    @NotNull
    public List<String> getFormatBody(final @NotNull Quest quest) {
        return this.getStringList(
                FORMAT_QUEST_FORMAT_MAIN_PATH +
                        quest.getQuestType().getName() +
                        FORMAT_QUEST_BODY_FORMAT_PATH,
                true
        );
    }

    /**
     * 獲取任務隱藏狀態的字串
     * @param isReceiveMessage 是否接收
     * @return 字串
     */
    @NotNull
    public String getPlayerReceiveMessageString(final boolean isReceiveMessage) {
        return this.getString(PLAYER_DATA_RECEIVE_MESSAGE + isReceiveMessage, true);
    }

    /**
     * 獲取玩家當前使用的稱號
     * @param title 稱號
     * @return 字串
     */
    @NotNull
    public String getPlayerUseTitle(final @Nullable Title title) {
        return title != null ? title.getTitle() : this.getString(PLAYER_DATA_USE_TITLE, true);
    }

    /**
     * 獲取任務開放狀態的字串
     * @return 字串
     */
    @NotNull
    public String getPlayerDataFormatHead() {
        return this.getString(FORMAT_PLAYER_DATA_HEAD_FORMAT_PATH, true);
    }

    /**
     * 獲取任務的介面物品說明
     *
     * @return 字串
     */
    @NotNull
    public List<String> getPlayerDataFormatBody() {
        return this.getStringList(FORMAT_PLAYER_DATA_BODY_FORMAT_PATH, true);
    }

    /**
     * 獲取替換稱號的格式
     * @return 格式
     */
    @NotNull
    public String getTitleReplaceFormat() {
        return this.getString(FORMAT_CHAT_TITLE_REPLACE, true);
    }

    /**
     * 獲取玩家的榮譽點數到達的稱號格式顯示等級
     * @param playerHonorPoint 玩家持有點數
     * @return 格式
     */
    @NotNull
    public String getHonorPointTitleFormat(final int playerHonorPoint) {
        final ConfigurationSection honorPointFormat =
                this.getConfiguration().getConfigurationSection(FORMAT_HONOR_POINT_FORMAT + ".Ranks");

        if (honorPointFormat != null)
            for (final String str : honorPointFormat.getKeys(false)) {
                final int point = Integer.parseInt(str);
                if (playerHonorPoint >= point)
                    return this.getString(FORMAT_HONOR_POINT_FORMAT + ".Ranks." + str, true);
            }

        return this.getString(FORMAT_HONOR_POINT_FORMAT + ".default", true);
    }

}
