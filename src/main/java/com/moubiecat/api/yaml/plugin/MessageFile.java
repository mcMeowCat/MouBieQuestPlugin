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

package com.moubiecat.api.yaml.plugin;

import com.moubiecat.api.yaml.PluginLoader;
import org.jetbrains.annotations.NotNull;

/**
 * 代表該插件的嵌入式文件(Message.yml)
 * @author MouBieCat
 */
public interface MessageFile
        extends PluginLoader {

    /**
     * 獲取改變更號的訊息
     * @return 訊息
     */
    @NotNull String getChangedQuestTitle();

    /**
     * 獲取達成任務時的訊息
     * @return 訊息
     */
    @NotNull String getSuccessQuest();

}
