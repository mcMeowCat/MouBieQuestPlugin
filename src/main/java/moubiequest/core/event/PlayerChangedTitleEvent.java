package moubiequest.core.event;

import moubiequest.api.quest.Quest;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 當玩家完成變更稱號事件
 * @author MouBieCat
 */
public class PlayerChangedTitleEvent
        extends PlayerQuestEvent {

    private static final HandlerList handlers = new HandlerList();

    public PlayerChangedTitleEvent(final @NotNull Player who, final @NotNull Quest quest) {
        super(who, quest);
    }

    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
