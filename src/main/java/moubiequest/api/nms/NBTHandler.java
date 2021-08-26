package moubiequest.api.nms;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個有關可以操作物品NBT項目的介面
 * @author MouBieCat
 */
public interface NBTHandler
        extends Handler {

    /**
     * 獲取當前的主路徑名稱
     * @return 名稱
     */
    @NotNull String getMainTagName();

    /**
     * 設置當前的主路徑名稱
     * @param tagName 新名稱
     */
    void setMainTagName(final @NotNull String tagName);

    /**
     * 重製所有配置 (tag、mainTagName)
     */
    void remake();

    /**
     * 在該 tag 上設置一個 boolean
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTHandler setBoolean(final @NotNull String var1, final boolean var2);

    /**
     * 在該 tag 上設置一個 byte
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTHandler setByte(final @NotNull String var1, final byte var2);

    /**
     * 在該 tag 上設置一個 double
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTHandler setDouble(final @NotNull String var1, final double var2);

    /**
     * 在該 tag 上設置一個 float
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTHandler setFloat(final @NotNull String var1, final float var2);

    /**
     * 在該 tag 上設置一個 int
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTHandler setInt(final @NotNull String var1, final int var2);

    /**
     * 在該 tag 上設置一個 long
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTHandler setLong(final @NotNull String var1, final long var2);

    /**
     * 在該 tag 上設置一個 short
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTHandler setShort(final @NotNull String var1, final short var2);

    /**
     * 在該 tag 上設置一個 String
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTHandler setString(final @NotNull String var1, final @NotNull String var2);

    /**
     * 在該 tag 上或取一個 boolean
     * @param var1 路徑
     * @return 資料
     */
    boolean getBoolean(final @NotNull String var1);

    /**
     * 在該 tag 上或取一個 byte
     * @param var1 路徑
     * @return 資料
     */
    byte getByte(final @NotNull String var1);

    /**
     * 在該 tag 上或取一個 double
     * @param var1 路徑
     * @return 資料
     */
    double getDouble(final @NotNull String var1);

    /**
     * 在該 tag 上或取一個 float
     * @param var1 路徑
     * @return 資料
     */
    float getFloat(final @NotNull String var1);

    /**
     * 在該 tag 上或取一個 int
     * @param var1 路徑
     * @return 資料
     */
    int getInt(final @NotNull String var1);

    /**
     * 在該 tag 上或取一個 long
     * @param var1 路徑
     * @return 資料
     */
    long getLong(final @NotNull String var1);

    /**
     * 在該 tag 上或取一個 short
     * @param var1 路徑
     * @return 資料
     */
    short getShort(final @NotNull String var1);

    /**
     * 在該 tag 上或取一個 String
     * @param var1 路徑
     * @return 資料
     */
    @NotNull String getString(final @NotNull String var1);

    /**
     * 將一個物品寫入該 tag
     * @param var1 寫入的物品
     * @return 寫入後的物品
     */
    @NotNull ItemStack builder(final @NotNull ItemStack var1);

    /**
     * 在一個物品上解析 tag 類型 boolean
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    boolean getBoolean(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3);

    /**
     * 在一個物品上解析 tag 類型 byte
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    byte getByte(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3);

    /**
     * 在一個物品上解析 tag 類型 double
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    double getDouble(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3);

    /**
     * 在一個物品上解析 tag 類型 float
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    float getFloat(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3);

    /**
     * 在一個物品上解析 tag 類型 int
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    int getInt(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3);

    /**
     * 在一個物品上解析 tag 類型 long
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    long getLong(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3);

    /**
     * 在一個物品上解析 tag 類型 short
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    short getShort(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3);

    /**
     * 在一個物品上解析 tag 類型 String
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    @NotNull
    String getString(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3);

}
