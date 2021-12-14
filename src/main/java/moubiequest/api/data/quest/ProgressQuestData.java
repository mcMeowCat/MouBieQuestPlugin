package moubiequest.api.data.quest;

import moubiequest.api.quest.ProgressQuest;
import org.jetbrains.annotations.NotNull;

/**
 * 有關操作玩家進度任務的資料介面
 * @author MouBieCat
 */
public interface ProgressQuestData {

    /**
     * 獲取玩家當前的進度
     * @param quest 任務
     * @return 進度次數
     */
    int getProgress(final @NotNull ProgressQuest quest);

    /**
     * 設定玩家當前的進度
     * @param quest 任務
     * @param progress 進度次數
     */
    void setProgress(final @NotNull ProgressQuest quest, final int progress);

}
