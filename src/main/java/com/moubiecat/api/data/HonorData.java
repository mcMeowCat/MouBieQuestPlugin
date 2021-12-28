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

package com.moubiecat.api.data;

import com.moubiecat.api.quests.Quest;
import org.jetbrains.annotations.NotNull;

/**
 * 有關操控玩家的點數介面
 * @author MouBieCat
 */
public interface HonorData {

    /**
     * 添加點數
     * @param quest 任務
     */
    void addHonorPoint(final @NotNull Quest quest);

    /**
     * 減去點數
     * @param quest 任務
     */
    void subHonorPoint(final @NotNull Quest quest);

    /**
     * 設定玩家目前的榮譽點數數量
     * @param point 數量
     */
    void setHonorPoint(final int point);

    /**
     * 獲取玩家目前的榮譽點數數量
     * @return 數量
     */
    int getHonorPoint();

}
