package moubiequest.core.quest.objects;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 用於儲存任務稱號套用相關的物件
 * @author MouBieCat
 */
public final class Title {

    // 任務稱號名稱
    private final String quest_title;

    // 特效集合
    private final List<String> particleList;

    /**
     * 建構子
     * @param title 稱號
     */
    public Title(final @NotNull String title, final @NotNull List<String> particleList) {
        this.quest_title = title;
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
     * 獲取特效集合
     * @return 套校集合
     */
    @NotNull
    public List<String> getParticleList() {
        return particleList;
    }

}
