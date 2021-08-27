package moubiequest.core.yaml.plugin;

import moubiequest.api.quest.Quest;
import moubiequest.api.quest.QuestType;
import moubiequest.api.yaml.plugin.FormatFile;
import org.jetbrains.annotations.NotNull;

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

    private static final String FORMAT_QUEST_TYPE_PATH = "Format.quest_type.";
    private static final String FORMAT_QUEST_ENABLE_PATH = "Format.quest_enable.";
    private static final String FORMAT_QUEST_VISIBLE_PATH = "Format.quest_visible.";
    private static final String FORMAT_QUEST_SUCCESS_PATH = "Format.success.";
    private static final String FORMAT_PROGRESS_QUEST_PERCENTAGE_IMAGE_PATH = "Format.percentage_image.";

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

}
