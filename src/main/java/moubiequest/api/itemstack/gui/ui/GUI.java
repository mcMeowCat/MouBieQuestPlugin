package moubiequest.api.itemstack.gui.ui;

import moubiequest.api.itemstack.gui.Openable;
import moubiequest.core.itemstack.gui.UInventoryAbstract;
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
     * 獲取介面大小
     * @return 大小
     */
    UInventoryAbstract.InventorySize getGUISize();

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

}
