package moubiequest.core.nms;

import moubiequest.api.nms.NBTHandler;
import org.jetbrains.annotations.NotNull;

/**
 * 該操作類只適用於 Minecraft 架構 (v1_17_R1)
 * @author MouBieCat
 */
public final class NBTTagHandler_v1_17_R1
        implements NBTHandler {

    /**
     * 獲取當前使用的 nms 版本
     * @return 版本
     */
    @NotNull
    public String getVersion() {
        return "v1_17_R1";
    }

}
