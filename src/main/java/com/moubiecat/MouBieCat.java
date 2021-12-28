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

package com.moubiecat;

import com.moubiecat.api.manager.QuestManager;
import com.moubiecat.api.quests.KillerQuest;
import com.moubiecat.api.yaml.plugin.FormatFile;
import com.moubiecat.api.yaml.plugin.InventoryFile;
import com.moubiecat.api.yaml.plugin.MessageFile;
import com.moubiecat.api.MouBieQuest;
import com.moubiecat.moubie.manager.quests.KillerQuestManager;
import com.moubiecat.moubie.yaml.plugin.PluginFormat;
import com.moubiecat.moubie.yaml.plugin.PluginInventory;
import com.moubiecat.moubie.yaml.plugin.PluginMessage;
import com.moubiecat.listener.InventoryListener;
import com.moubiecat.listener.KillerQuestListener;
import com.moubiecat.listener.PlayerDataListener;
import com.moubiecat.listener.QuestListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表該插件的主類
 * @author MouBieCat
 */
public final class MouBieCat
        extends JavaPlugin {

    // 插件標題
    public static final String PLUGIN_TITLE = "§7[§fMouBie§6Quest§7] §r";

    // API
    private static MouBieQuest MOU_BIE_QUEST_API;

    // 代表格式檔案
    private FormatFile formatFile;

    // 代表介面檔案
    private InventoryFile inventoryFile;

    // 代表訊息檔案
    private MessageFile messageFile;

    // 擊殺任務經理
    private QuestManager<KillerQuest> killerQuestManager;

    /**
     * 當插件啟動時調用
     */
    @Override
    public void onEnable() {
        // API hook
        MouBieCat.MOU_BIE_QUEST_API = new MouBieQuest();

        // 加載檔案
        this.formatFile = new PluginFormat();
        this.inventoryFile = new PluginInventory();
        this.messageFile = new PluginMessage();

        // 建立擊殺任務經理
        this.killerQuestManager = new KillerQuestManager();

        // 註冊事件
        Bukkit.getPluginManager().registerEvents(new PlayerDataListener(), this);
        Bukkit.getPluginManager().registerEvents(new KillerQuestListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
        Bukkit.getPluginManager().registerEvents(new QuestListener(), this);
    }

    /**
     * 插件關閉時調用
     */
    @Override
    public void onDisable() {
    }

    /**
     * 獲取當前插件實例
     * @return 插件本身
     */
    public static MouBieCat getInstance() {
        return JavaPlugin.getPlugin(MouBieCat.class);
    }

    /**
     * 獲取插件定義的API
     * @return API
     */
    public static MouBieQuest getAPI() {
        return MouBieCat.MOU_BIE_QUEST_API;
    }

    /**
     * 獲取格式檔案
     * @return 檔案
     */
    @NotNull
    public FormatFile getFormatFile() {
        return this.formatFile;
    }

    /**
     * 獲取介面檔案
     * @return 檔案
     */
    @NotNull
    public InventoryFile getInventoryFile() {
        return this.inventoryFile;
    }

    /**
     * 獲取訊息檔案
     * @return 檔案
     */
    @NotNull
    public MessageFile getMessageFile() {
        return this.messageFile;
    }

    /**
     * 獲取擊殺任務經理
     * @return 擊殺任務
     */
    @NotNull
    public QuestManager<KillerQuest> getKillerQuestManager() {
        return this.killerQuestManager;
    }

}
