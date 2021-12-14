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

package moubiequest.core.manager.quest;

import moubiequest.api.manager.QuestManager;
import moubiequest.api.quest.Quest;
import moubiequest.core.manager.ManagerAbstract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

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
     */
    public QuestManagerAbstract() {
        this.parsingQuests();
    }

    /**
     * 用於將檔案格式轉換成記憶體的方法
     */
    public abstract void parsingQuests();

    /**
     * 獲取所有的任務
     * @return 任務集合
     */
    @NotNull
    public final Collection<T> getQuests() {
        return this.manager.values();
    }

}
