package moubiequest.core.quest.object;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 用於儲存任務稱號套用相關的物件
 * @author MouBieCat
 */
public final class Title {

    // 任務稱號名稱
    private final String quest_title;

    /**
     * 建構子
     * @param title 稱號
     */
    public Title(final @NotNull String title) {
        this.quest_title = title;
    }

    /**
     * 獲取稱號名
     * @return 稱號
     */
    public String getTitle() {
        return quest_title;
    }

    /**
     * 套用稱號至玩家
     * @param player 玩家
     */
    public void usingTitleForPlayer(final @NotNull Player player) {

    }

}
