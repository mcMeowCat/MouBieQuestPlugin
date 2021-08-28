package moubiequest.core.nms;

import moubiequest.api.nms.ParticleHandler;
import moubiequest.api.particle.ParticleType;
import net.minecraft.core.particles.ParticleParam;
import net.minecraft.network.protocol.game.PacketPlayOutWorldParticles;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftParticle;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 該操作類只適用於 Minecraft 架構 (v1_17_R1)
 * @author MouBieCat
 */
public final class ParticleHandler_v1_17_R2
        implements ParticleHandler {

    /**
     * 獲取當前使用的 Minecraft nms 版本
     * @return 版本
     */
    @NotNull
    public String getVersion() {
        return "v1_17_R1";
    }

    /**
     * 發送一個粒子特效
     * @param player   玩家
     * @param location 位置
     * @param particle 特效
     */
    @Override
    public void spawnParticle(final @NotNull Player player, final @NotNull Location location, final @NotNull ParticleType<?> particle) {
        final ParticleParam particleParam = CraftParticle.toNMS(particle.getParticle(), particle.getParticleObject());
        final PacketPlayOutWorldParticles particles =
                new PacketPlayOutWorldParticles(particleParam, true, location.getX(), location.getY(), location.getZ(), 0f, 0f, 0f, 0, 0);

        ((CraftPlayer) player).getHandle().b.sendPacket(particles);
    }

}
