package moubiequest.api.nms;

import moubiequest.api.particle.ParticleType;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個有關可以操作世界粒子特效的介面
 * @author MouBieCat
 */
public interface ParticleHandler
        extends Handler {

    /**
     * 發送一個粒子特效
     * @param player 玩家
     * @param location 位置
     * @param particle 特效實例
     */
    void spawnParticle(final @NotNull Player player, final @NotNull Location location, final @NotNull ParticleType particle);

}
