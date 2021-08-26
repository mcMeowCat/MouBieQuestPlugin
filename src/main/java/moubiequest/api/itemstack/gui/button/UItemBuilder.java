package moubiequest.api.itemstack.gui.button;

import moubiequest.api.itemstack.ItemBuilder;
import moubiequest.core.itemstack.UI.UItemStackBuilder;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個介面上的物品介面
 * @author MouBieCat
 */
public interface UItemBuilder
        extends ItemBuilder, UItem {

    /**
     * 設定該物品是否可以被移動
     * @param canMove 是否可以
     * @return 當前的建構器
     */
    @NotNull UItemBuilder setCanMove(final boolean canMove);

    /**
     * 設定點擊的方法
     * @param clickType 點擊方法
     * @return 當前的建構器
     */
    @NotNull UItemBuilder setClickType(final @NotNull UItemStackBuilder.ClickType clickType);

    /**
     * 設定物品在介面上的位置
     * @param slotId 位置
     * @return 當前的建構器
     */
    @NotNull UItemBuilder setSlotId(final int slotId);

}
