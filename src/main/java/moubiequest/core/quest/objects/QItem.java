package moubiequest.core.quest.objects;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

/**
 * 代表任務在介面上顯示的屬性資訊物件
 *
 * @author MouBieCat
 */
public record QItem(@NotNull Material material) {

    /**
     * 建構子
     *
     * @param material 材質
     */
    public QItem(final @NotNull Material material) {
        this.material = material;
    }

    /**
     * 獲取材質
     *
     * @return 材質
     */
    @NotNull
    public Material getMaterial() {
        return this.material;
    }

}
