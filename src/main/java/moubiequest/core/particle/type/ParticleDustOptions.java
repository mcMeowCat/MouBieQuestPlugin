package moubiequest.core.particle.type;

import org.bukkit.Particle;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個 DustOptions
 * @author MouBieCat
 */
public final class ParticleDustOptions
        extends ParticleTypeAbstract<Particle.DustOptions> {

    /**
     * 建構子
     * @param particle       特效類型
     * @param particleObject 特效資料物件
     */
    public ParticleDustOptions(final @NotNull Particle particle, final @NotNull Particle.DustOptions particleObject) {
        super(particle, particleObject);
    }

}
