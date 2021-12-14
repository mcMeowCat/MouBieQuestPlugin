package moubiequest.api.data.quest;

import moubiequest.api.quest.Quest;
import org.jetbrains.annotations.NotNull;

/**
 * 有關操控玩家的點數介面
 * @author MouBieCat
 */
public interface HonorData {

    /**
     * 添加點數
     * @param quest 任務
     */
    void addHonorPoint(final @NotNull Quest quest);

    /**
     * 減去點數
     * @param quest 任務
     */
    void subHonorPoint(final @NotNull Quest quest);

    /**
     * 設定玩家目前的榮譽點數數量
     * @param point 數量
     */
    void setHonorPoint(final int point);

    /**
     * 獲取玩家目前的榮譽點數數量
     * @return 數量
     */
    int getHonorPoint();

}
