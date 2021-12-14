package moubiequest.api.nms;

import org.jetbrains.annotations.NotNull;

/**
 * 代表一個 nms 操作類的基礎介面
 */
public interface Handler {

    /**
     * 獲取當前使用的 Minecraft nms 版本
     * @return 版本
     */
    @NotNull String getVersion();

}
