package moubiequest.listener;

import moubiequest.api.itemstack.gui.quest.QuestGUI;
import moubiequest.core.itemstack.gui.ui.KillerQuestUInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 有關任務事件的基本監聽都在這
 * @author MouBieCat
 */
public final class QuestListener
        implements Listener {

    /**
     * 當玩家對伺服器發送消息時
     * @param event 事件
     */
    @EventHandler
    public void onChat(final @NotNull AsyncPlayerChatEvent event) {
//        final Player player = event.getPlayer();
//        final TitleData titleData = MouBieCat.getInstance().getPlayerDataManager().get(player);
//        final String replace = event.getFormat().replace("{PLAYER_TITLE}", titleData.getPlayerTitleName());
//        event.setFormat(replace);
    }

    @EventHandler
    public void onDrop(final @NotNull PlayerDropItemEvent event) {
        final Player player = event.getPlayer();
        event.setCancelled(true);
        QuestGUI gui = new KillerQuestUInventory();
        gui.open(player, 0);
    }

}
