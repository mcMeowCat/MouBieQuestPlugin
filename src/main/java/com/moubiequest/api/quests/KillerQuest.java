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

package com.moubiequest.api.quests;

import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個擊殺生物任務介面
 * @author MouBieCat
 */
public interface KillerQuest
        extends ProgressQuest {

    /**
     * 獲取任務所需擊殺的生物類型
     * @return 生物類型
     */
    @NotNull EntityType getKillEntity();

    /**
     * 檢查該生物類型是否符合
     * @param type 生物類型
     * @return 是否符合
     */
    boolean checkEntityType(final @NotNull EntityType type);

}
