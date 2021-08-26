package moubiequest.core.quest.object;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 代表任務在介面上顯示的屬性資訊物件
 * @author MouBieCat
 */
public final class QItem {

    // 材質
    private final Material material;

    // 標題
    private final String displayName;

    // 說明
    private final List<String> lore;

    /**
     * 建構子
     * @param material 材質
     * @param displayName 標題
     * @param lore 說明
     */
    public QItem(final @NotNull Material material, final @NotNull String displayName, final @NotNull List<String> lore) {
        this.material = material;
        this.displayName = displayName;
        this.lore = lore;
    }

    /**
     * 獲取材質
     * @return 材質
     */
    @NotNull
    public Material getMaterial() {
        return this.material;
    }

    /**
     * 獲取物品標題
     * @return 標題
     */
    @NotNull
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * 獲取物品說明
     * @return 說明
     */
    @NotNull
    public List<String> getLore() {
        return this.lore;
    }

}
