package moubiequest.api.itemstack.gui.quest;

import moubiequest.api.itemstack.gui.GUI;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 有關玩家狀態設定的選單介面
 * @author MouBieCat
 */
public interface PlayerStatusGUI
        extends GUI {

    /**
     * 獲取是誰的狀態介面
     * @return 玩家
     */
    @NotNull Player getPlayer();

}
