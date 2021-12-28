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

package com.moubiecat.api.gui;

import com.moubiecat.api.gui.ui.GUI;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個具有返回介面的介面
 * @param <T> 有關 GUI 的類
 * @author MouBieCat
 */
public interface BackInventory<T extends GUI>  {

    /**
     * 獲取返回介面
     * @return 返回介面
     */
    @NotNull T getBacker();

    /**
     * 返回上一層介面
     * @param player 玩家
     */
    void goBack(final @NotNull Player player);

}
