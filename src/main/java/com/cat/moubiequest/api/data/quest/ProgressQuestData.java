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

package com.cat.moubiequest.api.data.quest;

import com.cat.moubiequest.api.quests.ProgressQuest;
import org.jetbrains.annotations.NotNull;

/**
 * 有關操作玩家進度任務的資料介面
 * @author MouBieCat
 */
public interface ProgressQuestData {

    /**
     * 獲取玩家當前的進度
     * @param quest 任務
     * @return 進度次數
     */
    int getProgress(final @NotNull ProgressQuest quest);

    /**
     * 設定玩家當前的進度
     * @param quest 任務
     * @param progress 進度次數
     */
    void setProgress(final @NotNull ProgressQuest quest, final int progress);

}
