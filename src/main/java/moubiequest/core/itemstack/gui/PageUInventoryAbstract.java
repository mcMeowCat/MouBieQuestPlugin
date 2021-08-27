package moubiequest.core.itemstack.gui;

import moubiequest.api.itemstack.gui.ui.PageGUI;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個有多頁數的介面建構器
 * @author MouBieCat
 */
public abstract class PageUInventoryAbstract
        extends UInventoryAbstract
        implements PageGUI {

    // 當前頁數 (預設=0)
    private int nowPage = 1;

    /**
     * 建構子
     * @param title 介面標題
     * @param size  介面大小
     */
    public PageUInventoryAbstract(final @NotNull String title, final @NotNull InventorySize size) {
        super(title, size);
    }

    /**
     * 開啟一個特定頁數
     * @param player 玩家
     * @param page   頁數
     */
    public final void open(final @NotNull Player player, final int page) {
        this.initPageInventory(player, page);
        super.open(player);
    }

    /**
     * 獲取當前頁數
     * @return 頁數
     */
    public final int getPage() {
        return this.nowPage;
    }

    /**
     * 翻至下一頁
     * @param player 玩家
     */
    public final void nextPage(final @NotNull Player player) {
        this.nowPage += 1;
        this.open(player, this.nowPage);
    }

    /**
     * 翻至上一頁
     * @param player 玩家
     */
    public final void previousPage(final @NotNull Player player) {
        this.nowPage -= 1;
        this.open(player, this.nowPage);
    }

    /**
     * 初始化介面
     * @param player 玩家
     */
    @Override
    @Deprecated
    protected final void initInventory(final @NotNull Player player) {}

    /**
     * 初始化介面
     * @param player 玩家
     * @param page 頁數
     */
    protected abstract void initPageInventory(final @NotNull Player player, final int page);

}
