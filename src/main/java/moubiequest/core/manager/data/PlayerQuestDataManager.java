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
     * 或取一個玩家的任務資料
     * @param player 玩家
     * @return v
     */
    @NotNull
    public PlayerQuestDataFile get(final @NotNull Player player) {
        final PlayerQuestDataFile dataFile = super.get(player);
        if (dataFile != null)
            return dataFile;

        this.add(player, new PlayerQuestData(player));
        return this.get(player);
    }

}
