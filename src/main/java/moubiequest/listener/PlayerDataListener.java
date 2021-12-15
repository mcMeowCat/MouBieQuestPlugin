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

package moubiequest.listener;

import moubiequest.core.data.quest.PlayerQuestData;
import moubiequest.main.MouBieCat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
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

    /**
     * 玩家說話事件
     * @param event 事件
     */
    @EventHandler(priority = EventPriority.LOWEST)
    public void onChat(final @NotNull PlayerChatEvent event) {
//        Bukkit.getLogger().info("call");
//
//        final Player player = event.getPlayer();
//        final PlayerQuestDataFile dataFile =
//                MouBieCat.getInstance().getPlayerDataManager().get(player);
//
//        final Title playerTitle = dataFile.getPlayerTitle();
//        final String replaceMessage;
//        if (playerTitle != null) {
//            replaceMessage = event.getMessage().replace(
//                    MouBieCat.getInstance().getFormatFile().getTitleReplaceFormat(),
//                    playerTitle.getTitle()
//            );
//
//        } else {
//            replaceMessage = event.getMessage().replace(
//                    MouBieCat.getInstance().getFormatFile().getTitleReplaceFormat(),
//                    ""
//            );
//        }
//        event.setMessage(replaceMessage);
    }

}
