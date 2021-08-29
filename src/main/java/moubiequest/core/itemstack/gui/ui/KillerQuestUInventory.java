package moubiequest.core.itemstack.gui.ui;

import moubiequest.api.itemstack.gui.button.QuestUItem;
import moubiequest.api.itemstack.gui.quest.KillerQuestGUI;
import moubiequest.api.quest.KillerQuest;
import moubiequest.api.quest.QuestType;
import moubiequest.core.itemstack.gui.button.KillerUItemBuilder;
import moubiequest.main.MouBieCat;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 代表一個擊殺任務選單
 * @author MouBieCat
 */
public final class KillerQuestUInventory
        extends QuestUInventoryAbstract
        implements KillerQuestGUI {

    /**
     * 建構子
     */
    public KillerQuestUInventory() {
        super(MouBieCat.getInstance().getInventoryFile(), QuestType.KILLER);
    }

    /**
     * 初始化介面
     * @param player 玩家
     * @param page   頁數
     */
    @Override
    protected void initPageInventory(final @NotNull Player player, final int page) {
        // 先回去運行基本代碼
        super.initPageInventory(player, page);

        // 如果頁數 >0 則添加上一頁按鈕
        if (page > 0) this.addUItem(this.previousButton);

        // 任務排序結果
        final List<KillerQuest> sortQuests = this.getSortQuests(MouBieCat.getInstance().getKillerQuestManager(), player);

        try {
            // 計算迴圈任務起始
            int startQuest = page * INVENTORY_QUEST_SLOT_BUTTON.size();

            // 迴圈開始編排任務
            for (int slot = INVENTORY_QUEST_SLOT_BUTTON.get(0); slot <= INVENTORY_QUEST_SLOT_BUTTON.get(INVENTORY_QUEST_SLOT_BUTTON.size() - 1); slot++) {
                final KillerQuest quest = sortQuests.get(startQuest++);
                this.addUItem(new KillerUItemBuilder(quest, slot), player);
            }
        } catch (final IndexOutOfBoundsException e) { return; }

        // 沒有 IndexOutOfBoundsException 意外也就代表還有更多任務需要顯示。因此添加下一頁按鈕
        this.addUItem(this.nextButton);
    }

    /**
     * 代表當介面被點擊的事件
     * @param event 介面點擊事件
     */
    @Override
    public void clickInventory(final @NotNull InventoryClickEvent event) {
        super.clickInventory(event);

        final HumanEntity whoClicked = event.getWhoClicked();

        if (whoClicked instanceof Player && event.getCurrentItem() != null && INVENTORY_QUEST_SLOT_BUTTON.contains(event.getSlot())) {
            final Player clickPlayer = (Player) whoClicked;

            final String questKey = QuestUItem.getItemStackQuestKey(event.getCurrentItem());

            final KillerQuest quest = MouBieCat.getInstance().getKillerQuestManager().get(questKey);
            if (quest != null && quest.isSuccess(clickPlayer)) {
                quest.usingTitleForPlayer(clickPlayer);
                this.initPageInventory(clickPlayer, this.getPage());
                clickPlayer.playSound(clickPlayer.getLocation(), Sound.ENTITY_VILLAGER_YES, 1f, 1f);
            } else {
                clickPlayer.playSound(clickPlayer.getLocation(), Sound.ENTITY_VILLAGER_NO, 1f, 1f);
            }
        }
    }

}
