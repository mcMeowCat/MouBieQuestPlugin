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

import com.cat.moubiequest.api.yaml.quests.KillerLoader;
import com.cat.moubiequest.api.quests.KillerQuest;
import com.cat.moubiequest.api.quests.QuestType;
import com.cat.moubiequest.moubie.quests.object.Message;
import com.cat.moubiequest.moubie.quests.object.QItem;
import com.cat.moubiequest.moubie.quests.object.Status;
import com.cat.moubiequest.moubie.quests.object.Title;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 用於將YAML的任務格式轉換成記憶體類
 * @author MouBieCat
 */
public class KillerQuestLoader
        extends ProgressQuestLoaderAbstract<KillerQuest>
        implements KillerLoader {

    private static final String QUEST_DATA_PROGRESS_NUMBER_PATH = ".killer.entity_type";

    /**
     * 建構子
     */
    public KillerQuestLoader() {
        super(QuestType.KILLER);
    }

    /**
     * 解析任務的擊殺生物類型
     * @param key 任務識別碼
     * @return 生物類型
     */
    public final EntityType parsingQuestKillEntityType(final @NotNull String key) {
        return EntityType.valueOf(this.getString(
                QUEST_DATA_MAIN_PATH + key + QUEST_DATA_PROGRESS_NUMBER_PATH,
                false
        ).toUpperCase());
    }

    /**
     * 解析檔案內容轉換成任務格式
     * @return 解析的任務集合
     */
    @NotNull
    public List<KillerQuest> parsing() {
        // 創建任務集合
        final List<KillerQuest> quests = new ArrayList<>();

        // 判斷該檔案是否有任務解析的主路徑
        final ConfigurationSection questSection = this.configuration.getConfigurationSection(QUEST);
        if (questSection == null)
            return quests;

        // 使用迴圈開始將任務格式解析
        for (final String key : questSection.getKeys(false)) {

            // 解析任務稱號
            final Title title =
                    new Title(this.parsingQuestTitleName(key));

            // 解析任務訊息
            final Message message =
                    new Message(this.parsingQuestSuccessMessage(key), this.parsingQuestMessage(key));

            // 解析任務狀態
            final Status status =
                    new Status(this.parsingQuestStatusEnable(key), this.parsingQuestStatusVisible(key));

            // 解析任務介面資訊
            final QItem qItem = new QItem(this.parsingQuestItemMaterial(key));

            // 創建任務
            final com.cat.moubiequest.moubie.quests.quest.KillerQuest quest = new com.cat.moubiequest.moubie.quests.quest.KillerQuest(
                    key, title, message, status, qItem, this.parsingQuestHonorPoint(key),
                    this.parsingQuestProgressNumber(key), this.parsingQuestKillEntityType(key)
            );

            // 添加
            quests.add(quest);
        }

        // 返回集合
        return quests;
    }

}
