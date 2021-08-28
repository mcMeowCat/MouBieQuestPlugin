package moubiequest.api.quest;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個任務的基礎
 * @author MouBieCat
 */
public interface Quest {

    /**
     * 獲取該任務的任務類型
     * @return 任務類型
     */
    @NotNull QuestType getQuestType();

    /**
     * 獲取該任務的識別名稱
     * @return 識別名稱
     */
    @NotNull String getQuestKey();

    /**
     * 獲取該任務的稱號名稱
     * @return 稱號名稱
     */
    @NotNull String getQuestTitle();

    /**
     * 獲取任務進行中的消息
     * @return 消息
     */
    @NotNull String getQuestMessage();

    /**
     * 獲取任務的完成式消息
     * @return 消息
     */
    @NotNull String getQuestSuccessMessage();

    /**
     * 該任務是否開放中
     * @return 是否開放
     */
    boolean isQuestEnable();

    /**
     * 該任務是否被隱藏中
     * @return 是否隱藏
     */
    boolean isQuestVisible();

    /**
     * 設置該任務是否開啟
     * @param isEnable 狀態
     */
    void setQuestEnable(final boolean isEnable);

    /**
     * 設置該任務是否隱藏
     * @param isVisible 狀態
     */
    void setQuestVisible(final boolean isVisible);

    /**
     * 使一個玩家使用該任務的稱號頭銜與效果
     * @param player 玩家
     */
    void usingTitleForPlayer(final @NotNull Player player);

    /**
     * 獲取材質
     * @return 材質
     */
    @NotNull Material getQuestItemMaterial();

    /**
     * 獲取該任務的榮譽點數
     * @return 點數值
     */
    int getQuestHonorPoint();

    /**
     * 該玩家是否達成了任務
     * @param player 玩家
     */
    boolean isSuccess(final @NotNull Player player);

}
