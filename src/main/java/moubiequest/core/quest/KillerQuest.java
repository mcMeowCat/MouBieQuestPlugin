package moubiequest.core.quest;

import moubiequest.core.quest.objects.Message;
import moubiequest.core.quest.objects.QItem;
import moubiequest.core.quest.objects.Status;
import moubiequest.core.quest.objects.Title;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個擊殺生物任務
 * @author MouBieCat
 */
public class KillerQuest
        extends ProgressQuestAbstract
        implements moubiequest.api.quest.KillerQuest {

    protected final EntityType quest_kill_entity_type;

    /**
     * 建構子
     * @param quest_key         任務識別名稱
     * @param quest_title       任務稱號
     * @param quest_message     任務消息
     * @param quest_status      任務狀態
     * @param quest_honor_point 任務榮譽點數
     * @param quest_progress    任務所需的進度次數
     * @param quest_kill_entity_type 任務所需擊殺的生物類型
     */
    public KillerQuest(final @NotNull String quest_key,
                       final @NotNull Title quest_title,
                       final @NotNull Message quest_message,
                       final @NotNull Status quest_status,
                       final @NotNull QItem item,
                       final int quest_honor_point,
                       final int quest_progress,
                       final @NotNull EntityType quest_kill_entity_type) {
        super(QuestType.KILLER, quest_key, quest_title, quest_message, quest_status, item, quest_honor_point, quest_progress);
        this.quest_kill_entity_type = quest_kill_entity_type;
    }

    /**
     * 獲取任務所需擊殺的生物類型
     * @return 生物類型
     */
    @NotNull
    public final EntityType getKillEntity() {
        return this.quest_kill_entity_type;
    }

    /**
     * 檢查該生物類型是否符合
     * @param type 生物類型
     * @return 是否符合
     */
    public final boolean checkEntityType(final @NotNull EntityType type) {
        return this.quest_kill_entity_type.equals(type);
    }

}
