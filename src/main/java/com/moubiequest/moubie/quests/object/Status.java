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

package com.moubiequest.moubie.quests.object;

/**
 * 用於儲存任務相關的當前狀態
 * @author MouBieCat
 */
public final class Status {

    // 任務是否開放
    private boolean quest_enable;

    // 任務是否可見(介面、任務總攬被隱藏)
    private boolean quest_visible;

    /**
     * 建構子
     * @param enable 是否開啟任務
     * @param visible 是否可見任務
     */
    public Status(final boolean enable, final boolean visible) {
        this.quest_enable = enable;
        this.quest_visible = visible;
    }

    /**
     * 獲取任務是否開放
     * @return 是否開放
     */
    public boolean isEnable() {
        return quest_enable;
    }

    /**
     * 獲取任務是否隱藏
     * @return 是否隱藏
     */
    public boolean isVisible() {
        return quest_visible;
    }

    /**
     * 設定任務是否開啟
     * @param enable 狀態
     */
    public void setEnable(final boolean enable) {
        this.quest_enable = enable;
    }

    /**
     * 設定任務是否隱藏
     * @param visible 狀態
     */
    public void setVisible(final boolean visible) {
        this.quest_visible = visible;
    }

}
