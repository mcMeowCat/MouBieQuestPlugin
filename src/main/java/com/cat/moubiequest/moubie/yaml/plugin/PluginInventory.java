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

package com.cat.moubiequest.moubie.yaml.plugin;

import com.cat.moubiequest.api.quests.QuestType;
import com.cat.moubiequest.api.yaml.plugin.InventoryFile;
import com.cat.moubiequest.moubie.itemstack.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表該插件的嵌入式文件(Inventory.yml)
 * @author MouBieCat
 */
public final class PluginInventory
        extends PluginLoader
        implements InventoryFile {

    private static final String INVENTORY_QUEST_INVENTORY_MAIN_PATH = "QuestInventory.";

    private static final String INVENTORY_QUEST_COMMON_BUTTON_PATH = "common_button.";
    private static final String INVENTORY_QUEST_COMMON_BUTTON_MATERIAL_PATH = ".material";
    private static final String INVENTORY_QUEST_COMMON_DISPLAY_NAME_PATH = ".display_name";


    private static final String INVENTORY_QUEST_INVENTORY_TITLE_PATH = ".title";

    /**
     * 建構子
     */
    public PluginInventory() {
        super("", "Inventory.yml");
    }

    /**
     * 獲取一個任務類型的介面標題
     * @param type 任務類型
     * @return 標題
     */
    @NotNull
    public String getQuestInventoryTitle(final @NotNull QuestType type) {
        return this.getString(
                INVENTORY_QUEST_INVENTORY_MAIN_PATH + type.getName() + INVENTORY_QUEST_INVENTORY_TITLE_PATH,
                true
        );
    }

    /**
     * 獲取介面通用按鈕
     * @param name 按鈕名稱
     * @return 按鈕
     */
    @NotNull
    public ItemStack getCommonButton(final @NotNull String name) {
        // 解析材質
        final Material material = Material.valueOf(
                this.getString(
                        INVENTORY_QUEST_INVENTORY_MAIN_PATH + INVENTORY_QUEST_COMMON_BUTTON_PATH + name + INVENTORY_QUEST_COMMON_BUTTON_MATERIAL_PATH,
                        true
                ).toUpperCase()
        );

        // 解析按鈕名稱
        final String displayName = this.getString(
                INVENTORY_QUEST_INVENTORY_MAIN_PATH + INVENTORY_QUEST_COMMON_BUTTON_PATH + name + INVENTORY_QUEST_COMMON_DISPLAY_NAME_PATH,
                true
        );

        // 製作按鈕
        final ItemStackBuilder builder = new ItemStackBuilder(material);
        builder.displayName(displayName);

        return builder.build();
    }

}
