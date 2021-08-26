package moubiequest.core.itemstack.UI;

import moubiequest.api.itemstack.UI.UItemBuilder;
import moubiequest.api.nms.NBTHandler;
import moubiequest.core.itemstack.ItemStackBuilder;
import moubiequest.main.MouBieCat;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一個介面上的物品類
 * @author MouBieCat
 */
public class UItemStackBuilder
        extends ItemStackBuilder
        implements UItemBuilder {

    private static final String UI_ITEM_NBT_TAG_MAIN_PATH = "UI_ITEM_MAIN_TAG";

    private static final String UI_ITEM_NBT_TAG_CAN_MOVE_PATH = "CAN_MOVE";
    private static final String UI_ITEM_NBT_TAG_CLICK_TYPE_PATH = "CLICK_TYPE";

    /**
     * 點擊的方法
     */
    public enum ClickType {
        LEFT, SHIFT_LEFT, RIGHT, SHIFT_RIGHT, DOUBLE_CLICK, DROP, NONE,
    }

    // 介面位置
    private int slotId = 0;

    // 點選方法
    private ClickType clickType = ClickType.NONE;

    private boolean isCamMove = false;

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
     * 設定該物品是否可以被移動
     *
     * @param canMove 是否可以
     * @return 當前的建構器
     */
    @NotNull
    public final UItemBuilder setCanMove(final boolean canMove) {
        this.isCamMove = canMove;
        return this;
    }

    /**
     * 獲取該物品是否可以被移動
     *
     * @return 類型
     */
    @Override
    public final boolean getButtonType() {
        return this.isCamMove;
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
     * 解析一個物品是否可以被使用者移動
     * @param itemStack 物品
     * @return 是否可被移動
     */
    public static boolean getItemStackCanMove(final @NotNull ItemStack itemStack) {
        final NBTHandler handler = MouBieCat.getInstance().getNmsManager().getNbtHandler();
        if (handler.hasTag(itemStack, UI_ITEM_NBT_TAG_MAIN_PATH))
            return handler.getBoolean(itemStack, UI_ITEM_NBT_TAG_MAIN_PATH, UI_ITEM_NBT_TAG_CAN_MOVE_PATH);

        return false;
    }

    /**
     * 解析一個物品的點擊操作類型
     * @param itemStack 物品
     * @return 類型
     */
    @Nullable
    public static ClickType getItemStackClickType(final @NotNull ItemStack itemStack) {
        final NBTHandler handler = MouBieCat.getInstance().getNmsManager().getNbtHandler();
        if (handler.hasTag(itemStack, UI_ITEM_NBT_TAG_MAIN_PATH)) {
            return ClickType.valueOf(
                    handler.getString(itemStack, UI_ITEM_NBT_TAG_MAIN_PATH, UI_ITEM_NBT_TAG_CLICK_TYPE_PATH).toUpperCase()
            );
        }
        return null;
    }

    /**
     * 將物品建置出來
     * @return 物品
     */
    @Override
    @NotNull
    public ItemStack build() {
        final NBTHandler handler = MouBieCat.getInstance().getNmsManager().getNbtHandler();

        // 配置 TAG 屬性
        handler.setMainTagName(UI_ITEM_NBT_TAG_MAIN_PATH)
                .setBoolean(UI_ITEM_NBT_TAG_CAN_MOVE_PATH, this.isCamMove)
                .setString(UI_ITEM_NBT_TAG_CLICK_TYPE_PATH, this.clickType.toString().toUpperCase());

        // 寫入到物品中
        this.itemStack = handler.build(this.itemStack);

        return super.build();
    }

}
