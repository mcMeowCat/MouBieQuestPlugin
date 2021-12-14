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

package moubiequest.api.yaml.plugin;

import moubiequest.api.quest.QuestType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個有關介面資料的檔案介面
 * @author MouBieCat
 */
public interface InventoryFile
        extends PluginFile {

    /**
     * 獲取一個任務類型的介面標題
     *
     * @param type 任務類型
     * @return 標題
     */
    @NotNull String getQuestInventoryTitle(final @NotNull QuestType type);

    /**
     * 獲取介面通用按鈕
     * @return 按鈕
     */
    @NotNull ItemStack getCommonButton(final @NotNull String name);

}
