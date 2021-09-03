package moubiequest.core.effect.particles;

import moubiequest.api.particle.ParticleLocus;
import moubiequest.api.particle.ParticleType;
import moubiequest.main.MouBieCat;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 代表一個由下至上的特效軌跡
 * @author MouBieCat
 */
public final class BottomToTopParticle
        extends ParticleAbstract {

    private double t; //時間
    private double offsetHigh = 0; //高度偏移

    /**
     * 建構子
     * @param player    玩家
     * @param particles 特效集合
     */
    public BottomToTopParticle(final @NotNull Player player, final @NotNull List<ParticleType> particles) {
        super(player, ParticleLocus.BOTTOM_TO_TOP, particles);
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

        if(this.offsetHigh >= 2) {
            this.t = 0.0;
            this.offsetHigh = 0.0;
        }

        final double x = Math.sin(this.t);
        final double z = Math.cos(this.t);

        for (final Player player : this.getPlayerRangePlayers(this.player)) {
            if (!this.checkPlayerViewParticleData(player))
                continue;

            final Location clone = this.player.getLocation().clone();
            final Location particleLocation = clone.add(x, offsetHigh, z);

            if (this.hasGenerateParticle(player, particleLocation))
                this.generateParticle(player, particleLocation);
        }

        t += 0.25;
        offsetHigh += 0.02;
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
