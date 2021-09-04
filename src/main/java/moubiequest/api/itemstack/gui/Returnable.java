package moubiequest.api.itemstack.gui;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個擁有返回上一層介面的功能
 * @author MouBieCat
 */
public interface Returnable {

    /**
     * 返回上一層介面
     * @param player 玩家
     */
    void backGUI(final @NotNull Player player);

    /**
     * 獲取返回的介面
     * @return 介面
     */
    @NotNull GUI getReturnGUI();

}
