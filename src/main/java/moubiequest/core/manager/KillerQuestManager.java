package moubiequest.core.manager;

import moubiequest.api.manager.QuestLoader;
import moubiequest.api.quest.KillerQuest;
import moubiequest.core.manager.loader.KillerQuestLoader;

/**
 * 代表管理擊殺任務的管理器
 * @author MouBieCat
 */
public final class KillerQuestManager
        extends QuestManagerAbstract<KillerQuest> {

    /**
     * 用於將檔案格式轉換成記憶體的方法
     */
    @Override
    public void parsingQuests() {
        QuestLoader<KillerQuest> loader = new KillerQuestLoader();
        for (final KillerQuest quest : loader.parsing())
            this.add(quest.getQuestKey(), quest);
    }

}
