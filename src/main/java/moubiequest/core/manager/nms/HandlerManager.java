package moubiequest.core.manager.nms;

import moubiequest.api.manager.NMSManager;
import moubiequest.api.nms.Handler;
import moubiequest.api.nms.NBTHandler;
import moubiequest.api.nms.ParticleHandler;
import moubiequest.core.nms.NBTTagHandler_v1_17_R1;
import moubiequest.core.manager.ManagerAbstract;
import moubiequest.core.nms.ParticleHandler_v1_17_R2;
import moubiequest.main.MouBieCat;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

/**
 * 記錄所有有關 nms 操作類的管理器
 * @author MouBieCat
 */
public final class HandlerManager
        extends ManagerAbstract<HandlerManager.NMSHandlerType, Handler>
        implements NMSManager {

    /**
     * NMS操作類的列舉類型
     */
    public enum NMSHandlerType { NBT_TAG, PARTICLE }

    /**
     * 建構子
     */
    public HandlerManager() {
        // 獲取當前運行的 Bukkit 版本
        final String versionStr = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

        // 判斷版本，如果該插件不支持。自動卸載該插件
        try {
            if ("v1_17_R1".equals(versionStr)) {
                this.add(NMSHandlerType.NBT_TAG, new NBTTagHandler_v1_17_R1());
                this.add(NMSHandlerType.PARTICLE, new ParticleHandler_v1_17_R2());
            }

            else
                throw new ClassNotFoundException();

        } catch (ClassNotFoundException e) {
            // 卸載插件
            System.out.println(MouBieCat.PLUGIN_TITLE + "§c該插件不支持您伺服器的版本。請伺服器所有者回報給插件作者！");
            Bukkit.getPluginManager().disablePlugin(MouBieCat.getInstance());
        }
    }

    /**
     * 獲取操作NBTTag的介面類
     * @return NBTHandler
     */
    @NotNull
    public NBTHandler getNbtHandler() {
        return (NBTHandler) this.get(NMSHandlerType.NBT_TAG);
    }

    /**
     * 獲取操作粒子特效的介面類
     * @return NBTHandler
     */
    @NotNull
    public ParticleHandler getParticleHandler() {
        return (ParticleHandler) this.get(NMSHandlerType.PARTICLE);
    }

    /**
     * 獲取一個 NMS 操作類
     * @param key k 操作類型
     * @return NMS操作類
     */
    @NotNull
    public Handler get(final @NotNull NMSHandlerType key) {
        return this.manager.get(key);
    }

}
