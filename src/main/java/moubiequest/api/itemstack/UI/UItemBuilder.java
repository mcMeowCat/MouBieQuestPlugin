package moubiequest.api.itemstack.UI;

import moubiequest.api.itemstack.ItemBuilder;
import moubiequest.core.itemstack.UI.UItemStackBuilder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一個介面上的物品介面
 * @author MouBieCat
 */
public interface UItemBuilder
        extends ItemBuilder {

    /**
     * 設定該物品是否可以被移動
     * @param canMove 是否可以
     * @return 當前的建構器
     */
    @NotNull UItemBuilder setCanMove(final boolean canMove);

    /**
     * 獲取該物品是否可以被移動
     * @return 類型
     */
    boolean getButtonType();

    /**
     * 設定點擊的方法
     * @param clickType 點擊方法
     * @return 當前的建構器
     */
    @NotNull UItemBuilder setClickType(final @NotNull UItemStackBuilder.ClickType clickType);

    /**
     * 獲取點擊的方法
     * @return 點擊方法
     */
    @NotNull UItemStackBuilder.ClickType getClickType();

    /**
     * 設定物品在介面上的位置
     * @param slotId 位置
     * @return 當前的建構器
     */
    @NotNull UItemBuilder setSlotId(final int slotId);

    /**
     * 獲取物品在介面上的位置
     * @return 位置
     */
    int getSlotId();

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

}
