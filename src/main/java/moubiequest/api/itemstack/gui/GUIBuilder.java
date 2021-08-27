package moubiequest.api.itemstack.gui;

import moubiequest.api.itemstack.gui.button.UItem;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個 GUI 建構器介面
 * @author MouBieCat
 */
public interface GUIBuilder
        extends GUI {

    /**
     * 添加一個按鈕到介面
     * @param uItem 介面物品實例
     */
    @NotNull GUIBuilder addUItem(final @NotNull UItem uItem);

    /**
     * 添加一個物品到介面
     * @param itemStack 物品
     */
    @NotNull GUIBuilder addItem(final @NotNull ItemStack itemStack);

    /**
     * 添加一個物品到介面
     * @param itemStack 物品
     * @param slot 位置
     * @return 當前的建構器
     */
    @NotNull GUIBuilder addItem(final @NotNull ItemStack itemStack, final int slot);

    /**
     * 清除當前介面上的所有物品按鈕
     */
    void clearInventory();

}
