package moubiequest.core.manager.data;

import moubiequest.api.data.quest.PlayerQuestDataFile;
import moubiequest.api.manager.PlayerDataManager;
import moubiequest.core.data.quest.PlayerQuestData;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 用於紀錄玩家的任務資料管理器
 * @author MouBieCat
 */
public final class PlayerQuestDataManager
        extends DataManagerAbstract<Player, PlayerQuestDataFile>
        implements PlayerDataManager {

    /**
     * 從管理器中獲取資料
     * @param key k
     * @return v
     */
    @NotNull
    public PlayerQuestDataFile get(final @NotNull Player key) {
        final PlayerQuestDataFile dataFile = super.get(key);
        if (dataFile != null)
            return dataFile;

        this.add(key, new PlayerQuestData(key));
        return this.get(key);
    }

}
