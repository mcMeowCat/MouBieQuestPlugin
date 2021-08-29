package moubiequest.core.manager.data;

import moubiequest.api.particle.ParticleTimer;
import moubiequest.api.manager.ParticleManager;
import moubiequest.core.manager.ManagerAbstract;
import org.jetbrains.annotations.NotNull;

/**
 * 代表玩家特效的管理器
 * @author MouBieCat
 */
public final class PlayerParticleManager
        extends ManagerAbstract<Integer, ParticleTimer>
        implements ParticleManager {

    /**
     * 添加資料到管理器中
     * @param key   k
     * @param value v
     */
    @Override
    public void add(final @NotNull Integer key, final @NotNull ParticleTimer value) {
        if (!this.hasKey(key)) {
            value.start();
            super.add(key, value);
        }
    }

    /**
     * 從管理器中刪除資料
     * @param key k
     */
    @Override
    public void remove(final @NotNull Integer key) {
        final ParticleTimer particleTimer = this.get(key);
        if (particleTimer != null)
            particleTimer.stop();

        super.remove(key);
    }

    /**
     * 清除所有特效物件
     */
    public void clear() {
        for (final ParticleTimer timer : this.manager.values())
            timer.stop();

        this.manager.clear();
    }

}
