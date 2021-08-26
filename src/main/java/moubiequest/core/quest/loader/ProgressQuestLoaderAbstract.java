package moubiequest.core.quest.loader;

import moubiequest.api.quest.ProgressQuest;
import moubiequest.core.quest.QuestType;
import org.jetbrains.annotations.NotNull;

/**
 * 用於將YAML的任務格式轉換成記憶體類
 * @author MouBieCat
 */
public abstract class ProgressQuestLoaderAbstract<T extends ProgressQuest>
        extends QuestLoaderAbstract<T> {

    private static final String QUEST_DATA_PROGRESS_NUMBER_PATH = ".progress.number";

    /**
     * 建構子
     * @param type 任務類型
     */
    public ProgressQuestLoaderAbstract(final @NotNull QuestType type) {
        super(type);
    }

    /**
     * 解析任務的進度次數
     * @param key 任務識別碼
     * @return 榮譽點數
     */
    public final int parsingQuestProgressNumber(final @NotNull String key) {
        return this.getInt(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_PROGRESS_NUMBER_PATH);
    }

}
