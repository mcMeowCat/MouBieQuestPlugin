package moubiequest.api.itemstack.gui.quest;

import moubiequest.api.itemstack.gui.button.PlayerUItem;
import moubiequest.api.itemstack.gui.GUIBuilder;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個受編輯的任務操作介面
 * @author MouBieCat
 */
public interface QuestGUIBuilder
        extends GUIBuilder, QuestGUI {

    /**
     * 添加一個按鈕到介面
     * @param uItem 介面物品實例
     * @param player 玩家
     */
    void addUItem(final @NotNull PlayerUItem uItem, final @NotNull Player player);

}
