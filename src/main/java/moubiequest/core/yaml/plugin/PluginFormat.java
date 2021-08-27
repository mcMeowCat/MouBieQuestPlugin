package moubiequest.core.yaml.plugin;

import moubiequest.api.quest.Quest;
import moubiequest.api.quest.QuestType;
import moubiequest.api.yaml.plugin.FormatFile;
import moubiequest.core.quest.objects.Title;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 代表該插件的嵌入式文件(Format.yml)
 * @author MouBieCat
 */
public final class PluginFormat
        extends PluginLoader
        implements FormatFile {

    private static final String FORMAT_QUEST_FORMAT_MAIN_PATH = "QuestFormat.";
    private static final String FORMAT_QUEST_HEAD_FORMAT_PATH = ".head";
    private static final String FORMAT_QUEST_BODY_FORMAT_PATH = ".body";

    private static final String FORMAT_PLAYER_DATA_HEAD_FORMAT_PATH = "PlayerQuestHead.head";
    private static final String FORMAT_PLAYER_DATA_BODY_FORMAT_PATH = "PlayerQuestHead.body";

    private static final String FORMAT_QUEST_TYPE_PATH = "Format.quest_type.";
    private static final String FORMAT_QUEST_ENABLE_PATH = "Format.quest_enable.";
    private static final String FORMAT_QUEST_VISIBLE_PATH = "Format.quest_visible.";
    private static final String FORMAT_QUEST_SUCCESS_PATH = "Format.success.";
    private static final String FORMAT_PROGRESS_QUEST_PERCENTAGE_IMAGE_PATH = "Format.percentage_image.";

    private static final String PLAYER_DATA_USE_TITLE = "Format.player_title.nothing";
    private static final String PLAYER_DATA_RECEIVE_MESSAGE = "Format.receive_message.";
    private static final String PLAYER_DATA_VIEW_PARTICLE = "Format.view_particle.";

    /**
     * 建構子
     */
    public PluginFormat() {
        super("", "Format.yml");
    }

    /**
     * 獲取任務類型的字串
     * @param type 任務類型
     * @return 字串
     */
    @NotNull
    public String getQuestTypeString(final @NotNull QuestType type) {
        return this.getString(FORMAT_QUEST_TYPE_PATH + type.getName());
    }

    /**
     * 獲取任務開放狀態的字串
     * @param isEnable 是否啟用
     * @return 字串
     */
    @NotNull
    public String getQuestEnableString(final boolean isEnable) {
        return this.getString(FORMAT_QUEST_ENABLE_PATH + isEnable);
    }

    /**
     * 獲取任務隱藏狀態的字串
     * @param isVisible 是否隱藏
     * @return 字串
     */
    @NotNull
    public String getQuestVisibleString(final boolean isVisible) {
        return this.getString(FORMAT_QUEST_VISIBLE_PATH + isVisible);
    }

    /**
     * 獲取玩家應該看到的任務訊息
     * @param quest 任務
     * @param player 玩家
     * @return 字串
     */
    @NotNull
    public String getPlayerQuestMessageString(final @NotNull Quest quest, final @NotNull Player player) {
        return quest.isSuccess(player) ? quest.getQuestSuccessMessage() : quest.getQuestMessage();
    }

    /**
     * 獲取任務進行中或是達成的訊息
     * @param isSuccess 是否完成
     * @return 字串
     */
    @NotNull
    public String getQuestSuccessString(final boolean isSuccess) {
        return this.getString(FORMAT_QUEST_SUCCESS_PATH + isSuccess);
    }

    /**
     * 獲取任務引王狀態的字串
     * @param progressNumber 百分比
     * @return 字串
     */
    @NotNull
    public String getQuestProgressImage(final int progressNumber) {
        for(int i = 100; i >= 0; i -= 10)
            if(progressNumber >= i)
                return this.getString(FORMAT_PROGRESS_QUEST_PERCENTAGE_IMAGE_PATH + i);

        return "§4ERROR";
    }

    /**
     * 獲取任務的介面物品標題
     * @param quest 任務
     * @return 字串
     */
    @NotNull
    public String getFormatHead(final @NotNull Quest quest) {
        return this.getString(
                FORMAT_QUEST_FORMAT_MAIN_PATH +
                        quest.getQuestType().getName() +
                        FORMAT_QUEST_HEAD_FORMAT_PATH
        );
    }

    /**
     * 獲取任務的介面物品說明
     * @param quest 任務
     * @return 字串
     */
    @NotNull
    public List<String> getFormatBody(final @NotNull Quest quest) {
        return this.getStringList(
                FORMAT_QUEST_FORMAT_MAIN_PATH +
                        quest.getQuestType().getName() +
                        FORMAT_QUEST_BODY_FORMAT_PATH
        );
    }

    /**
     * 獲取任務隱藏狀態的字串
     * @param isReceiveMessage 是否接收
     * @return 字串
     */
    @NotNull
    public String getPlayerReceiveMessageString(final boolean isReceiveMessage) {
        return this.getString(PLAYER_DATA_RECEIVE_MESSAGE + isReceiveMessage);
    }

    /**
     * 獲取任務開放狀態的字串
     * @param isViewParticle 是否可見
     * @return 字串
     */
    @NotNull
    public String getPlayerViewParticleString(final boolean isViewParticle) {
        return this.getString(PLAYER_DATA_VIEW_PARTICLE + isViewParticle);
    }

    /**
     * 獲取玩家當前使用的稱號
     * @param title 稱號
     * @return 字串
     */
    @NotNull
    public String getPlayerUseTitle(final @Nullable Title title) {
        return title != null ? title.getTitle() : this.getString(PLAYER_DATA_USE_TITLE);
    }

    /**
     * 獲取任務開放狀態的字串
     * @return 字串
     */
    @NotNull
    public String getPlayerDataFormatHead() {
        return this.getString(FORMAT_PLAYER_DATA_HEAD_FORMAT_PATH);
    }

    /**
     * 獲取任務的介面物品說明
     *
     * @return 字串
     */
    @NotNull
    public List<String> getPlayerDataFormatBody() {
        return this.getStringList(FORMAT_PLAYER_DATA_BODY_FORMAT_PATH);
    }

}
