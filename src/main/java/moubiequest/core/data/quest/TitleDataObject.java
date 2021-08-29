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

    /**
     * 代表一個紀載效果的物件
     * @author MouBieCat
     */
    public static class ParticleObject {
        // 稱號標題
        public String title = "";

        // 特效
        public List<String> particle = new ArrayList<>();

        // 特效線程管理員
        public final ParticleManager particleManager = new PlayerParticleManager();
    }

    // 玩家(擁有者)
    private final Player player;

    // 特效物件
    private final ParticleObject particleObject = new ParticleObject();

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
        return this.particleObject.title;
    }

    /**
     * 使用一個任務稱號
     * @param title 稱號
     */
    public void usingQuestTitle(final @Nullable Title title) {
        if (title == null)
            this.unQuestTitle();
        else {
            this.particleObject.title  = title.getTitle();
            this.particleObject.particle = title.getParticleList();
        }
    }

    /**
     * 卸載套用的稱號
     */
    public void unQuestTitle() {
        // 停止所有之前套用任務稱號的粒子效果線程
        this.particleObject.particleManager.clear();
        // 稱號為空字串
        this.particleObject.title = "";
        // 清除特效集合
        this.particleObject.particle.clear();
    }

}
