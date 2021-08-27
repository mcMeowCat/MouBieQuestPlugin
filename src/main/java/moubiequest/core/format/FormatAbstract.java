package moubiequest.core.format;

import moubiequest.api.format.FormatReplacer;
import moubiequest.api.yaml.plugin.FormatFile;
import org.jetbrains.annotations.NotNull;

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
     */
    public FormatAbstract(final @NotNull T obj, final @NotNull FormatFile file) {
        this.replacer = obj;
        this.formatFile = file;
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
