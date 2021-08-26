package moubiequest.core.manager.loader;

import moubiequest.api.manager.QuestLoader;
import moubiequest.api.quest.Quest;
import moubiequest.core.quest.QuestType;
import moubiequest.core.yaml.Loader;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * 用於將YAML的任務格式轉換成記憶體類
 * @author MouBieCat
 */
public abstract class QuestLoaderAbstract<T extends Quest>
        extends Loader
        implements QuestLoader<T> {

    /**
     * 建構子
     * @param type 解析的任務類型
     */
    public QuestLoaderAbstract(final @NotNull QuestType type) {
        super("quests" + File.separatorChar, type.getName().toLowerCase() + ".yml", false);
    }

}
