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

package com.moubiequest.moubiequest.yaml;

import com.moubiequest.api.quests.ProgressQuest;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * 用於將YAML的任務格式轉換成記憶體類
 * @param <T> 任務類型
 * @author MouBieCat
 */
public abstract class ProgressQuestLoaderAbstract<T extends ProgressQuest>
        extends QuestLoaderAbstract<T> {

    private static final String QUEST_DATA_PROGRESS_NUMBER_PATH = ".progress.number";

    /**
     * 建構子
     * @param path 加載路徑
     * @param fileName 要加載的檔案
     */
    public ProgressQuestLoaderAbstract(final @NotNull String path, final @NotNull String fileName) {
        super(path, fileName + ".yml");
    }

    /**
     * 解析任務的進度次數
     * @param key 任務識別碼
     * @return 榮譽點數
     */
    public final int parsingQuestProgressNumber(final @NotNull String key) {
        return this.getInt(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_PROGRESS_NUMBER_PATH);
    }


}
