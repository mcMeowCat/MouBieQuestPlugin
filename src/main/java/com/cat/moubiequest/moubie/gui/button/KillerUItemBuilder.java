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

package com.cat.moubiequest.moubie.gui.button;

import com.cat.moubiequest.api.format.QuestFormat;
import com.cat.moubiequest.api.quests.KillerQuest;
import com.cat.moubiequest.api.yaml.plugin.FormatFile;
import com.cat.moubiequest.moubie.format.KillerQuestFormat;
import com.cat.moubiequest.MouBieCat;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 代表一個擊殺任務的介面按鈕
 * @author MouBieCat
 */
public class KillerUItemBuilder
        extends QuestUItemBuilder<KillerQuest> {

    /**
     * 建構子
     * @param quest 代表任務
     * @param slot 介面位置
     */
    public KillerUItemBuilder(final @NotNull KillerQuest quest, final int slot) {
        super(quest, slot);
    }

    /**
     * 將物品建置出來
     *
     * @param player 玩家
     * @return 物品
     */
    @NotNull
    public ItemStack build(final @NotNull Player player) {
        final FormatFile formatFile = MouBieCat.getInstance().getFormatFile();

        // 獲取格式
        final String formatHead = formatFile.getFormatHead(this.quest);
        final List<String> formatBody = formatFile.getFormatBody(this.quest);

        // 轉換佔位符格式
        final QuestFormat<KillerQuest> killerFormat = new KillerQuestFormat(this.quest, formatFile);

        // 轉換開始
        this.displayName(killerFormat.replace(formatHead, player));
        this.lore(killerFormat.replaceList(formatBody, player));

        return super.build();
    }

}
