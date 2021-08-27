package moubiequest.core.format;

import moubiequest.api.quest.ProgressQuest;
import moubiequest.api.yaml.plugin.FormatFile;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個進度任務的格式轉換類
 * @param <T> 繼承 進度任務
 * @author MouBieCat
 */
public abstract class ProgressQuestFormat<T extends ProgressQuest>
        extends QuestReplacer<T> {

    /**
     * ## 有進度任務佔位符 ## 擴展 (Base Quest)
     * # {QUEST_PROGRESS} - 該任務所需的進度次數
     * # {QUEST_PROGRESS_PLAYER} - 獲取玩家當前進度次數
     * # {QUEST_PROGRESS_PLAYER_PERCENTAGE} - 玩家與任務進度差距百分比(數字)
     * # {QUEST_PROGRESS_PLAYER_PERCENTAGE_IMAGE} - 玩家與任務進度差距百分比(圖表) (詳見下面設定)
     */
    private static final String QUEST_PROGRESS = "{QUEST_PROGRESS}";
    private static final String QUEST_PROGRESS_PLAYER = "{QUEST_PROGRESS_PLAYER}";
    private static final String QUEST_PROGRESS_PLAYER_PERCENTAGE = "{QUEST_PROGRESS_PLAYER_PERCENTAGE}";
    private static final String QUEST_PROGRESS_PLAYER_PERCENTAGE_IMAGE = "{QUEST_PROGRESS_PLAYER_PERCENTAGE_IMAGE}";

    /**
     * 建構子
     * @param obj  轉換物件
     * @param file 讀取格式的檔案
     */
    public ProgressQuestFormat(final @NotNull T obj, final @NotNull FormatFile file) {
        super(obj, file);
    }

    @Override
    @NotNull
    public String replace(final @NotNull String msg, final @NotNull Player player) {
        String replaceStr = msg;

        replaceStr = replaceStr.replace(
                QUEST_PROGRESS,
                ""+this.replacer.getQuestProgress()
        );

        replaceStr = replaceStr.replace(
                QUEST_PROGRESS_PLAYER,
                ""+this.replacer.getPlayerQuestProgress(player)
        );

        // 計算進度百分比
        final int progressPercentage = this.calcProgressPercentage(player);

        replaceStr = replaceStr.replace(
                QUEST_PROGRESS_PLAYER_PERCENTAGE,
                ""+progressPercentage
        );

        replaceStr = replaceStr.replace(
                QUEST_PROGRESS_PLAYER_PERCENTAGE_IMAGE,
                ""+this.formatFile.getQuestProgressImage(progressPercentage)
        );

        return super.replace(replaceStr, player);
    }

    /**
     * 計算進度百分比
     * @param player 玩家
     * @return 百分比
     */
    private int calcProgressPercentage(final @NotNull Player player) {
        final int questProgress = this.replacer.getQuestProgress();
        final int playerQuestProgress = this.replacer.getPlayerQuestProgress(player);
        return (int) ((float)playerQuestProgress / questProgress * 100);
    }

}
