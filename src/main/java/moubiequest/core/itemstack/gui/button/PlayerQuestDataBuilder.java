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

package moubiequest.core.itemstack.gui.button;

import moubiequest.api.format.PlayerDataFormat;
import moubiequest.api.itemstack.gui.button.PlayerDataUItem;
import moubiequest.api.itemstack.gui.button.UItemBuilder;
import moubiequest.api.yaml.plugin.FormatFile;
import moubiequest.core.format.PlayerQuestDataFormat;
import moubiequest.main.MouBieCat;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 代表一個玩家資料介面類
 * @author MouBieCat
 */
public final class PlayerQuestDataBuilder
        extends UItemStackBuilder
        implements UItemBuilder, PlayerDataUItem {

    /**
     * 建構子
     * @param slot     介面位置
     */
    public PlayerQuestDataBuilder(final int slot) {
        super(Material.PLAYER_HEAD, slot);
    }

    /**
     * 將物品建置出來
     * @return 物品
     */
    @NotNull
    public ItemStack build(final @NotNull Player player) {
        final FormatFile formatFile = MouBieCat.getInstance().getFormatFile();

        // 獲取格式
        final String dataFormatHead = formatFile.getPlayerDataFormatHead();
        final List<String> dataFormatBody = formatFile.getPlayerDataFormatBody();

        // 轉換佔位符格式
        final PlayerDataFormat dataFormat = new PlayerQuestDataFormat(player, formatFile);

        // 轉換開始
        this.displayName(dataFormat.replace(dataFormatHead));
        this.lore(dataFormat.replaceList(dataFormatBody));

        // 設定頭顱
        this.skullMeta(player);

        return super.build();
    }

}
