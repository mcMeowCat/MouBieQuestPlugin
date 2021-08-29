package moubiequest.api.manager;

import moubiequest.api.particle.ParticleTimer;

/**
 * 代表玩家特效的管理器
 * @author MouBieCat
 */
public interface ParticleManager
        extends Manager<Integer, ParticleTimer> {

    /**
     * 清除所有特效物件
     */
    void clear();

}
