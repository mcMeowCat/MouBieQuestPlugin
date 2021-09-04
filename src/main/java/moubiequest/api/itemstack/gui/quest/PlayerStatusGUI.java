package moubiequest.api.itemstack.gui.quest;

import moubiequest.api.itemstack.gui.GUI;
import org.jetbrains.annotations.NotNull;

/**
 * 有關玩家狀態設定的選單介面
 * @author MouBieCat
 */
public interface PlayerStatusGUI
        extends GUI {

    /**
     * 獲取下層介面
     * @return 介面
     */
    @NotNull GUI getBackInventory();

}
