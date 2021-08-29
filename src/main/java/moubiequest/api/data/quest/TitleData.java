package moubiequest.api.data.quest;

import moubiequest.core.quest.objects.Title;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
     * 設定當前使用的稱號 (如果為空代表取消任何的稱號)
     * @param title 稱號
     */
    void setPlayerTitle(final @Nullable Title title);

}
