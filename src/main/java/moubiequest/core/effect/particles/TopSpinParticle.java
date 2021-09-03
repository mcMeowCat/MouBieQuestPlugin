package moubiequest.core.effect.particles;

import moubiequest.api.particle.ParticleLocus;
import moubiequest.api.particle.ParticleType;
import moubiequest.main.MouBieCat;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 代表一個在頭上旋轉的特效軌跡
 * @author MouBieCat
 */
public final class TopSpinParticle
        extends ParticleAbstract {

    private double t; //時間

    /**
     * 建構子
     * @param player    玩家
     * @param particles 特效集合
     */
    public TopSpinParticle(final @NotNull Player player, final @NotNull List<ParticleType> particles) {
        super(player, ParticleLocus.TOP_SPIN, particles);
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        if (!this.player.isOnline())
            this.cancel();

        if (this.t >= 6.28) {
            this.t = 0;
        }

        final double x = Math.sin(this.t);
        final double z = Math.cos(this.t);

        for (final Player player : this.getPlayerRangePlayers(this.player)) {
            if (!this.checkPlayerViewParticleData(player))
                continue;

            final Location clone = this.player.getLocation().clone();
            final Location particleLocation = clone.add(x, 2.5, z);

            if (this.hasGenerateParticle(player, particleLocation))
                this.generateParticle(player, particleLocation);
        }

        this.t += 0.25;
    }

    /**
     * 開始運行
     */
    @Override
    public void start() {
        this.runTaskTimer(MouBieCat.getInstance(), 0L, 1L);
    }

    /**
     * 停止運行
     */
    @Override
    public void stop() {
        this.cancel();
    }

}
