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

package com.moubiequest.api.manager;

import com.moubieapi.api.manager.PlayerManager;
import com.moubiequest.api.data.PlayerQuestDataFile;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表玩家任務紀錄經理
 * @author MouBieCat
 */
public interface QuestDataManager
        extends PlayerManager<PlayerQuestDataFile> {

    /**
     * 或取一個玩家的任務資料
     * @param player 玩家
     * @return v
     */
    @NotNull PlayerQuestDataFile get(final @NotNull Player player);

}
