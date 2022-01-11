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

package com.moubiequest.moubiequest.quests.object;

import org.jetbrains.annotations.NotNull;

/**
 * 用於儲存任務所有的消息物件
 * @author MouBieCat
 */
public final class Message {

    // 任務達成顯示的消息
    private final String quest_success_message;

    // 任務進行中顯示的消息
    private final String quest_message;

    /**
     * 建構子
     * @param successMessage 任務完成式訊息
     * @param message 任務進行中訊息
     */
    public Message(final @NotNull String successMessage, final @NotNull String message) {
        this.quest_success_message = successMessage;
        this.quest_message = message;
    }

    /**
     * 獲取任務完成式訊息
     * @return 成功訊息
     */
    public String getSuccessMessage() {
        return quest_success_message;
    }

    /**
     * 獲取任務進行中訊息
     * @return 進行中訊息
     */
    public String getMessage() {
        return quest_message;
    }

}
