package moubiequest.core.quest.objects;

import moubiequest.api.particle.ParticleLocus;
import moubiequest.api.particle.ParticleType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 用於儲存任務稱號套用相關的物件
 * @author MouBieCat
 */
public final class Title {

    // 任務稱號名稱
    private final String quest_title;

    // 特效軌跡類型
    private final ParticleLocus locus;

    // 特效集合
    private final List<ParticleType> particleList;

    /**
     * 建構子
     * @param title 稱號
     * @param locus 軌跡類型
     * @param particleList 效果集合
     */
    public Title(final @NotNull String title, final @NotNull ParticleLocus locus, final @NotNull List<ParticleType> particleList) {
        this.quest_title = title;
        this.locus = locus;
        this.particleList = particleList;
    }

    /**
     * 獲取稱號名
     * @return 稱號
     */
    @NotNull
    public String getTitle() {
        return quest_title;
    }

    /**
     * 獲取特效軌跡類型
     * @return 軌跡類型
     */
    @NotNull
    public ParticleLocus getParticleLocus() {
        return this.locus;
    }

    /**
     * 獲取特效集合
     * @return 套校集合
     */
    @NotNull
    public List<ParticleType> getParticleList() {
        return this.particleList;
    }

}
