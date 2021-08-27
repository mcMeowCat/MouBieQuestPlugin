package moubiequest.api.yaml.plugin;

import moubiequest.api.quest.QuestType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個有關介面資料的檔案介面
 * @author MouBieCat
 */
public interface InventoryFile
        extends PluginFile {

    /**
     * 獲取一個任務類型的介面標題
     *
     * @param type 任務類型
     * @return 標題
     */
    @NotNull String getQuestInventoryTitle(final @NotNull QuestType type);

    /**
     * 獲取介面通用按鈕
     * @return 按鈕
     */
    @NotNull ItemStack getCommonButton(final @NotNull String name);

}
