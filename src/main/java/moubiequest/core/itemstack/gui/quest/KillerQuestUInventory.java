package moubiequest.core.itemstack.gui.quest;

import moubiequest.api.itemstack.gui.quest.KillerQuestGUI;
import moubiequest.api.quest.QuestType;
import moubiequest.main.MouBieCat;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

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
        //wait code...
    }

    /**
     * 代表當介面被點擊的事件
     * @param event 介面點擊事件
     */
    @Override
    public void clickInventory(final @NotNull InventoryClickEvent event) {
        //wait code...
    }

}
