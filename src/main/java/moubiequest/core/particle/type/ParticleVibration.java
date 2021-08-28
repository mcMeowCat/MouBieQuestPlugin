package moubiequest.core.particle.type;

import org.bukkit.Particle;
import org.bukkit.Vibration;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個 Vibration
 * @author MouBieCat
 */
public final class ParticleVibration
        extends ParticleTypeAbstract<Vibration> {

    /**
     * 建構子
     * @param particle       特效類型
     * @param particleObject 特效資料物件
     */
    public ParticleVibration(final @NotNull Particle particle, final @NotNull Vibration particleObject) {
        super(particle, particleObject);
    }

}
