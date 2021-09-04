package moubiequest.core.data.quest;

import moubiequest.api.manager.ParticleManager;
import moubiequest.api.particle.ParticleTimer;
import moubiequest.core.effect.particles.BottomToTopParticle;
import moubiequest.core.effect.particles.FoodSpinParticle;
import moubiequest.core.effect.particles.TopSpinParticle;
import moubiequest.core.effect.particles.TopToBottomParticle;
import moubiequest.core.manager.data.PlayerParticleManager;
import moubiequest.core.quest.objects.Title;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

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

    // 特效線程管理員
    private final ParticleManager particleManager = new PlayerParticleManager();

    /**
     * 建構子
     */
    public TitleDataObject(final @NotNull Player player) {
        this.player = player;
    }

    /**
     * 獲取稱號擁有者
     * @return 玩家(擁有者本身)
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * 獲取稱號標題
     * @return 標題
     */
    @NotNull
    public String getTitle() {
        return this.title;
    }

    /**
     * 使用一個任務稱號 (當NULL的話，取消任何的稱號套用)
     * @param title 稱號
     */
    public void usingQuestTitle(final @Nullable Title title) {
        if (title == null)
            this.unQuestTitle();
        else {
            this.unQuestTitle();

            this.title = title.getTitle();
            ParticleTimer timer = null;
            switch (title.getParticleLocus()) {
                case BOTTOM_TO_TOP:
                    timer = new BottomToTopParticle(this.player, new ArrayList<>(title.getParticleList()));
                    break;
                case TOP_SPIN:
                    timer = new TopSpinParticle(this.player, new ArrayList<>(title.getParticleList()));
                    break;
                case FOOD_SPIN:
                    timer = new FoodSpinParticle(this.player, new ArrayList<>(title.getParticleList()));
                    break;
                case TOP_TO_BOTTOM:
                    timer = new TopToBottomParticle(this.player, new ArrayList<>(title.getParticleList()));
                    break;
            }

            if (timer != null)
                this.particleManager.add(0, timer);
        }
    }

    /**
     * 卸載套用的稱號
     */
    private void unQuestTitle() {
        // 停止所有之前套用任務稱號的粒子效果線程
        this.particleManager.clear();
        // 稱號為空字串
        this.title = "";
    }

}
