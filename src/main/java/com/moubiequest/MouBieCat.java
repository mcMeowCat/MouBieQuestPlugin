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

package com.moubiequest;

import com.moubieapi.api.plugin.MouBiePlugin;
import com.moubiequest.api.manager.PlayerDataManager;
import com.moubiequest.api.manager.QuestManager;
import com.moubiequest.api.quests.KillerQuest;
import com.moubiequest.api.yaml.plugin.FormatLoader;
import com.moubiequest.api.yaml.plugin.InventoryLoader;
import com.moubiequest.api.yaml.plugin.MessageLoader;
import com.moubiequest.listener.KillerQuestListener;
import com.moubiequest.listener.PlayerDataListener;
import com.moubiequest.listener.QuestListener;
import com.moubiequest.moubiequest.manager.KillerQuestManager;
import com.moubiequest.moubiequest.manager.PlayerQuestDataManager;
import com.moubiequest.moubiequest.yaml.plugin.PluginFormatLoader;
import com.moubiequest.moubiequest.yaml.plugin.PluginInventoryLoader;
import com.moubiequest.moubiequest.yaml.plugin.PluginMessageLoader;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表該插件的主要類別
 * @author MouBieCat
 */
public final class MouBieCat
        extends MouBiePlugin {
    // 插件標題
    public static final String PLUGIN_TITLE = "§7[§fMouBie§6Quest§7] §r";

    // 代表格式檔案
    private FormatLoader formatFile;

    // 代表介面檔案
    private InventoryLoader inventoryFile;

    // 代表訊息檔案
    private MessageLoader messageFile;

    // 代表玩家紀錄經理
    private PlayerDataManager playerDataManager;

    // 擊殺任務經理
    private QuestManager<KillerQuest> killerQuestManager;

    /**
     * 用於加載插件配置文件
     */
    @Override
    protected void loadFiles() {
        // 加載檔案
        this.formatFile = new PluginFormatLoader();
        this.inventoryFile = new PluginInventoryLoader();
        this.messageFile = new PluginMessageLoader();

        // 建立擊殺任務經理
        this.killerQuestManager = new KillerQuestManager();

        // 加載玩家配置文件
        this.playerDataManager = new PlayerQuestDataManager();
    }

    /**
     * 用於註冊插件事件
     */
    @Override
    protected void loadListener() {
        // 註冊事件
        Bukkit.getPluginManager().registerEvents(new PlayerDataListener(), this);
        Bukkit.getPluginManager().registerEvents(new KillerQuestListener(), this);
        Bukkit.getPluginManager().registerEvents(new QuestListener(), this);
    }

    /**
     * 獲取當前插件實例
     * @return 插件本身
     */
    public static MouBieCat getInstance() {
        return JavaPlugin.getPlugin(MouBieCat.class);
    }

    /**
     * 獲取格式檔案
     * @return 檔案
     */
    @NotNull
    public FormatLoader getFormatFile() {
        return this.formatFile;
    }

    /**
     * 獲取介面檔案
     * @return 檔案
     */
    @NotNull
    public InventoryLoader getInventoryFile() {
        return this.inventoryFile;
    }

    /**
     * 獲取訊息檔案
     * @return 檔案
     */
    @NotNull
    public MessageLoader getMessageFile() {
        return this.messageFile;
    }

    /**
     * 獲取玩家紀錄經理
     * @return 玩家紀錄
     */
    @NotNull
    public PlayerDataManager getPlayerDataManager() {
        return this.playerDataManager;
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
