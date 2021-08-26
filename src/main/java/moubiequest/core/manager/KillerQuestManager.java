package moubiequest.core.manager;

import moubiequest.api.manager.loader.KillerLoader;
import moubiequest.api.quest.KillerQuest;
import moubiequest.core.manager.loader.KillerQuestLoader;
import moubiequest.main.MouBieCat;

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
        final KillerLoader loader = new KillerQuestLoader();
        for (final KillerQuest quest : loader.parsing())
            this.add(quest.getQuestKey(), quest);
        System.out.println(MouBieCat.PLUGIN_TITLE + "§2成功解析並加載了 §6" + this.manager.size() + " §2個§c擊殺§2類型任務！");
    }

}
