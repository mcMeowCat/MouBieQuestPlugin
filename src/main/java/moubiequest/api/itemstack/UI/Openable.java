package moubiequest.api.itemstack.UI;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個開啟介面的方法
 * @author MouBieCat
 */
public interface Openable {

    /**
     * 開啟介面
     * @param player 玩家
     */
    void open(final @NotNull Player player);

}
