package moubiequest.core.itemstack.gui.quest;

import moubiequest.api.itemstack.gui.button.QuestUItem;
import moubiequest.api.itemstack.gui.button.UItem;
import moubiequest.api.itemstack.gui.ui.QuestGUIBuilder;
import moubiequest.api.quest.QuestType;
import moubiequest.api.yaml.plugin.InventoryFile;
import moubiequest.core.itemstack.gui.PageUInventoryAbstract;
import moubiequest.core.itemstack.gui.button.UItemStackBuilder;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個基礎的任務介面操作類
 * @author MouBieCat
 */
public abstract class QuestUInventoryAbstract
        extends PageUInventoryAbstract
        implements QuestGUIBuilder {

    protected static final int INVENTORY_PREVIOUS_PAGE_BUTTON = 52;
    protected static final int INVENTORY_NEXT_PAGE_BUTTON = 53;

    protected static final int INVENTORY_QUEST_ALL_BUTTON = 3;
    protected static final int INVENTORY_QUEST_SUCCESS_BUTTON = 4;
    protected static final int INVENTORY_QUEST_NO_SUCCESS_BUTTON = 5;

    public static final int[] INVENTORY_QUEST_SLOT_BUTTON = new int[] {
            9, 10, 11, 12, 13, 14, 15, 16, 17,
            18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28, 29, 30, 31, 32, 33, 34, 35,
            36, 37, 38, 39, 40, 41, 42, 43, 44
    };

    /**
     * 任務顯示方式
     * 所有、完成、未完成
     */
    public enum View {
        ALL,
        SUCCESS,
        NO_SUCCESS
    }

    // 介面檔案
    protected final InventoryFile inventoryFile;

    // 顯示方式 (預設=所有)
    protected View viewType = View.ALL;

    // 下一頁按鈕
    protected final UItem nextButton;

    // 上一頁按鈕
    protected final UItem previousButton;

    // 顯示方式按鈕(所有)
    protected final UItem questAllButton;

    // 顯示方式按鈕(完成)
    protected final UItem questSuccessButton;

    // 顯示方式按鈕(未完成)
    protected final UItem questNoSuccessButton;

    /**
     * 建構子
     * @param inventoryFile 介面檔案
     * @param type 任務類型
     */
    public QuestUInventoryAbstract(final @NotNull InventoryFile inventoryFile, final @NotNull QuestType type) {
        super(inventoryFile.getQuestInventoryTitle(type), InventorySize.SIX);
        this.inventoryFile = inventoryFile;

        UItemStackBuilder builder;

        // 解析通用按鈕 (上一頁)
        builder = new UItemStackBuilder(this.inventoryFile.getCommonButton("previous"), INVENTORY_PREVIOUS_PAGE_BUTTON);
        this.previousButton = builder;

        // 解析通用按鈕 (下一頁)
        builder = new UItemStackBuilder(this.inventoryFile.getCommonButton("next"), INVENTORY_NEXT_PAGE_BUTTON);
        this.nextButton = builder;

        // 解析通用按鈕 (顯示方式按鈕(所有))
        builder = new UItemStackBuilder(this.inventoryFile.getCommonButton("quest_all"), INVENTORY_QUEST_ALL_BUTTON);
        this.questAllButton = builder;

        // 解析通用按鈕 (顯示方式按鈕(完成))
        builder = new UItemStackBuilder(this.inventoryFile.getCommonButton("quest_success"), INVENTORY_QUEST_SUCCESS_BUTTON);
        this.questSuccessButton = builder;

        // 解析通用按鈕 (顯示方式按鈕(未完成))
        builder = new UItemStackBuilder(this.inventoryFile.getCommonButton("quest_no_success"), INVENTORY_QUEST_NO_SUCCESS_BUTTON);
        this.questNoSuccessButton = builder;
    }

    public void addUItem(final @NotNull QuestUItem<?> uItem, final @NotNull Player player) {
        this.inventory.setItem(uItem.getSlotId(), uItem.build(player));
    }

    /**
     * 獲取當前的顯示方式類型
     * @return 顯示方式
     */
    public final @NotNull View getViewType() {
        return this.viewType;
    }

    /**
     * 設定當前的顯示方式類型
     * @param viewType 顯示方式
     */
    public final void setViewType(final @NotNull View viewType) {
        this.viewType = viewType;
    }

}
