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

package com.moubiecat.moubie.manager;

import com.moubiecat.api.manager.QuestManager;
import com.moubiecat.api.quests.Quest;
import com.moubiecat.moubieapi.manager.ManagerAbstract;

/**
 * 代表一個單一類型任務的管理器
 * @param <T> 繼承 Quest
 * @author MouBieCat
 */
public abstract class QuestManagerAbstract<T extends Quest>
        extends ManagerAbstract<String, T>
        implements QuestManager<T> {

    /**
     * 建構子
     * @param showInfo 顯示加載資訊
     */
    public QuestManagerAbstract(final boolean showInfo) {
        this.parsingQuests(showInfo);
    }

    /**
     * 用於將檔案格式轉換成記憶體的方法
     * @param showInfo 顯示任務加載資訊
     */
    public abstract void parsingQuests(final boolean showInfo);

}
