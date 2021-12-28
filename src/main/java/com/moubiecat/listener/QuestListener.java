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

package com.moubiecat.listener;

import com.moubiecat.api.data.PlayerQuestDataFile;
import com.moubiecat.api.event.PlayerChangedTitleEvent;
import com.moubiecat.api.event.QuestSuccessEvent;
import com.moubiecat.api.quests.Quest;
import com.moubiecat.MouBieCat;
import com.moubiecat.api.yaml.plugin.FormatFile;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 有關一般任務事件
 * @author MouBieCat
 */
public final class QuestListener
        implements Listener {

    /**
     * 替換佔位符
     * @param msg 訊息
     * @param player 玩家
     * @param quest 任務
     * @return 轉換後的字串
     */
    @NotNull
    private String replace(final @NotNull String msg, final @NotNull Player player, final @NotNull Quest quest) {
        String newMsg = msg;
        newMsg = newMsg.replace("{PLAYER_NAME}", player.getName());
        newMsg = newMsg.replace("{QUEST_TITLE}", quest.getQuestTitle());
        return newMsg;
    }

    /**
     * 當玩家達成任務時調用
     * @param event 事件
     */
    @EventHandler
    public void onPlayerQuestSuccess(final @NotNull QuestSuccessEvent event) {
        final Quest quest = event.getQuest();
        final Player player = event.getPlayer();

        final String msg = this.replace(MouBieCat.getInstance().getMessageFile().getSuccessQuest(), player, quest);

        for (final Player serverPlayer : Bukkit.getOnlinePlayers()) {
            final PlayerQuestDataFile dataFile = MouBieCat.getInstance().getPlayerDataManager().get(serverPlayer);
            if (dataFile.isReceiveMessage() || serverPlayer == player)
                player.sendMessage(MouBieCat.PLUGIN_TITLE + msg);
        }
    }

    /**
     * 當玩家完成變更稱號時調用
     * @param event 事件
     */
    @EventHandler
    public void onPlayerChangedTitle(final @NotNull PlayerChangedTitleEvent event) {
        final Player player = event.getPlayer();
        final Quest quest = event.getQuest();

        final String msg = this.replace(MouBieCat.getInstance().getMessageFile().getChangedQuestTitle(), player, quest);
        player.sendMessage(MouBieCat.PLUGIN_TITLE + msg);
    }

    /**
     * 玩家發言事件
     * @param event 事件
     */
    @EventHandler(priority = EventPriority.LOWEST)
    public void onChat(final @NotNull PlayerChatEvent event) {
        final Player player = event.getPlayer();
        String format = event.getFormat();

        final FormatFile formatFile = MouBieCat.getInstance().getFormatFile();
        final PlayerQuestDataFile dataFile = MouBieCat.getInstance().getPlayerDataManager().get(player);

        final String replaceFormat = formatFile.getTitleReplaceFormat();
        final String honorPointTitleFormat = formatFile.getHonorPointTitleFormat(dataFile.getHonorPoint());

        if (dataFile.getPlayerTitle() != null) {
            final String replace = honorPointTitleFormat.replace("{TITLE}", dataFile.getPlayerTitle().getTitle());

            format = format.replace(replaceFormat, replace);
        } else
            format = format.replace(replaceFormat, "");

        event.setFormat(format);
    }

}
