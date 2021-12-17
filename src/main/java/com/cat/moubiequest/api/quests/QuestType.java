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

package com.cat.moubiequest.api.quests;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 該類用來枚舉任務類型
 * @author MouBieCat
 */
public enum QuestType {

    KILLER("KILLER", 1);

    // 類型名稱
    private final String name;

    // 識別碼
    private final int id;

    /**
     * 建構子
     * @param name 類型名稱
     * @param id 識別碼
     */
    QuestType(final @NotNull String name, final int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * 獲取類型名稱
     * @return 類型名稱
     */
    public final String getName() {
        return this.name;
    }

    /**
     * 獲取類型識別碼
     * @return 識別碼
     */
    public final int getId() {
        return this.id;
    }

    /**
     * 根據識別碼獲取一種任務類型
     * @param id 識別碼
     * @return 任務類型
     */
    @Nullable
    public static QuestType getById(final int id) {
        for (final QuestType type : QuestType.values())
            if (type.getId() == id) return type;
        return null;
    }

    /**
     * 根類型名稱獲取一種任務類型
     * @param name 名稱
     * @return 任務類型
     */
    @Nullable
    public static QuestType getByName(final @NotNull String name) {
        for (final QuestType type : QuestType.values())
            if (type.getName().equalsIgnoreCase(name)) return type;
        return null;
    }

    /**
     * 轉換成字串類型
     * @return 字串
     */
    @Override
    public String toString() {
        return "QuestType{" + "name='" + name + '\'' + ", id=" + id + '}';
    }

}
