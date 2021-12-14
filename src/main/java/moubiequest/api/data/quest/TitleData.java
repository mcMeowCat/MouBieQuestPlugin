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
     * @return 稱號實例
     */
    @Nullable Title getPlayerTitle();

    /**
     * 設定當前使用的稱號
     * @param title 稱號實例
     */
    void setPlayerTitle(final @NotNull Title title);

}
