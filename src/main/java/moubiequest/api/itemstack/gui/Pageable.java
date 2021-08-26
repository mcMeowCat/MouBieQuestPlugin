package moubiequest.api.itemstack.gui;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個有多頁數的介面
 */
public interface Pageable {

    /**
     * 獲取當前頁數
     * @return 頁數
     */
    int getPage();

    /**
     * 翻至下一頁
     * @param player 玩家
     */
    void nextPage(final @NotNull Player player);

    /**
     * 翻至上一頁
     * @param player 玩家
     */
    void previousPage(final @NotNull Player player);

}
