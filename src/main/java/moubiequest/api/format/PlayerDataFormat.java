package moubiequest.api.format;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 有關轉換玩家紀錄的站位符介面
 * @author MouBoeCat
 */
public interface PlayerDataFormat
        extends FormatReplacer<Player> {

    /**
     * 將文字的站位符轉換
     * @param msg 訊息格式
     * @param player 轉換的玩家資訊
     */
    @Deprecated
    @NotNull String replace(final @NotNull String msg, final @NotNull Player player);

    /**
     * 將文字集合的站位符轉換
     * @param list 訊息格式
     * @param player 轉換的玩家資訊
     * @return 轉換後的文字集合
     */
    @Deprecated
    @NotNull List<String> replaceList(final @NotNull List<String> list, final @NotNull Player player);

    /**
     * 將文字的站位符轉換
     * @param msg 訊息格式
     */
    @NotNull String replace(final @NotNull String msg);

    /**
     * 將文字集合的站位符轉換
     * @param list 訊息格式
     * @return 轉換後的文字集合
     */
    @NotNull List<String> replaceList(final @NotNull List<String> list);

}
