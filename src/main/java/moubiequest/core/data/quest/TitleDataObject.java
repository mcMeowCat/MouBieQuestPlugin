package moubiequest.core.data.quest;

import moubiequest.api.manager.ParticleManager;
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
     * 獲取特效集合
     * @return 特效集合
     */
    @NotNull
    public List<String> getParticle() {
        return this.particle;
    }

    /**
     * 使用一個任務稱號
     * @param title 稱號
     */
    public void usingQuestTitle(final @Nullable Title title) {
//        // 如果為空，則卸載稱號
//        if (title == null) {
//            this.unQuestTitle();
//        } else {
//            this.title = title.getTitle();
//            this.particle = title.getParticleList();
//
//            // 解析粒子特效
//            final List<ParticleType> particleTypes = title.parsingQuestParticleType();
//            switch (title.getParticleLocus()) {
//                case TOP_SPIN:
//                    this.particleManager.add(0, new TopSpinParticle(this.player, particleTypes));
//                    break;
//                case TOP_TO_BOTTOM:
//                    this.particleManager.add(0, new TopToBottomParticle(this.player, particleTypes));
//                    break;
//                case FOOD_SPIN:
//                    this.particleManager.add(0, new FoodSpinParticle(this.player, particleTypes));
//                    break;
//                case BOTTOM_TO_TOP:
//                    this.particleManager.add(0, new BottomToTopParticle(this.player, particleTypes));
//                    break;
//            }
//        }
    }

    public void unQuestTitle() {
//        // 停止所有之前套用任務稱號的粒子效果線程
//        for (final ParticleTimer timer : this.particleManager.getValues())
//            timer.stop();
//
//        // 稱號為空字串
//        this.title = "";
//
//        // 清除特效集合
//        this.particle.clear();
    }

}
