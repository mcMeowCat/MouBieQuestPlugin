package moubiequest.core.itemstack.gui.quest;

import moubiequest.api.itemstack.gui.button.QuestUItem;
import moubiequest.api.itemstack.gui.button.UItem;
import moubiequest.api.itemstack.gui.quest.QuestGUIBuilder;
import moubiequest.api.itemstack.gui.quest.QuestView;
import moubiequest.api.quest.QuestType;
import moubiequest.api.yaml.plugin.InventoryFile;
import moubiequest.core.itemstack.gui.PageUInventoryAbstract;
import moubiequest.core.itemstack.gui.button.UItemStackBuilder;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
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
    protected static final int INVENTORY_SUCCESS_AND_NOT_SUCCESS_BUTTON = 31;

    public static final int[] INVENTORY_QUEST_SLOT_BUTTON = new int[] {
            9, 10, 11, 12, 13, 14, 15, 16, 17,
            18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28, 29, 30, 31, 32, 33, 34, 35,
            36, 37, 38, 39, 40, 41, 42, 43, 44
    };

    // 介面檔案
    protected final InventoryFile inventoryFile;

    // 顯示方式 (預設=所有)
    protected QuestView viewType = QuestView.ALL;

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

    // 任務全部完成
    protected final UItem questAllSuccess;

    // 沒有任何完成的任務
    protected final UItem questAllNotSuccess;

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

        // 解析通用按鈕 (任務全部完成)
        builder = new UItemStackBuilder(this.inventoryFile.getCommonButton("quest_all_success"), INVENTORY_SUCCESS_AND_NOT_SUCCESS_BUTTON);
        this.questAllSuccess = builder;

        // 解析通用按鈕 (任務全部尚未傳承)
        builder = new UItemStackBuilder(this.inventoryFile.getCommonButton("quest_all_not_success"), INVENTORY_SUCCESS_AND_NOT_SUCCESS_BUTTON);
        this.questAllNotSuccess = builder;
    }

    /**
     * 初始化介面
     * @param player 玩家
     * @param page   頁數
     */
    @Override
    protected void initPageInventory(@NotNull Player player, int page) {
        // 清除介面所有按拗
        this.clearInventory();

        // 添加基本按鈕
        this.addUItem(this.questAllButton).addUItem(this.questSuccessButton).addUItem(this.questNoSuccessButton);
    }

    /**
     * 添加一個按鈕到介面
     * @param uItem 介面物品實例
     * @param player 玩家
     */
    public void addUItem(final @NotNull QuestUItem<?> uItem, final @NotNull Player player) {
        this.inventory.setItem(uItem.getSlotId(), uItem.build(player));
    }

    /**
     * 獲取當前的顯示方式類型
     * @return 顯示方式
     */
    public final @NotNull QuestView getViewType() {
        return this.viewType;
    }

    /**
     * 設定當前的顯示方式類型
     * @param viewType 顯示方式
     */
    public final void setViewType(final @NotNull QuestView viewType) {
        this.setPage(1);
        this.viewType = viewType;
    }

    /**
     * 代表當介面被點擊的事件
     * @param event 介面點擊事件
     */
    @Override
    public void clickInventory(final @NotNull InventoryClickEvent event) {
        event.setCancelled(true);
        final HumanEntity whoClicked = event.getWhoClicked();

        if (whoClicked instanceof Player && event.getCurrentItem() != null) {
            final Player clickPlayer = (Player) whoClicked;
            final int slot = event.getSlot();

            // 上一頁
            if (slot == INVENTORY_PREVIOUS_PAGE_BUTTON) {
                this.previousPage(clickPlayer);
                clickPlayer.playSound(clickPlayer.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 5f, 1.5f);
            }

            // 下一頁
            else if (slot == INVENTORY_NEXT_PAGE_BUTTON) {
                this.nextPage(clickPlayer);
                clickPlayer.playSound(clickPlayer.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 5f, 1.5f);
            }

            // 顯示全部任務
            else if (slot == INVENTORY_QUEST_ALL_BUTTON) {
                this.setViewType(QuestView.ALL);
                this.initPageInventory(clickPlayer, this.getPage());
                clickPlayer.playSound(clickPlayer.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 5f, 1.5f);
            }

            // 只顯示完成任務
            else if (slot == INVENTORY_QUEST_SUCCESS_BUTTON) {
                this.setViewType(QuestView.SUCCESS);
                this.initPageInventory(clickPlayer, this.getPage());
                clickPlayer.playSound(clickPlayer.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 5f, 1.5f);
            }

            // 只顯示未完成任務
            else if (slot == INVENTORY_QUEST_NO_SUCCESS_BUTTON) {
                this.setViewType(QuestView.NO_SUCCESS);
                this.initPageInventory(clickPlayer, this.getPage());
                clickPlayer.playSound(clickPlayer.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 5f, 1.5f);
            }

        }
    }

}
