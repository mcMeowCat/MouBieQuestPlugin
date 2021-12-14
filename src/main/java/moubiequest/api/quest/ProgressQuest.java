/**
 * LICENSE
 * MouBieQuest
 * -------------
 * Copyright (C) 2021 MouBieCat(MouBie_Yuki)
 * -------------
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 */

package moubiequest.api.quest;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個帶有進度的任務介面
 * @author MouBieCat
 */
public interface ProgressQuest
        extends Quest {

    /**
     * 或取進度任務需達成的次數
     * @return 所需次數
     */
    int getQuestProgress();

    /**
     * 對玩家添加進度一次
     * @param player 玩家
     * @return 是否成功添加
     */
    boolean addPlayerQuestProgress(final @NotNull Player player);

    /**
     * 對玩家進度清除歸零
     * @param player 玩家
     */
    void clearPlayerQuestProgress(final @NotNull Player player);

    /**
     * 獲取該玩家目前達到的進度水平
     * @param player 玩家
     * @return 進度次數
     */
    int getPlayerQuestProgress(final @NotNull Player player);

}
