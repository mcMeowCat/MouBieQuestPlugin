package moubiequest.core.effect.particles;

import moubiequest.api.data.quest.ParticleData;
import moubiequest.api.nms.ParticleHandler;
import moubiequest.api.particle.ParticleLocus;
import moubiequest.api.particle.ParticleTimer;
import moubiequest.api.particle.ParticleType;
import moubiequest.api.yaml.plugin.ConfigFile;
import moubiequest.main.MouBieCat;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 代表一個粒子特效線程的基底類
 * @author MouBieCat
 */
public abstract class ParticleAbstract
        extends BukkitRunnable
        implements ParticleTimer {

    // 特效擁有者
    protected final Player player;

    // 特效軌跡
    protected final ParticleLocus locus;

    // 特效集合
    protected final List<ParticleType> particles;

    /**
     * 建構子
     * @param player 玩家
     * @param locus 軌跡類型
     * @param particles 特效集合
     */
    public ParticleAbstract(final @NotNull Player player, final @NotNull ParticleLocus locus, final @NotNull List<ParticleType> particles) {
        this.player = player;
        this.locus = locus;
        this.particles = particles;
    }

    /**
     * 獲取特效擁有者
     * @return 玩家
     */
    @NotNull
    public final Player getPlayer() {
        return this.player;
    }

    /**
     * 獲取特效軌跡類型
     * @return 軌跡類型
     */
    @NotNull
    public final ParticleLocus getParticleType() {
        return this.locus;
    }

    /**
     * 獲取特效集合
     * @return 特效集合
     */
    @NotNull
    public final List<ParticleType> getParticles() {
        return this.particles;
    }

    /**
     * 生成粒子效果
     * @param var1 對該玩家發送封包
     * @param var2 座標
     */
    protected final void generateParticle(final @NotNull Player var1, final @NotNull Location var2) {
        final ParticleHandler handler = MouBieCat.getInstance().getNmsManager().getParticleHandler();
        for (final ParticleType particle : this.particles)
            handler.spawnParticle(var1, var2, particle);
    }

    /**
     * 檢查該座標是否可以對某個玩家生成效果
     * @param var1 玩家
     * @param var2 生成座標
     * @return 是否可以生成
     */
    protected final boolean hasGenerateParticle(final @NotNull Player var1, final @NotNull Location var2) {
        final ConfigFile configFile = MouBieCat.getInstance().getConfigFile();
        final Location location = var1.getEyeLocation();
        if (location.distance(var2) < configFile.getSpawnParticleMinRange()) {
            final Vector vector = var2.toVector().subtract(location.toVector()).normalize();
            final double dot = vector.dot(location.getDirection());
            return (dot < configFile.getSpawnParticleMinDot());
        }
        return true;
    }

    /**
     * 檢查玩家是否想接收到特效
     * @param var1 玩家
     * @return 是否可以生成
     */
    protected final boolean checkPlayerViewParticleData(final @NotNull Player var1) {
        if (var1 == this.player) return true;
        final ParticleData dataFile = MouBieCat.getInstance().getPlayerDataManager().get(player);
        return dataFile.isViewParticle();
    }

    /**
     * 獲取該玩家周圍的所有玩家集合 (包括自己)
     *
     * @param var1 玩家
     * @return 玩家集合
     */
    @NotNull
    protected final List<Player> getPlayerRangePlayers(final @NotNull Player var1) {
        final List<Player> list = new ArrayList<>();

        final ConfigFile configFile = MouBieCat.getInstance().getConfigFile();
        final double maxRange = configFile.getSpawnParticleToPlayerMaxRange();

        list.add(var1);
        for (final Entity entity : var1.getNearbyEntities(maxRange, maxRange, maxRange))
            if (entity instanceof Player)
                list.add((Player) entity);

        return list;
    }

}
