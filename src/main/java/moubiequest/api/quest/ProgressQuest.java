package moubiequest.api.quest;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個帶有進度的任務介面
 * @author MouBieCat
 */
public interface ProgressQuest
        extends Quest {

    /**
     * 或取進度任務需達成的次數
     * @return 所需次數
     */
    int getQuestProgress();

    /**
     * 對玩家添加進度一次
     * @param player 玩家
     * @return 是否成功添加
     */
    boolean addPlayerQuestProgress(final @NotNull Player player);

    /**
     * 對玩家進度清除歸零
     * @param player 玩家
     */
    void clearPlayerQuestProgress(final @NotNull Player player);

    /**
     * 獲取該玩家目前達到的進度水平
     * @param player 玩家
     * @return 進度次數
     */
    int getPlayerQuestProgress(final @NotNull Player player);

}
