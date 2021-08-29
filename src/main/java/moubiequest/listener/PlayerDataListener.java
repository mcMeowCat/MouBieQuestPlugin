package moubiequest.listener;

import moubiequest.api.itemstack.gui.quest.QuestGUI;
import moubiequest.core.data.quest.PlayerQuestData;
import moubiequest.core.itemstack.gui.ui.KillerQuestUInventory;
import moubiequest.main.MouBieCat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
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

    @EventHandler
    public void onDropItem(final @NotNull PlayerDropItemEvent event) {
        final Player player = event.getPlayer();
        if (player.isSneaking()) {
            event.setCancelled(true);
            QuestGUI gui = new KillerQuestUInventory();
            gui.open(player, 0);
        }
    }

}
