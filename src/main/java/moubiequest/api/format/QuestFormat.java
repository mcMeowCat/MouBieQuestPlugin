package moubiequest.api.format;

import moubiequest.api.quest.Quest;

/**
 * 代表一個任務格式轉換介面
 * @param <T> 繼承 任務
 * @author MouBieCat
 */
public interface QuestFormat<T extends Quest>
        extends FormatReplacer<T> {
}
