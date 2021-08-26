package moubiequest.api.itemstack.gui.ui;

import moubiequest.api.itemstack.gui.Pageable;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個有多頁數的介面
 * @author MouBieCat
 */
public interface PageGUI
        extends Pageable, GUI {

    /**
     * 開啟介面
     * @param player 玩家
     */
    @Deprecated
    void open(final @NotNull Player player);

    /**
     * 開啟一個特定頁數
     * @param player 玩家
     * @param page 頁數
     */
    void open(final @NotNull Player player, final int page);

}
