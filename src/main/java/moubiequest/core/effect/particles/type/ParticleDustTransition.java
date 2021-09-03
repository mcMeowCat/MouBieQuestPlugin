package moubiequest.core.effect.particles.type;

import org.bukkit.Particle;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個 DustTransition
 * @author MouBieCat
 */
public final class ParticleDustTransition
        extends ParticleTypeAbstract<Particle.DustTransition> {

    /**
     * 建構子
     * @param particle       特效類型
     * @param particleObject 特效資料物件
     */
    public ParticleDustTransition(final @NotNull Particle particle, final @NotNull Particle.DustTransition particleObject) {
        super(particle, particleObject);
    }

}
