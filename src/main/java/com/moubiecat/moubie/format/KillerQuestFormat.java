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

package com.moubiecat.moubie.format;

import com.moubiecat.api.quests.KillerQuest;
import com.moubiecat.api.yaml.plugin.FormatFile;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表擊殺任務的格式轉換類
 * @author MouBieCat
 */
public class KillerQuestFormat
        extends ProgressQuestFormat<KillerQuest> {

    /**
     * ## KILLER QUEST 佔位符 ## 擴展 (Progress Quest) (Base Quest)
     * # {QUEST_KILLER_ENTITY_TYPE} - 擊殺哪個種類的生物
     */
    private static final String QUEST_KILLER_ENTITY_TYPE = "{QUEST_KILLER_ENTITY_TYPE}";


    /**
     * 建構子
     * @param quest 任務
     * @param file 讀取格式的檔案
     */
    public KillerQuestFormat(final @NotNull KillerQuest quest, final @NotNull FormatFile file) {
        super(quest, file);
    }

    @NotNull
    public String replace(final @NotNull String msg, final @NotNull Player player) {
        String replaceStr = msg;

        // 轉換生物類型
        replaceStr = replaceStr.replace(
                QUEST_KILLER_ENTITY_TYPE,
                this.replacer.getKillEntity().toString()
        );

        return super.replace(replaceStr, player);
    }

}
