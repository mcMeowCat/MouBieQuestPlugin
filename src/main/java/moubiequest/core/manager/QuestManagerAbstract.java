package moubiequest.core.manager;

import moubiequest.api.manager.QuestManager;
import moubiequest.api.quest.Quest;

/**
 * 代表一個單一類型任務的管理器
 * @param <T> 繼承 Quest
 * @author MouBieCat
 */
public abstract class QuestManagerAbstract<T extends Quest>
        extends ManagerAbstract<String, T>
        implements QuestManager<T> {
}
