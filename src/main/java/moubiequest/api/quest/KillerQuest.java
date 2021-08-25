package moubiequest.api.quest;

import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;

public interface KillerQuest
        extends ProgressQuest {

    /**
     * 獲取任務所需擊殺的生物類型
     * @return 生物類型
     */
    @NotNull EntityType getKillEntity();

    /**
     * 檢查該生物類型是否符合
     * @param type 生物類型
     * @return 是否符合
     */
    boolean checkEntityType(final @NotNull EntityType type);

}
