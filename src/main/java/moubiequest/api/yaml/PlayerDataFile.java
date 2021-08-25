package moubiequest.api.yaml;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個基礎的玩家資料介面
 * @author MouBieCat
 */
public interface PlayerDataFile
        extends DataFile {

    /**
     * 獲取資料擁有者
     * @return 玩家(擁有者)
     */
    @NotNull Player getPlayer();

}
