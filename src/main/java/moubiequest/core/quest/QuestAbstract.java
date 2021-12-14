package moubiequest.core.quest;

import moubiequest.api.quest.Quest;
import moubiequest.api.quest.QuestType;
import moubiequest.core.quest.objects.Message;
import moubiequest.core.quest.objects.QItem;
import moubiequest.core.quest.objects.Status;
import moubiequest.core.quest.objects.Title;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個基礎任務該有的物件
 * @author MouBieCat
 */
public abstract class QuestAbstract
        implements Quest {

    // 任務類型
    protected final QuestType quest_type;

    // 任務識別名稱
    protected final String quest_key;

    // 任務稱號
    protected final Title quest_title;

    // 有關任務的消息
    protected final Message quest_messages;

    // 任務目前的狀態
    protected final Status quest_status;

    // 任務在介面資訊
    protected final QItem item;

    // 任務的榮譽點數
    protected final int quest_honor_point;

    /**
     * 建構子
     * @param quest_type 任務類型
     * @param quest_key 任務識別名稱
     * @param quest_title 任務稱號
     * @param quest_message 任務消息
     * @param quest_status 任務狀態
     * @param quest_honor_point 任務榮譽點數
     */
    public QuestAbstract(final @NotNull QuestType quest_type,
                         final @NotNull String quest_key,
                         final @NotNull Title quest_title,
                         final @NotNull Message quest_message,
                         final @NotNull Status quest_status,
                         final @NotNull QItem item,
                         final int quest_honor_point) {
        this.quest_type = quest_type;
        this.quest_key = quest_key;
        this.quest_title = quest_title;
        this.quest_messages = quest_message;
        this.quest_status = quest_status;
        this.item = item;
        this.quest_honor_point = quest_honor_point;
    }

    /**
     * 獲取該任務的任務類型
     * @return 任務類型
     */
    @NotNull
    public final QuestType getQuestType() {
        return this.quest_type;
    }

    /**
     * 獲取該任務的識別名稱
     * @return 識別名稱
     */
    @NotNull
    public final String getQuestKey() {
        return this.quest_key;
    }

    /**
     * 獲取該任務的稱號名稱
     * @return 稱號名稱
     */
    @NotNull
    public final String getQuestTitle() {
        return this.quest_title.getTitle();
    }

    /**
     * 獲取任務進行中的消息
     * @return 消息
     */
    @NotNull
    public final String getQuestMessage() {
        return this.quest_messages.getMessage();
    }

    /**
     * 獲取任務的完成式消息
     * @return 消息
     */
    @NotNull
    public final String getQuestSuccessMessage() {
        return this.quest_messages.getSuccessMessage();
    }

    /**
     * 該任務是否開放中
     * @return 是否開放
     */
    public final boolean isQuestEnable() {
        return this.quest_status.isEnable();
    }

    /**
     * 該任務是否被隱藏中
     * @return 是否隱藏
     */
    public final boolean isQuestVisible() {
        return this.quest_status.isVisible();
    }

    /**
     * 設置該任務是否開啟
     * @param isEnable 狀態
     */
    public final void setQuestEnable(final boolean isEnable) {
        this.quest_status.setEnable(isEnable);
    }

    /**
     * 設置該任務是否隱藏
     * @param isVisible 狀態
     */
    public final void setQuestVisible(final boolean isVisible) {
        this.quest_status.setVisible(isVisible);
    }

    /**
     * 獲取材質
     * @return 材質
     */
    @NotNull
    public final Material getQuestItemMaterial() {
        return this.item.getMaterial();
    }

    /**
     * 獲取該任務的榮譽點數
     * @return 點數值
     */
    public final int getQuestHonorPoint() {
        return this.quest_honor_point;
    }

    /**
     * 該玩家是否達成了任務
     * @param player 玩家
     */
    public abstract boolean isSuccess(final @NotNull Player player);

}
