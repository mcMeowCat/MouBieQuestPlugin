package moubiequest.api.particle;

import org.bukkit.Particle;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個特效的資料介面
 * @author MouBieCat
 */
public interface ParticleType {

    /**
     * 獲取特效類型
     * @return 特效類型
     */
    @NotNull Particle getParticle();

}
