package moubiequest.api.data.quest;

import moubiequest.core.quest.objects.Title;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 有關玩家當前套用的稱號管理介面
 * @author MouBieCat
 */
public interface TitleData {

    /**
     * 獲取當前使用的稱號
     * @return 稱號標題
     */
    @NotNull String getPlayerTitleName();

    /**
     * 獲取當前使用的特效集合
     * @return 特效集合
     */
    @NotNull List<String> getPlayerTitleParticle();

    /**
     * 設定當前使用的稱號 (如果為空代表取消任何的稱號)
     * @param title 稱號
     */
    void setPlayerTitle(final @Nullable Title title);

}
