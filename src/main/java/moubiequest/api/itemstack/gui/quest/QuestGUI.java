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

package moubiequest.api.itemstack.gui.quest;

import moubiequest.api.itemstack.gui.PageGUI;
import moubiequest.api.itemstack.gui.QuestView;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個基礎的任務介面
 * @author MouBieCat
 */
public interface QuestGUI
        extends PageGUI {

    /**
     * 獲取當前的顯示方式類型
     * @return 顯示方式
     */
    @NotNull QuestView getViewType();

    /**
     * 設定當前的顯示方式類型
     * @param viewType 顯示方式
     */
    void setViewType(final @NotNull QuestView viewType);

}
