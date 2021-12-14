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

package moubiequest.main;

import moubiequest.api.manager.NMSManager;
import moubiequest.api.manager.PlayerDataManager;
import moubiequest.api.manager.QuestManager;
import moubiequest.api.quest.KillerQuest;
import moubiequest.api.yaml.plugin.FormatFile;
import moubiequest.api.yaml.plugin.InventoryFile;
import moubiequest.core.manager.nms.HandlerManager;
import moubiequest.core.manager.quest.KillerQuestManager;
import moubiequest.core.manager.data.PlayerQuestDataManager;
import moubiequest.core.yaml.plugin.PluginFormat;
import moubiequest.core.yaml.plugin.PluginInventory;
import moubiequest.listener.InventoryListener;
import moubiequest.listener.KillerQuestListener;
import moubiequest.listener.PlayerDataListener;
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

    // 代表格式檔案
    private FormatFile formatFile;

    // 代表介面檔案
    private InventoryFile inventoryFile;

    // 代表擊殺任務經理
    private QuestManager<KillerQuest> killerQuestManager;

    // 代表玩家紀錄經理
    private PlayerDataManager playerDataManager;

    // 代表 nms 經理
    private NMSManager nmsManager;

    /**
     * 當插件啟動
     */
    @Override
    public void onEnable() {
        // 加載檔案
        this.formatFile = new PluginFormat();
        this.inventoryFile = new PluginInventory();
        this.killerQuestManager = new KillerQuestManager();
        this.nmsManager = new HandlerManager();

        this.playerDataManager = new PlayerQuestDataManager();

        // 註冊事件
        Bukkit.getPluginManager().registerEvents(new PlayerDataListener(), this);
        Bukkit.getPluginManager().registerEvents(new KillerQuestListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
    }

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
     * 獲取玩家紀錄經理
     * @return 玩家紀錄經理
     */
    @NotNull
    public PlayerDataManager getPlayerDataManager() {
        return this.playerDataManager;
    }

    /**
     * 獲取擊殺任務經理
     * @return 擊殺任務經理
     */
    @NotNull
    public QuestManager<KillerQuest> getKillerQuestManager() {
        return this.killerQuestManager;
    }

    /**
     * 獲取 nms 經理
     * @return nms
     */
    @NotNull
    public NMSManager getNmsManager() { return this.nmsManager; }

}
