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

package com.cat.moubiequest.moubie.yaml.quests;

import com.cat.moubiequest.api.yaml.quests.QuestLoader;
import com.cat.moubiequest.api.quests.Quest;
import com.cat.moubiequest.moubie.yaml.Loader;
import com.cat.moubiequest.api.quests.QuestType;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * 用於將YAML的任務格式轉換成記憶體類
 * @author MouBieCat
 */
public abstract class QuestLoaderAbstract<T extends Quest>
        extends Loader
        implements QuestLoader<T> {

    protected static final String QUEST = "Quests";

    protected static final String QUEST_DATA_MAIN_PATH = "Quests.";

    private static final String QUEST_DATA_TITLE_NAME_PATH = ".title.name";

    private static final String QUEST_DATA_MESSAGE_MESSAGE_PATH = ".message.message";
    private static final String QUEST_DATA_MESSAGE_SUCCESS_MESSAGE_PATH = ".message.success_message";

    private static final String QUEST_DATA_STATUS_ENABLE_PATH = ".status.enable";
    private static final String QUEST_DATA_STATUS_VISIBLE_PATH = ".status.visible";

    private static final String QUEST_DATA_ITEM_MATERIAL_PATH = ".item.material";

    private static final String QUEST_DATA_HONOR_POINT_PATH = ".honor_point";

    /**
     * 建構子
     * @param type 解析的任務類型
     */
    public QuestLoaderAbstract(final @NotNull QuestType type) {
        super("quests" + File.separatorChar, type.getName().toLowerCase() + ".yml", false);
    }

    /**
     * 解析任務的稱號標題
     * @param key 任務識別碼
     * @return 稱號標題
     */
    @NotNull
    public final String parsingQuestTitleName(final @NotNull String key) {
        return this.getString(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_TITLE_NAME_PATH, true);
    }

    /**
     * 解析任務的任務訊息
     * @param key 任務識別碼
     * @return 任務訊息
     */
    @NotNull
    public final String parsingQuestMessage(final @NotNull String key) {
        return this.getString(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_MESSAGE_MESSAGE_PATH, true);
    }

    /**
     * 解析任務的完成訊息
     * @param key 任務識別碼
     * @return 完成訊息
     */
    @NotNull
    public final String parsingQuestSuccessMessage(final @NotNull String key) {
        return this.getString(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_MESSAGE_SUCCESS_MESSAGE_PATH, true);
    }

    /**
     * 解析任務的開啟狀態
     * @param key 任務識別碼
     * @return 開關狀態
     */
    public final boolean parsingQuestStatusEnable(final @NotNull String key) {
        return this.getBoolean(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_STATUS_ENABLE_PATH);
    }

    /**
     * 解析任務的隱藏狀態
     * @param key 任務識別碼
     * @return 隱藏狀態
     */
    public final boolean parsingQuestStatusVisible(final @NotNull String key) {
        return this.getBoolean(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_STATUS_VISIBLE_PATH);
    }

    /**
     * 解析任務的介面物品材質
     * @param key 任務識別碼
     * @return 物品材質
     */
    @NotNull
    public final Material parsingQuestItemMaterial(final @NotNull String key) {
        return Material.valueOf(this.getString(
                QUEST_DATA_MAIN_PATH + key + QUEST_DATA_ITEM_MATERIAL_PATH,
                false
        ).toUpperCase());
    }

    /**
     * 解析任務的榮譽點數
     * @param key 任務識別碼
     * @return 榮譽點數
     */
    public final int parsingQuestHonorPoint(final @NotNull String key) {
        return this.getInt(QUEST_DATA_MAIN_PATH + key + QUEST_DATA_HONOR_POINT_PATH);
    }

}
