package moubiequest.api.manager;

import moubiequest.api.nms.Handler;
import moubiequest.api.nms.NBTHandler;
import moubiequest.core.manager.HandlerManager;
import org.jetbrains.annotations.NotNull;

/**
 * 記錄所有有關 nms 操作類的管理器介面
 * @author MouBieCat
 */
public interface NMSManager
        extends Manager<HandlerManager.NMSHandlerType, Handler> {

    /**
     * 獲取操作NBTTag的介面類
     * @return NBTHandler
     */
    @NotNull NBTHandler getNbtHandler();

    /**
     * 獲取一個 NMS 操作類
     * @param key k 操作類型
     * @return NMS操作類
     */
    @NotNull Handler get(final @NotNull HandlerManager.NMSHandlerType key);

}
