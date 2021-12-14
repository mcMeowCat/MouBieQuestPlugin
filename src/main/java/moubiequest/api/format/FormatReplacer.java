package moubiequest.api.format;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 代表一個佔位符格式轉換介面
 * @param <T> 任何類型
 * @author MouBieCat
 */
public interface FormatReplacer<T> {

    /**
     * 將文字的站位符轉換
     * @param msg 訊息格式
     * @param player 轉換的玩家資訊
     */
    @NotNull String replace(final @NotNull String msg, final @NotNull Player player);

    /**
     * 將文字集合的站位符轉換
     * @param list 訊息格式
     * @param player 轉換的玩家資訊
     * @return 轉換後的文字集合
     */
    @NotNull List<String> replaceList(final @NotNull List<String> list, final @NotNull Player player);

    /**
     * 獲取轉換的物件類型
     * @return 轉換的物件
     */
    @NotNull T getReplacer();

}
