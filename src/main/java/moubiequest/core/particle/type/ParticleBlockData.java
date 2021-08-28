package moubiequest.core.particle.type;

import org.bukkit.Particle;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個 BlockData
 * @author MouBieCat
 */
public final class ParticleBlockData
        extends ParticleTypeAbstract<BlockData> {

    /**
     * 建構子
     * @param particle       特效類型
     * @param particleObject 特效資料物件
     */
    public ParticleBlockData(final @NotNull Particle particle, final @NotNull BlockData particleObject) {
        super(particle, particleObject);
    }

}
