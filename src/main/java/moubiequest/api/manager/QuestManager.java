package moubiequest.api.manager;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * 代表一個單一類型任務的管理器
 * @param <T> 繼承 Quest
 * @author MouBieCat
 */
public interface QuestManager<T>
        extends Manager<String, T> {

    /**
     * 用於將檔案格式轉換成記憶體的方法
     */
    void parsingQuests();

    /**
     * 獲取所有的任務
     * @return 任務集合
     */
    @NotNull Collection<T> getQuests();

}
