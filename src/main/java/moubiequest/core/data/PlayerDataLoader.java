package moubiequest.core.data;

import moubiequest.api.yaml.PlayerDataFile;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個最基礎的玩家紀錄檔案載入器
 * @author MouBieCat
 */
public class PlayerDataLoader
        extends DataLoader
        implements PlayerDataFile {

    // 資料擁有人
    protected final Player player;

    /**
     * 建構子
     *
     * @param path 檔案路徑
     * @param player 資料擁有人
     */
    public PlayerDataLoader(final @NotNull String path, final @NotNull Player player) {
        super(path, player.getUniqueId().toString() + ".yml");
        this.player = player;
        this.initPlayerData();
    }

    /**
     * 獲取資料擁有者
     * @return 玩家(擁有者)
     */
    @NotNull
    public final Player getPlayer() {
        return this.player;
    }

    /**
     * 初始化
     */
    protected void initPlayerData() {
        this.configuration.set("uuid", player.getUniqueId().toString());
        this.configuration.set("name", player.getName());
        this.save();
    }

}
