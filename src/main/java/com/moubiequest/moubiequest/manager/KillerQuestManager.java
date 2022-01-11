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

package com.moubiequest.moubiequest.manager;

import com.moubiequest.MouBieCat;
import com.moubiequest.api.quests.KillerQuest;
import com.moubiequest.moubiequest.yaml.quest.KillerQuestLoader;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 代表管理擊殺任務的管理器
 * @author MouBieCat
 */
public final class KillerQuestManager
        extends QuestManagerAbstract<KillerQuest> {

    /**
     * 建構子
     */
    public KillerQuestManager() {
        super(true);
    }

    /**
     * 用於將檔案格式轉換成記憶體的方法
     * @param showInfo 顯示任務加載資訊
     */
    @Override
    public void parsingQuests(final boolean showInfo) {
        final File pathFileObj = new File(MouBieCat.getInstance().getDataFolder(), "KillerQuests");
        final File[] files = pathFileObj.listFiles();

        if (files != null) {
            final List<String> filesNames = Arrays.stream(files).map(File::getName).toList();
            for (final String str : filesNames)
                for (final KillerQuest quest : new KillerQuestLoader(str).parsing())
                    this.add(quest.getQuestKey(), quest);
        }

        if (showInfo)
            MouBieCat.getInstance().getDebugger().info("§2成功解析並加載了 §6" + this.getValues().size() + " §2個§c擊殺§2類型任務！");
    }

}
