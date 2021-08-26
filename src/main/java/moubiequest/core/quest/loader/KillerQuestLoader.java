package moubiequest.core.quest.loader;

import moubiequest.api.quest.loader.KillerLoader;
import moubiequest.api.quest.KillerQuest;
import moubiequest.core.quest.QuestType;
import moubiequest.core.quest.objects.Message;
import moubiequest.core.quest.objects.QItem;
import moubiequest.core.quest.objects.Status;
import moubiequest.core.quest.objects.Title;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 用於將YAML的任務格式轉換成記憶體類
 * @author MouBieCat
 */
public class KillerQuestLoader
        extends ProgressQuestLoaderAbstract<KillerQuest>
        implements KillerLoader {

    private static final String QUEST_DATA_PROGRESS_NUMBER_PATH = ".killer.entity_type";

    /**
     * 建構子
     */
    public KillerQuestLoader() {
        super(QuestType.KILLER);
    }

    /**
     * 解析任務的擊殺生物類型
     * @param key 任務識別碼
     * @return 生物類型
     */
    public final EntityType parsingQuestKillEntityType(final @NotNull String key) {
        return EntityType.valueOf(this.getString(
                QUEST_DATA_MAIN_PATH + key + QUEST_DATA_PROGRESS_NUMBER_PATH
        ).toUpperCase());
    }

    /**
     * 解析檔案內容轉換成任務格式
     * @return 解析的任務集合
     */
    @NotNull
    public List<KillerQuest> parsing() {
        // 創建任務集合
        final List<KillerQuest> quests = new ArrayList<>();

        // 判斷該檔案是否有任務解析的主路徑
        final ConfigurationSection questSection = this.configuration.getConfigurationSection(QUEST);
        if (questSection == null)
            return quests;

        // 使用迴圈開始將任務格式解析
        for (final String key : questSection.getKeys(false)) {

            // 解析任務稱號
            final Title title =
                    new Title(this.parsingQuestTitleName(key));

            // 解析任務訊息
            final Message message =
                    new Message(this.parsingQuestSuccessMessage(key), this.parsingQuestMessage(key));

            // 解析任務狀態
            final Status status =
                    new Status(this.parsingQuestStatusEnable(key), this.parsingQuestStatusVisible(key));

            // 解析任務介面資訊
            final QItem qItem =
                    new QItem(this.parsingQuestItemMaterial(key), this.parsingQuestItemDisplayName(key), this.parsingQuestItemLore(key));

            // 創建任務
            final moubiequest.core.quest.KillerQuest quest = new moubiequest.core.quest.KillerQuest(
                    key, title, message, status, qItem, this.parsingQuestHonorPoint(key),
                    this.parsingQuestProgressNumber(key), this.parsingQuestKillEntityType(key)
            );

            // 添加
            quests.add(quest);
        }

        // 返回集合
        return quests;
    }

}
