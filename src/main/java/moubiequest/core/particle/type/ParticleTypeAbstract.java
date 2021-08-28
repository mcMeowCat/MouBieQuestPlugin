package moubiequest.core.particle.type;

import moubiequest.api.particle.ParticleType;
import org.bukkit.Particle;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個基礎的特效物件類
 * @param <T>
 */
public abstract class ParticleTypeAbstract<T>
        implements ParticleType<T> {

    // 特效類型
    private final Particle particle;

    // 特效資料物件
    private final T particleObject;

    /**
     * 建構子
     * @param particle 特效類型
     * @param particleObject 特效資料物件
     */
    public ParticleTypeAbstract(final @NotNull Particle particle, final @NotNull T particleObject) {
        this.particle = particle;
        this.particleObject = particleObject;
    }

    /**
     * 獲取特效類型
     * @return 類型
     */
    @NotNull
    public final Particle getParticle() {
        return particle;
    }

    /**
     * 獲取特效資料物件
     * @return 特效資料物件
     */
    @NotNull
    public final T getParticleObject() {
        return particleObject;
    }

}
