package moubiequest.api.itemstack.UI;

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
    int getGUISize();

    /**
     * 獲取介面標題
     * @return 標題
     */
    @NotNull String getGUITitle();

}
