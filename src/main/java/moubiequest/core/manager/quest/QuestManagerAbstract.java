package moubiequest.core.manager.quest;

import moubiequest.api.manager.QuestManager;
import moubiequest.api.quest.Quest;
import moubiequest.core.manager.ManagerAbstract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * 代表一個單一類型任務的管理器
 * @param <T> 繼承 Quest
 * @author MouBieCat
 */
public abstract class QuestManagerAbstract<T extends Quest>
        extends ManagerAbstract<String, T>
        implements QuestManager<T> {

    /**
     * 建構子
     */
    public QuestManagerAbstract() {
        this.parsingQuests();
    }

    /**
     * 用於將檔案格式轉換成記憶體的方法
     */
    public abstract void parsingQuests();

    /**
     * 獲取所有的任務
     * @return 任務集合
     */
    @NotNull
    public final Collection<T> getQuests() {
        return this.manager.values();
    }

}
