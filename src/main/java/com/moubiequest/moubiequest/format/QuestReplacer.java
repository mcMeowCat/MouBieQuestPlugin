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

package com.moubiequest.moubiequest.format;

import com.moubiequest.api.format.QuestFormat;
import com.moubiequest.api.quests.Quest;
import com.moubiequest.api.yaml.plugin.FormatLoader;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表將一個任務的格式訊息轉換
 * @param <T> 繼承 任務
 * @author MouBieCat
 */
public abstract class QuestReplacer<T extends Quest>
        extends FormatAbstract<T>
        implements QuestFormat<T> {

    /**
     * ## 通用占位符 ## (Base Quest)
     * # {QUEST_KEY} - 任務專有名稱
     * # {QUEST_TYPE} - 任務類型
     * # {QUEST_TITLE} - 任務稱號
     * # {QUEST_HONOR_POINT} - 任務榮譽點數
     * # {QUEST_RECORD_POINT} - 任務戰績點數
     * # {QUEST_MESSAGE_PLAYER} - 玩家應該看到哪種任務說明 (QUEST_MESSAGE) or (QUEST_SUCCESS_MESSAGE)
     * # {QUEST_MESSAGE} - 任務進行中消息
     * # {QUEST_SUCCESS_MESSAGE} - 任務達成後消息
     * # {QUEST_ENABLE} - 任務是否可進行 (詳見下面設定)
     * # {QUEST_VISIBLE} - 任務是否隱藏 (詳見下面設定)
     * # {QUEST_IS_SUCCESS} - 是否達成任務 (詳見下面設定)
     */
    private static final String QUEST_KEY = "{QUEST_KEY}";
    private static final String QUEST_TYPE = "{QUEST_TYPE}";
    private static final String QUEST_TITLE = "{QUEST_TITLE}";
    private static final String QUEST_HONOR_POINT = "{QUEST_HONOR_POINT}";
    private static final String QUEST_MESSAGE_PLAYER = "{QUEST_MESSAGE_PLAYER}";
    private static final String QUEST_MESSAGE = "{QUEST_MESSAGE}";
    private static final String QUEST_SUCCESS_MESSAGE = "{QUEST_SUCCESS_MESSAGE}";
    private static final String QUEST_ENABLE = "{QUEST_ENABLE}";
    private static final String QUEST_VISIBLE = "{QUEST_VISIBLE}";
    private static final String QUEST_IS_SUCCESS = "{QUEST_IS_SUCCESS}";

    /**
     * 建構子
     * @param obj 轉換物件
     * @param file 讀取格式的檔案
     */
    public QuestReplacer(final @NotNull T obj, final @NotNull FormatLoader file) {
        super(obj, file);
    }

    /**
     * 將文字的站位符轉換
     * @param msg    訊息格式
     * @param player 傳患的玩家資訊
     */
    @NotNull
    public String replace(final @NotNull String msg, final @NotNull Player player) {
        String replaceStr = msg;

        // 轉換任務識別名稱
        replaceStr = replaceStr.replace(
                QUEST_KEY,
                this.replacer.getQuestKey()
        );

        // 轉換任務類型名稱
        replaceStr = replaceStr.replace(
                QUEST_TYPE,
                this.formatFile.getQuestTypeString(this.replacer.getQuestType())
        );

        // 轉換任務稱號名稱
        replaceStr = replaceStr.replace(
                QUEST_TITLE,
                this.replacer.getQuestTitle()
        );

        // 轉換任務榮譽點數
        replaceStr = replaceStr.replace(
                QUEST_HONOR_POINT,
                ""+this.replacer.getQuestHonorPoint()
        );

        // 轉換玩家當前看到的任務說明
        replaceStr = replaceStr.replace(
                QUEST_MESSAGE_PLAYER,
                this.formatFile.getPlayerQuestMessageString(this.replacer, player)
        );

        // 轉換任務進行中的說明
        replaceStr = replaceStr.replace(
                QUEST_MESSAGE,
                this.replacer.getQuestMessage()
        );

        // 轉換任務達成的說明
        replaceStr = replaceStr.replace(
                QUEST_SUCCESS_MESSAGE,
                this.replacer.getQuestSuccessMessage()
        );

        // 轉換任次是否開啟
        replaceStr = replaceStr.replace(
                QUEST_ENABLE,
                this.formatFile.getQuestEnableString(this.replacer.isQuestEnable())
        );

        // 轉換任務是否隱藏
        replaceStr = replaceStr.replace(
                QUEST_VISIBLE,
                this.formatFile.getQuestVisibleString(this.replacer.isQuestVisible())
        );

        // 轉換任務是否成功
        replaceStr = replaceStr.replace(
                QUEST_IS_SUCCESS,
                this.formatFile.getQuestSuccessString(this.replacer.isSuccess(player))
        );

        return replaceStr;
    }

}
