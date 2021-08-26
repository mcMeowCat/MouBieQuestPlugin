package moubiequest.core.itemstack.UI;

import moubiequest.api.itemstack.gui.ui.QuestGUI;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個基礎的任務介面操作類
 * @author MouBieCat
 */
public abstract class QuestUInventoryAbstract
        extends PageUInventoryAbstract
        implements QuestGUI {

    /**
     * 任務顯示方式
     * 所有、已擁有、未擁有
     */
    public enum View {
        ALL,
        SUCCESS,
        NO_SUCCESS
    }

    // 顯示方式 (預設=所有)
    protected View viewType = View.ALL;

    /**
     * 建構子
     * @param title 介面標題
     */
    public QuestUInventoryAbstract(final @NotNull String title) {
        super(title, InventorySize.SIX);
    }

    /**
     * 獲取當前的顯示方式類型
     * @return 顯示方式
     */
    public final View getViewType() {
        return this.viewType;
    }

    /**
     * 設定當前的顯示方式類型
     * @param viewType 顯示方式
     */
    public final void setViewType(final @NotNull View viewType) {
        this.viewType = viewType;
    }

}
