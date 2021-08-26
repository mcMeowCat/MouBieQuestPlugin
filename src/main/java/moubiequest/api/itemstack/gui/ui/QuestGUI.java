package moubiequest.api.itemstack.gui.ui;

import moubiequest.core.itemstack.UI.QuestUInventoryAbstract;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個基礎的任務介面
 * @author MouBieCat
 */
public interface QuestGUI
        extends PageGUI {

    /**
     * 獲取當前的顯示方式類型
     * @return 顯示方式
     */
    QuestUInventoryAbstract.View getViewType();

    /**
     * 設定當前的顯示方式類型
     * @param viewType 顯示方式
     */
    void setViewType(final @NotNull QuestUInventoryAbstract.View viewType);

}
