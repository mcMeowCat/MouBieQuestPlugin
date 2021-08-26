package moubiequest.core.itemstack;

import moubiequest.api.itemstack.UItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個介面上的物品類
 * @author MouBieCat
 */
public class UItemStackBuilder
        extends ItemStackBuilder
        implements UItemBuilder {

    /**
     * 物品在介面上的功能
     */
    public enum ButtonType {
        BUTTON, DECORATION
    }

    /**
     * 點擊的方法
     */
    public enum ClickType {
        LEFT, SHIFT_LEFT, RIGHT, SHIFT_RIGHT, DOUBLE_CLICK, DROP, NONE,
    }

    private int slotId = 0;

    private ButtonType buttonType = ButtonType.DECORATION;

    private ClickType clickType = ClickType.NONE;

    /**
     * 建構子
     * @param material 材質
     */
    public UItemStackBuilder(final @NotNull Material material) {
        this(material, 1);
    }

    /**
     * 建構子
     * @param material 材質
     * @param amount 數量
     */
    public UItemStackBuilder(final @NotNull Material material, final int amount) {
        this(new ItemStack(material, amount));
    }

    /**
     * 建構子
     * @param itemStack 物品實例
     */
    public UItemStackBuilder(final @NotNull ItemStack itemStack) {
        super(itemStack);
    }

    /**
     * 設定按鈕類型
     * @param buttonType 類型
     * @return 當前的建構器
     */
    @NotNull
    public final UItemBuilder setButtonType(final @NotNull ButtonType buttonType) {
        this.buttonType = buttonType;
        return this;
    }

    /**
     * 獲取按鈕類型
     * @return 類型
     */
    @NotNull
    public final ButtonType getButtonType() {
        return buttonType;
    }

    /**
     * 設定點擊的方法
     * @param clickType 點擊方法
     * @return 當前的建構器
     */
    @NotNull
    public final UItemBuilder setClickType(final @NotNull ClickType clickType) {
        this.clickType = clickType;
        return this;
    }

    /**
     * 獲取點擊的方法
     * @return 點擊方法
     */
    @NotNull
    public final ClickType getClickType() {
        return clickType;
    }

    /**
     * 設定物品在介面上的位置
     * @param slotId 位置
     * @return 當前的建構器
     */
    @NotNull
    public final UItemBuilder setSlotId(final int slotId) {
        this.slotId = slotId;
        return this;
    }

    /**
     * 獲取物品在介面上的位置
     * @return 位置
     */
    public final int getSlotId() {
        return slotId;
    }

    /**
     * 將物品建置出來
     * @return 物品
     */
    @Override
    @NotNull
    public ItemStack build() {
        return super.build();
    }

}
