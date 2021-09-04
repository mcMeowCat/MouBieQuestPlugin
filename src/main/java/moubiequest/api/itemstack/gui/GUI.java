package moubiequest.api.itemstack.gui;

import moubiequest.core.itemstack.gui.ui.UInventoryAbstract;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個基本的介面的介面(#
 * @author MouBieCat
 */
public interface GUI
        extends InventoryHolder, Openable {

    /**
     * 代表一個介面大小
     */
    enum InventorySize {

        ONE(9),     // 一行
        TWO(18),    // 兩行
        THREE(27),  // 三行
        FOUR(36),   // 四行
        FIVE(45),   // 五行
        SIX(54);    // 六行

        // 大小
        private final int size;

        /**
         * 建構子
         * @param size 大小
         */
        InventorySize(final int size) {
            this.size = size;
        }

        /**
         * 獲取大小
         * @return 大小
         */
        public final int getSize() {
            return this.size;
        }

        /**
         * 轉換成字串類型
         * @return 字串
         */
        @Override
        public final String toString() {
            return "InventorySize{" + "size=" + size + '}';
        }
    }

    /**
     * 獲取介面大小
     * @return 大小
     */
    @NotNull GUI.InventorySize getGUISize();

    /**
     * 獲取介面標題
     * @return 標題
     */
    @NotNull String getGUITitle();

    /**
     * 代表當介面被點擊的事件
     * @param event 介面點擊事件
     */
    void clickInventory(final @NotNull InventoryClickEvent event);

    /**
     * 是否取消點擊事件操作 (使物品不被移動)
     * @return 是否取消
     */
    boolean isCancelClickEvent();

    /**
     * 關閉伺服器玩家開啟有關該庫存的介面
     */
    static void closePlayerInventory() {
        UInventoryAbstract.closePlayerInventory();
    }

}
