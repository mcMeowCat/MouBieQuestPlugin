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

import com.moubiequest.api.yaml.plugin.MessageLoader;
import com.moubiequest.moubiequest.yaml.MouBieQuestPluginFileLoader;
import org.jetbrains.annotations.NotNull;

/**
 * 代表該插件的嵌入式文件(Message.yml)
 * @author MouBieCat
 */
public final class PluginMessageLoader
        extends MouBieQuestPluginFileLoader
        implements MessageLoader {

    public static final String MESSAGE_CHANGED_QUEST_TITLE = "ChangedQuestTitle";

    public static final String MESSAGE_SUCCESS_MESSAGE = "SuccessQuest";

    /**
     * 建構子
     */
    public PluginMessageLoader() {
        super("", "Message.yml", false);
    }

    /**
     * 獲取改變更號的訊息
     * @return 訊息
     */
    @NotNull
    public String getChangedQuestTitle() {
        return this.getString(MESSAGE_CHANGED_QUEST_TITLE, true);
    }

    /**
     * 獲取達成任務時的訊息
     * @return 訊息
     */
    @NotNull
    public String getSuccessQuest() {
        return this.getString(MESSAGE_SUCCESS_MESSAGE, true);
    }

}
