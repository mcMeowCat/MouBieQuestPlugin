package moubiequest.core.effect.particles.type;

import moubiequest.api.particle.ParticleType;
import org.bukkit.Particle;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個不帶任何資料的粒子特效
 * @author MouBieCat
 */
public class ParticleBase
        implements ParticleType {

    // 特效類型
    private final Particle particle;

    /**
     * 建構子
     * @param particle 特效類型
     */
    public ParticleBase(final @NotNull Particle particle) {
        this.particle = particle;
    }

    /**
     * 獲取特效類型
     * @return 特效類型
     */
    @NotNull
    public final Particle getParticle() {
        return this.particle;
    }

}
