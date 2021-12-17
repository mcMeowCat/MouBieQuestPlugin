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

package com.cat.moubiequest.listener;

import com.cat.moubiequest.moubie.data.PlayerQuestData;
import com.cat.moubiequest.MouBieCat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 有關於玩家資料的事件監聽都在這
 * @author MouBieCat
 */
public final class PlayerDataListener
        implements Listener {

    /**
     * 玩家加入伺服器事件
     * @param event 事件
     */
    @EventHandler
    public void onJoin(final @NotNull PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        MouBieCat.getInstance().getPlayerDataManager().add(player, new PlayerQuestData(player));
    }

    /**
     * 玩家離開伺服器事件
     * @param event 事件
     */
    @EventHandler
    public void onQuit(final @NotNull PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        MouBieCat.getInstance().getPlayerDataManager().remove(player);
    }

}
