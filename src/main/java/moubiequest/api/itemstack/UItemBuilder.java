package moubiequest.api.itemstack;

import moubiequest.core.itemstack.UItemStackBuilder;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個介面上的物品介面
 * @author MouBieCat
 */
public interface UItemBuilder
        extends ItemBuilder {

    /**
     * 設定按鈕類型
     * @param buttonType 類型
     * @return 當前的建構器
     */
    @NotNull UItemBuilder setButtonType(final @NotNull UItemStackBuilder.ButtonType buttonType);

    /**
     * 獲取按鈕類型
     * @return 類型
     */
    @NotNull UItemStackBuilder.ButtonType getButtonType();

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

}
