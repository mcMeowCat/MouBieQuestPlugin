package moubiequest.listener;

import moubiequest.api.itemstack.gui.quest.KillerQuestGUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

/**
 * 有關介面事件監聽都在這
 * @author MouBieCat
 */
public final class InventoryListener
        implements Listener {

    /**
     * 選單被擊事件
     * @param event 事件
     */
    @EventHandler
    public void onClick(final @NotNull InventoryClickEvent event) {
        final InventoryHolder holder = event.getInventory().getHolder();

        if (holder instanceof KillerQuestGUI)
            ((KillerQuestGUI)holder).clickInventory(event);
    }

}
