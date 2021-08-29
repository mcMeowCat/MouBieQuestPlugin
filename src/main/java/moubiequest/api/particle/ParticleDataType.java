package moubiequest.api.particle;

import org.jetbrains.annotations.NotNull;

/**
 * 代表一個帶任何資料的粒子特校
 * @param <T> 任何類型
 * @author MouBieCat
 */
public interface ParticleDataType<T>
        extends ParticleType {

    /**
     * 獲取特效資料
     * @return 資料
     */
    @NotNull T getParticleObject();

}
