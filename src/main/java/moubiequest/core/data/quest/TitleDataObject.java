package moubiequest.core.data.quest;

import moubiequest.api.manager.ParticleManager;
import moubiequest.api.particle.ParticleTimer;
import moubiequest.core.manager.data.PlayerParticleManager;
import moubiequest.core.quest.objects.Title;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * 有關玩家特效的紀錄資料
 * @author MouBieCat
 *
 */
public final class TitleDataObject {

    // 玩家(擁有者)
    private final Player player;

    // 稱號標題
    private String title = "";

    // 特效
    private List<String> particle = new ArrayList<>();

    // 特效線程管理員
    private final ParticleManager particleManager = new PlayerParticleManager();

    /**
     * 建構子
     */
    public TitleDataObject(final @NotNull Player player) {
        this.player = player;
    }

    /**
     * 獲取稱號標題
     * @return 標題
     */
    @NotNull
    public String getTitle() {
        return title;
    }

    /**
     * 獲取特效集合
     * @return 特效集合
     */
    @NotNull
    public List<String> getParticle() {
        return particle;
    }

    /**
     * 使用一個任務稱號
     * @param title 稱號
     */
    public void usingQuestTitle(final @Nullable Title title) {
        // 停止所有之前套用任務稱號的粒子效果線程
        for (final ParticleTimer timer : this.particleManager.getValues())
            timer.stop();

        // 如果不為空，則設置稱號
        if (title != null) {
            this.title = title.getTitle();
            this.particle = title.getParticleList();

        // 否則，取消選定的任何稱號
        } else {
            this.title = "";
            this.particle.clear();
        }

        player.setPlayerListName("§c" + this.title + "§f" + this.player.getName());
    }

}
