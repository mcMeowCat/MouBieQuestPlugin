package moubiequest.core.manager.loader;

import moubiequest.api.quest.KillerQuest;
import moubiequest.core.quest.QuestType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 用於將YAML的任務格式轉換成記憶體類
 * @author MouBieCat
 */
public class KillerQuestLoader
        extends ProgressQuestLoaderAbstract<KillerQuest> {

    /**
     * 建構子
     */
    public KillerQuestLoader() {
        super(QuestType.KILLER);
    }

    /**
     * 解析檔案內容轉換成任務格式
     * @return 解析的任務集合
     */
    @NotNull
    public List<KillerQuest> parsing() {
        return null;
    }

}
