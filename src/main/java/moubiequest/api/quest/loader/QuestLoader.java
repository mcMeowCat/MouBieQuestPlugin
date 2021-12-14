package moubiequest.api.quest.loader;

import moubiequest.api.quest.Quest;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 任務解析器介面
 * @param <T> 繼承 Quest
 * @author MouBieCat
 */
public interface QuestLoader<T extends Quest> {

    /**
     * 解析檔案內容轉換成任務格式
     * @return 解析的任務集合
     */
    @NotNull List<T> parsing();

}
