package moubiequest.api.itemstack.gui.button;

import moubiequest.core.itemstack.UI.UItemStackBuilder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一個介面物品
 * @author MouBieCat
 */
public interface UItem {

    /**
     * 解析一個物品是否可以被使用者移動
     * @param itemStack 物品
     * @return 是否可被移動
     */
    static boolean getItemStackCanMove(final @NotNull ItemStack itemStack) {
        return UItemStackBuilder.getItemStackCanMove(itemStack);
    }

    /**
     * 解析一個物品的點擊操作類型
     * @param itemStack 物品
     * @return 類型
     */
    @Nullable
    static UItemStackBuilder.ClickType getItemStackClickType(final @NotNull ItemStack itemStack) {
        return UItemStackBuilder.getItemStackClickType(itemStack);
    }

    /**
     * 獲取物品在介面上的位置
     * @return 位置
     */
    int getSlotId();

    /**
     * 獲取該物品是否可以被移動
     * @return 類型
     */
    boolean getButtonType();

    /**
     * 獲取點擊的方法
     * @return 點擊方法
     */
    @NotNull UItemStackBuilder.ClickType getClickType();

    /**
     * 將物品建置出來
     * @return 物品
     */
    @NotNull ItemStack build();

}
