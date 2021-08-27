package moubiequest.api.itemstack.gui.button;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個有關玩家建置的物品按鈕
 * @author MouBieCat
 */
public interface PlayerUItem
        extends UItem {

    /**
     * 將物品建置出來
     * @return 物品
     */
    @Deprecated
    @NotNull ItemStack build();

    /**
     * 將物品建置出來
     * @param player 玩家
     * @return 物品
     */
    @NotNull ItemStack build(final @NotNull Player player);

}
