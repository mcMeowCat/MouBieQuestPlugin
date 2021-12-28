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

package com.moubiecat.moubie.data;

import com.moubiecat.MouBieCat;
import com.moubiecat.api.data.PlayerQuestDataFile;
import com.moubiecat.api.quests.ProgressQuest;
import com.moubiecat.api.quests.Quest;
import com.moubiecat.moubie.quests.object.Title;
import com.moubiecat.moubieapi.yaml.data.PlayerDataLoaderAbstract;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * 玩家的任務資料載入器
 * @author MouBieCat
 */
public final class PlayerQuestData
        extends PlayerDataLoaderAbstract<Player>
        implements PlayerQuestDataFile {

    // 資料實體路徑
    public static final String PLAYER_FLY_DATA_PATH = "player_data";

    // 玩家當前套用的稱號
    @Nullable
    private Title player_title = null;

    // 玩家當前的榮譽點數
    public static final String PLAYER_DATA_PATH_PLAYER_HONOR_POINT = "data.honor_point";
    private int player_honor_point;

    // 是否收到有關任務的訊息
    public static final String PLAYER_DATA_PATH_PLAYER_IS_RECEIVE_MESSAGE = "data.receive_message";
    private boolean player_receive_message;

    // 進度任務路徑
    public static final String PLAYER_DATA_PATH_PROGRESS_QUEST = "progress.";

    /**
     * 建構子
     * @param player 資料擁有人
     */
    public PlayerQuestData(final @NotNull Player player) {
        super(MouBieCat.getInstance(), PLAYER_FLY_DATA_PATH + File.separatorChar, player);
        this.player_honor_point = this.configuration.getInt(PLAYER_DATA_PATH_PLAYER_HONOR_POINT);
        this.player_receive_message = this.configuration.getBoolean(PLAYER_DATA_PATH_PLAYER_IS_RECEIVE_MESSAGE);
        this.initPlayerLoader();
    }

    /**
     * 獲取當前使用的稱號
     * @return 稱號實例
     */
    @Nullable
    public Title getPlayerTitle() {
        return this.player_title;
    }

    /**
     * 設定當前使用的稱號
     * @param title 稱號實例
     */
    public void setPlayerTitle(final @Nullable Title title) {
        this.player_title = title;
    }

    /**
     * 添加點數
     * @param quest 任務
     */
    public void addHonorPoint(final @NotNull Quest quest) {
        this.setHonorPoint(this.player_honor_point + quest.getQuestHonorPoint());
    }

    /**
     * 減去點數 (<0 無條件歸零沒有負數)
     * @param quest 任務
     */
    public void subHonorPoint(final @NotNull Quest quest) {
        final int newPoint = this.player_honor_point - quest.getQuestHonorPoint();
        if (newPoint < 0) {
            this.setHonorPoint(0);
            return;
        }
        this.setHonorPoint(newPoint);
    }

    /**
     * 設定玩家目前的榮譽點數數量
     * @param point 數量
     */
    public void setHonorPoint(final int point) {
        this.player_honor_point = point;
        this.configuration.set(PLAYER_DATA_PATH_PLAYER_HONOR_POINT, this.player_honor_point);
        this.save();
    }

    /**
     * 獲取玩家目前的榮譽點數數量
     *
     * @return 數量
     */
    public int getHonorPoint() {
        return this.player_honor_point;
    }

    /**
     * 獲取玩家是否接收有關任務的訊息
     * @return 是否可看見
     */
    public boolean isReceiveMessage() {
        return this.player_receive_message;
    }

    /**
     * 設定玩家是否接收有關任務的訊息
     * @param status 狀態
     */
    public void setReceiveMessage(final boolean status) {
        this.player_receive_message = status;
        this.configuration.set(PLAYER_DATA_PATH_PLAYER_IS_RECEIVE_MESSAGE, this.player_receive_message);
        this.save();
    }

    /**
     * 獲取玩家當前的進度
     *
     * @param quest 任務
     * @return 進度次數
     */
    public int getProgress(final @NotNull ProgressQuest quest) {
        return this.configuration.getInt(PLAYER_DATA_PATH_PROGRESS_QUEST + quest.getQuestKey());
    }

    /**
     * 設定玩家當前的進度
     *
     * @param quest    任務
     * @param progress 進度次數
     */
    public void setProgress(final @NotNull ProgressQuest quest, final int progress) {
        this.configuration.set(PLAYER_DATA_PATH_PROGRESS_QUEST + quest.getQuestKey(), progress);
        this.save();
    }

    /**
     * 初始化
     */
    @Override
    protected void initPlayerLoader() {
        this.configuration.set(PLAYER_DATA_PATH_PLAYER_HONOR_POINT, this.player_honor_point);
        this.configuration.set(PLAYER_DATA_PATH_PLAYER_IS_RECEIVE_MESSAGE, this.player_receive_message);
        this.save();
    }

}
