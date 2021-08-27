package moubiequest.core.format;

import moubiequest.api.format.FormatReplacer;
import moubiequest.api.yaml.plugin.FormatFile;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 代表一個基礎佔位符格式轉換介面
 * @param <T> 任何類型
 * @author MouBieCat
 */
public abstract class FormatAbstract<T>
        implements FormatReplacer<T> {

    // 轉換的物件
    protected final T replacer;

    // 讀取格式的文件
    protected final FormatFile formatFile;

    /**
     * 建構子
     * @param obj 轉換物件
     * @param file 格式檔案
     */
    public FormatAbstract(final @NotNull T obj, final @NotNull FormatFile file) {
        this.replacer = obj;
        this.formatFile = file;
    }

    /**
     * 將文字集合的站位符轉換
     * @param list   訊息格式
     * @param player 轉換的玩家資訊
     * @return 轉換後的文字集合
     */
    @NotNull
    public final List<String> replaceList(final @NotNull List<String> list, final @NotNull Player player) {
        final List<String> newList = new ArrayList<>();

        // 迴圈轉換所有字串
        for (String str : list)
            newList.add(this.replace(str, player));

        return newList;
    }

    /**
     * 獲取轉換的物件類型
     * @return 轉換的物件
     */
    @NotNull
    public final T getReplacer() {
        return this.replacer;
    }

}
