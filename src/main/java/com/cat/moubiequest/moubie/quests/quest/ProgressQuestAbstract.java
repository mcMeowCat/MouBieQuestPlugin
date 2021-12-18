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

package com.cat.moubiequest.moubie.quests.quest;

import com.cat.moubiequest.api.MouBieQuest;
import com.cat.moubiequest.api.data.quest.PlayerQuestDataFile;
import com.cat.moubiequest.api.quests.ProgressQuest;
import com.cat.moubiequest.api.quests.QuestType;
import com.cat.moubiequest.api.event.PlayerQuestSuccessEvent;
import com.cat.moubiequest.moubie.quests.object.Message;
import com.cat.moubiequest.moubie.quests.object.QItem;
import com.cat.moubiequest.moubie.quests.object.Status;
import com.cat.moubiequest.moubie.quests.object.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個帶有進度的任務類
 * @author MouBieCat
 */
public abstract class ProgressQuestAbstract
        extends QuestAbstract
        implements ProgressQuest {

    protected final int quest_progress;

    /**
     * 建構子
     * @param quest_type        任務類型
     * @param quest_key         任務識別名稱
     * @param quest_title       任務稱號
     * @param quest_message     任務消息
     * @param quest_status      任務狀態
     * @param quest_honor_point 任務榮譽點數
     * @param quest_progress 任務所需的進度次數
     */
    public ProgressQuestAbstract(final @NotNull QuestType quest_type,
                                 final @NotNull String quest_key,
                                 final @NotNull Title quest_title,
                                 final @NotNull Message quest_message,
                                 final @NotNull Status quest_status,
                                 final @NotNull QItem item,
                                 final int quest_honor_point,
                                 final int quest_progress) {
        super(quest_type, quest_key, quest_title, quest_message, quest_status, item, quest_honor_point);
        this.quest_progress = quest_progress;
    }

    /**
     * 或取進度任務需達成的次數
     * @return 所需次數
     */
    public final int getQuestProgress() {
        return this.quest_progress;
    }

    /**
     * 對玩家添加進度一次
     * @param player 玩家
     * @return 是否成功添加
     */
    public final boolean addPlayerQuestProgress(final @NotNull Player player) {
        if (this.isQuestEnable() && !this.isSuccess(player)) {
            final PlayerQuestDataFile dataFile = MouBieQuest.getAPI().getQuestData().get(player);
            dataFile.setProgress(this, this.getPlayerQuestProgress(player) + 1);

            // 當完達成時呼叫(僅限一次)
            if (this.getPlayerQuestProgress(player) == this.quest_progress) {
                Bukkit.getPluginManager().callEvent(new PlayerQuestSuccessEvent(player, this));
                dataFile.addHonorPoint(this);
            }

            return true;
        }
        return false;
    }

    /**
     * 對玩家進度清除歸零
     * @param player 玩家
     */
    public final void clearPlayerQuestProgress(final @NotNull Player player) {
        final PlayerQuestDataFile dataFile = MouBieQuest.getAPI().getQuestData().get(player);
        dataFile.setProgress(this, 0);
    }

    /**
     * 獲取該玩家目前達到的進度水平
     * @param player 玩家
     * @return 進度次數
     */
    public final int getPlayerQuestProgress(final @NotNull Player player) {
        final PlayerQuestDataFile dataFile = MouBieQuest.getAPI().getQuestData().get(player);
        return dataFile.getProgress(this);
    }

    /**
     * 判定玩家該任務是否已經達成
     * @param player 玩家
     * @return 是否達成
     */
    @Override
    public boolean isSuccess(final @NotNull Player player) {
        return (this.getPlayerQuestProgress(player) >= this.quest_progress);
    }

}
