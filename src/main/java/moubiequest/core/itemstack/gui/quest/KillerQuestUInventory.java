package moubiequest.core.itemstack.gui.quest;

import moubiequest.api.itemstack.gui.button.QuestUItem;
import moubiequest.api.itemstack.gui.quest.KillerQuestGUI;
import moubiequest.api.quest.KillerQuest;
import moubiequest.api.quest.QuestType;
import moubiequest.core.itemstack.gui.button.KillerUItemBuilder;
import moubiequest.main.MouBieCat;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
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

        // 如果頁數 >1 則添加上一頁按鈕
        if (page > 1) this.addUItem(this.previousButton);

        // 創建任務表
        final List<KillerQuest> newQuestList = new ArrayList<>();
        final Collection<KillerQuest> quests = MouBieCat.getInstance().getKillerQuestManager().getQuests();

        // 根據 QuestView 選擇排序任務方法
        switch (this.viewType) {
            case ALL:
                newQuestList.addAll(quests);
                break;
            case SUCCESS:
                for (final KillerQuest quest : quests) {
                    if (quest.isSuccess(player))
                        newQuestList.add(quest);
                }
                if (newQuestList.size() == 0)
                    this.addUItem(this.questAllNotSuccess);
                break;
            case NO_SUCCESS:
                for (final KillerQuest quest : quests) {
                    if (!quest.isSuccess(player))
                        newQuestList.add(quest);
                }
                if (newQuestList.size() == 0)
                    this.addUItem(this.questAllSuccess);
                break;
        }

        try {
            // 計算迴圈任務起始
            int startQuest = (page - 1) * INVENTORY_QUEST_SLOT_BUTTON.length;

            // 迴圈開始編排任務
            for (int slot = 9; slot < 45; slot++) {
                final KillerQuest quest = newQuestList.get(startQuest++);
                final QuestUItem<KillerQuest> questUItem = new KillerUItemBuilder(quest, slot);
                this.addUItem(questUItem, player);
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
    }

}
