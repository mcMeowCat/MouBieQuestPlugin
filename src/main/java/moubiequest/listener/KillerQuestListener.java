package moubiequest.listener;

import moubiequest.api.quest.KillerQuest;
import moubiequest.core.itemstack.gui.ui.KillerQuestUInventory;
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

            new KillerQuestUInventory().open(killer, 0);
        }

    }

}
