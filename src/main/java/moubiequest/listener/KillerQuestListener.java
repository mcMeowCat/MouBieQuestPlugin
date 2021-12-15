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

import moubiequest.api.quest.KillerQuest;
import moubiequest.main.MouBieCat;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 有關擊殺任務的事件都在這
 * @author MouBieCat
 */
public class KillerQuestListener
        implements Listener {

    /**
     * 實體死亡事件
     * @param event 事件
     */
    @EventHandler
    public void onKiller(final @NotNull EntityDeathEvent event) {
        final LivingEntity entity = event.getEntity();
        final Player killer = entity.getKiller();
        if (killer != null) {
            for (final KillerQuest quest : MouBieCat.getInstance().getKillerQuestManager().getQuests())
                if (quest.checkEntityType(entity.getType()))
                    quest.addPlayerQuestProgress(killer);
        }
    }

}
