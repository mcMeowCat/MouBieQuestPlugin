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

package com.moubiecat.api;

import com.moubiecat.MouBieCat;
import com.moubiecat.api.manager.NMSManager;
import com.moubiecat.api.manager.PlayerDataManager;
import com.moubiecat.moubie.manager.handler.HandlerManager;
import com.moubiecat.moubie.manager.player.PlayerQuestDataManager;
import org.jetbrains.annotations.NotNull;

/**
 * 代表該插件相關的API方法定義
 * @author MouBieCat
 */
public final class MouBieQuest {

    // 代表玩家紀錄經理
    @NotNull
    private final PlayerDataManager playerDataManager;

    // 代表 nms 經理
    @NotNull
    private final NMSManager nmsManager;

    public MouBieQuest() {
        this.nmsManager = new HandlerManager();
        this.playerDataManager = new PlayerQuestDataManager();
    }

    /**
     * 獲取玩家紀錄經理
     * @return 玩家紀錄經理
     */
    @NotNull
    public PlayerDataManager getQuestData() {
        return this.playerDataManager;
    }

    /**
     * 獲取 nms 經理
     * @return nms
     */
    @NotNull
    public NMSManager getNMS() {
        return this.nmsManager;
    }

    /**
     * 獲取插件定義的API
     * @return API
     */
    @NotNull
    public static MouBieQuest getAPI() {
        return MouBieCat.getAPI();
    }

}
