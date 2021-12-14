package moubiequest.api.manager;

import moubiequest.api.data.quest.PlayerQuestDataFile;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 用於紀錄玩家的任務資料管理器介面
 * @author MouBieCat
 */
public interface PlayerDataManager
        extends Manager<Player, PlayerQuestDataFile> {

    /**
     * 或取一個玩家的任務資料
     * @param player 玩家
     * @return 玩家資料紀錄
     */
    @NotNull PlayerQuestDataFile get(final @NotNull Player player);

}
