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

package com.cat.moubiequest.api.quests;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個任務的基礎
 * @author MouBieCat
 */
public interface Quest {

    /**
     * 獲取該任務的任務類型
     * @return 任務類型
     */
    @NotNull QuestType getQuestType();

    /**
     * 獲取該任務的識別名稱
     * @return 識別名稱
     */
    @NotNull String getQuestKey();

    /**
     * 獲取該任務的稱號名稱
     * @return 稱號名稱
     */
    @NotNull String getQuestTitle();

    /**
     * 獲取任務進行中的消息
     * @return 消息
     */
    @NotNull String getQuestMessage();

    /**
     * 獲取任務的完成式消息
     * @return 消息
     */
    @NotNull String getQuestSuccessMessage();

    /**
     * 該任務是否開放中
     * @return 是否開放
     */
    boolean isQuestEnable();

    /**
     * 該任務是否被隱藏中
     * @return 是否隱藏
     */
    boolean isQuestVisible();

    /**
     * 設置該任務是否開啟
     * @param isEnable 狀態
     */
    void setQuestEnable(final boolean isEnable);

    /**
     * 設置該任務是否隱藏
     * @param isVisible 狀態
     */
    void setQuestVisible(final boolean isVisible);

    /**
     * 獲取材質
     * @return 材質
     */
    @NotNull Material getQuestItemMaterial();

    /**
     * 獲取該任務的榮譽點數
     * @return 點數值
     */
    int getQuestHonorPoint();

    /**
     * 該玩家是否達成了任務
     * @param player 玩家
     */
    boolean isSuccess(final @NotNull Player player);

    /**
     * 設定玩家的稱號
     * @param player 玩家
     * @return 是否設定成功
     */
    boolean setPlayerTitle(final @NotNull Player player);

}
