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

package com.moubiecat.api.yaml.quests;

import com.moubiecat.api.quests.Quest;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 任務解析器介面
 * @param <T> 繼承 Quest
 * @author MouBieCat
 */
public interface QuestLoader<T extends Quest> {

    /**
     * 解析檔案內容轉換成任務格式
     * @return 解析的任務集合
     */
    @NotNull List<T> parsing();

}
