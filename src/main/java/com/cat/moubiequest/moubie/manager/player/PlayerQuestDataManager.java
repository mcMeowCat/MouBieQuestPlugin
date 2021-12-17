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

package com.cat.moubiequest.moubie.manager.player;

import com.cat.moubiequest.api.data.quest.PlayerQuestDataFile;
import com.cat.moubiequest.api.manager.PlayerDataManager;
import com.cat.moubiequest.moubie.data.PlayerQuestData;
import com.cat.moubiequest.moubie.manager.DataManagerAbstract;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 用於紀錄玩家的任務資料管理器
 * @author MouBieCat
 */
public final class PlayerQuestDataManager
        extends DataManagerAbstract<Player, PlayerQuestDataFile>
        implements PlayerDataManager {

    /**
     * 或取一個玩家的任務資料
     * @param player 玩家
     * @return v
     */
    @NotNull
    public PlayerQuestDataFile get(final @NotNull Player player) {
        final PlayerQuestDataFile dataFile = super.get(player);
        if (dataFile != null)
            return dataFile;

        this.add(player, new PlayerQuestData(player));
        return this.get(player);
    }

}
