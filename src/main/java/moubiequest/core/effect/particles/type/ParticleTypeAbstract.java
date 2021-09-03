package moubiequest.core.effect.particles.type;

import moubiequest.api.particle.ParticleDataType;
import org.bukkit.Particle;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個基礎的特效物件類
 * @param <T>
 */
public abstract class ParticleTypeAbstract<T>
        extends ParticleBase
        implements ParticleDataType<T> {

    // 特效資料物件
    private final T particleObject;

    /**
     * 建構子
     * @param particle 特效類型
     * @param particleObject 特效資料物件
     */
    public ParticleTypeAbstract(final @NotNull Particle particle, final @NotNull T particleObject) {
        super(particle);
        this.particleObject = particleObject;
    }

    /**
     * 獲取特效資料物件
     * @return 特效資料物件
     */
    @NotNull
    public final T getParticleObject() {
        return this.particleObject;
    }

}
