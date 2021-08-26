package moubiequest.core.manager.loader;

import moubiequest.api.manager.QuestLoader;
import moubiequest.api.quest.Quest;
import moubiequest.core.quest.QuestType;
import moubiequest.core.yaml.Loader;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

/**
 * 用於將YAML的任務格式轉換成記憶體類
 * @author MouBieCat
 */
public abstract class QuestLoaderAbstract<T extends Quest>
        extends Loader
        implements QuestLoader<T> {

    protected static final String QUEST = "Quests";

    protected static final String QUEST_DATA_MAIN_PATH = "Quests.";

    private static final String QUEST_DATA_TITLE_NAME_PATH = ".title.name";

    private static final String QUEST_DATA_MESSAGE_MESSAGE_PATH = ".message.message";
    private static final String QUEST_DATA_MESSAGE_SUCCESS_MESSAGE_PATH = ".message.success_message";

    private static final String QUEST_DATA_STATUS_ENABLE_PATH = ".status.enable";
    private static final String QUEST_DATA_STATUS_VISIBLE_PATH = ".status.visible";

    private static final String QUEST_DATA_ITEM_MATERIAL_PATH = ".item.material";
    private static final String QUEST_DATA_ITEM_DISPLAY_NAME_PATH = ".item.display_name";
    private static final String QUEST_DATA_ITEM_LORE_PATH = ".item.lore";

    private static final String QUEST_DATA_HONOR_POINT_PATH = ".honor_point";

    /**
     * 建構子
     * @param type 解析的任務類型
     */
    public QuestLoaderAbstract(final @NotNull QuestType type) {
        super("quests", type.getName().toLowerCase() + ".yml", false);
    }

    /**
     * 解析任務的稱號標題
     * @param key 任務識別碼
     * @return 稱號標題
     */
    @NotNull
    public final String parsingQuestTitleName(final @NotNull String key) {
        return this.getString(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_TITLE_NAME_PATH);
    }

    /**
     * 解析任務的任務訊息
     * @param key 任務識別碼
     * @return 任務訊息
     */
    @NotNull
    public final String parsingQuestMessage(final @NotNull String key) {
        return this.getString(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_MESSAGE_MESSAGE_PATH);
    }

    /**
     * 解析任務的完成訊息
     * @param key 任務識別碼
     * @return 完成訊息
     */
    @NotNull
    public final String parsingQuestSuccessMessage(final @NotNull String key) {
        return this.getString(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_MESSAGE_SUCCESS_MESSAGE_PATH);
    }

    /**
     * 解析任務的開啟狀態
     * @param key 任務識別碼
     * @return 開關狀態
     */
    public final boolean parsingQuestStatusEnable(final @NotNull String key) {
        return this.getBoolean(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_STATUS_ENABLE_PATH);
    }

    /**
     * 解析任務的隱藏狀態
     * @param key 任務識別碼
     * @return 隱藏狀態
     */
    public final boolean parsingQuestStatusVisible(final @NotNull String key) {
        return this.getBoolean(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_STATUS_VISIBLE_PATH);
    }

    /**
     * 解析任務的介面物品材質
     * @param key 任務識別碼
     * @return 物品材質
     */
    @NotNull
    public final Material parsingQuestItemMaterial(final @NotNull String key) {
        return Material.valueOf(this.getString(
                QUEST_DATA_MAIN_PATH + key + QUEST_DATA_ITEM_MATERIAL_PATH
        ).toUpperCase());
    }

    /**
     * 解析任務的介面物品標題
     * @param key 任務識別碼
     * @return 物品標題
     */
    @NotNull
    public final String parsingQuestItemDisplayName(final @NotNull String key) {
        return this.getString(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_ITEM_DISPLAY_NAME_PATH);
    }

    /**
     * 解析任務的介面物品說明
     * @param key 任務識別碼
     * @return 物品說明
     */
    @NotNull
    public final List<String> parsingQuestItemLore(final @NotNull String key) {
        return this.getStringList(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_ITEM_LORE_PATH);
    }

    /**
     * 解析任務的榮譽點數
     * @param key 任務識別碼
     * @return 榮譽點數
     */
    public final int parsingQuestHonorPoint(final @NotNull String key) {
        return this.getInt(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_HONOR_POINT_PATH);
    }

}
