package moubiequest.core.manager.loader;

import moubiequest.api.quest.ProgressQuest;
import moubiequest.core.quest.QuestType;
import org.jetbrains.annotations.NotNull;

/**
 * 用於將YAML的任務格式轉換成記憶體類
 * @author MouBieCat
 */
public abstract class ProgressQuestLoaderAbstract<T extends ProgressQuest>
        extends QuestLoaderAbstract<T> {

    /**
     * 建構子
     */
    public ProgressQuestLoaderAbstract(final @NotNull QuestType type) {
        super(type);
    }

}
