package moubiequest.api.manager;

/**
 * 代表一個單一類型任務的管理器
 * @param <T> 繼承 Quest
 * @author MouBieCat
 */
public interface QuestManager<T> {

    /**
     * 用於將檔案格式轉換成記憶體的方法
     */
    void parsingQuests();

}
