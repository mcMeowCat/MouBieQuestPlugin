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

import moubiequest.api.data.quest.PlayerQuestDataFile;
import moubiequest.api.quest.Quest;
import moubiequest.api.yaml.plugin.FormatFile;
import moubiequest.core.event.PlayerChangedTitleEvent;
import moubiequest.core.event.PlayerQuestSuccessEvent;
import moubiequest.core.quest.objects.Title;
import moubiequest.main.MouBieCat;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
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
public class QuestListener
        implements Listener {

    /**
     * 當玩家達成任務時調用
     * @param event 事件
     */
    @EventHandler
    public void onPlayerQuestSuccess(final @NotNull PlayerQuestSuccessEvent event) {
        final Quest quest = event.getQuest();
        final Player player = event.getPlayer();

        String changedQuestTitle = MouBieCat.getInstance().getMessageFile().getSuccessQuest();
        changedQuestTitle = changedQuestTitle.replace("{PLAYER_NAME}", player.getName());
        changedQuestTitle = changedQuestTitle.replace("{QUEST_TITLE}", quest.getQuestTitle());

        for (final Player serverPlayer : Bukkit.getOnlinePlayers()) {
            final PlayerQuestDataFile dataFile = MouBieCat.getInstance().getPlayerDataManager().get(serverPlayer);
            if (dataFile.isReceiveMessage())
                player.sendMessage(MouBieCat.PLUGIN_TITLE + changedQuestTitle);
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

        String changedQuestTitle = MouBieCat.getInstance().getMessageFile().getChangedQuestTitle();
        changedQuestTitle = changedQuestTitle.replace("{PLAYER_NAME}", player.getName());
        changedQuestTitle = changedQuestTitle.replace("{QUEST_TITLE}", quest.getQuestTitle());

        player.sendMessage(MouBieCat.PLUGIN_TITLE + changedQuestTitle);
        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 1f, 1f);
    }

    /**
     * 玩家發言事件
     * @param event 事件
     */
    @EventHandler(priority = EventPriority.LOWEST)
    public void onChat(final @NotNull PlayerChatEvent event) {
        Player player = event.getPlayer();
        String format = event.getFormat();

        final PlayerQuestDataFile dataFile = MouBieCat.getInstance().getPlayerDataManager().get(player);
        final Title playerTitle = dataFile.getPlayerTitle();

        final FormatFile formatFile = MouBieCat.getInstance().getFormatFile();

        if (playerTitle != null) {
            final String honorPointTitleFormat = formatFile.getHonorPointTitleFormat(dataFile.getHonorPoint())
                    .replace("{TITLE}", playerTitle.getTitle());

            format = format.replace(formatFile.getTitleReplaceFormat(), honorPointTitleFormat);
        } else
            format = format.replace(formatFile.getTitleReplaceFormat(), "");

        event.setFormat(format);
    }

}
