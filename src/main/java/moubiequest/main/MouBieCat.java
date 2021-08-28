package moubiequest.main;

import moubiequest.api.manager.NMSManager;
import moubiequest.api.manager.PlayerDataManager;
import moubiequest.api.manager.QuestManager;
import moubiequest.api.quest.KillerQuest;
import moubiequest.api.yaml.plugin.ConfigFile;
import moubiequest.api.yaml.plugin.FormatFile;
import moubiequest.api.yaml.plugin.InventoryFile;
import moubiequest.core.manager.nms.HandlerManager;
import moubiequest.core.manager.quest.KillerQuestManager;
import moubiequest.core.manager.data.PlayerQuestDataManager;
import moubiequest.core.yaml.plugin.PluginConfig;
import moubiequest.core.yaml.plugin.PluginFormat;
import moubiequest.core.yaml.plugin.PluginInventory;
import moubiequest.listener.InventoryListener;
import moubiequest.listener.KillerQuestListener;
import moubiequest.listener.PlayerDataListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class MouBieCat extends JavaPlugin {

    // 插件標題
    public static final String PLUGIN_TITLE = "§7[§fMouBie§6Quest§7] §r";

    private ConfigFile configFile;

    private FormatFile formatFile;

    private InventoryFile inventoryFile;

    private PlayerDataManager playerDataManager;

    private QuestManager<KillerQuest> killerQuestManager;

    private NMSManager nmsManager;

    @Override
    public void onEnable() {
        this.configFile = new PluginConfig();
        this.formatFile = new PluginFormat();
        this.inventoryFile = new PluginInventory();
        this.playerDataManager = new PlayerQuestDataManager();
        this.killerQuestManager = new KillerQuestManager();
        this.nmsManager = new HandlerManager();

        Bukkit.getPluginManager().registerEvents(new PlayerDataListener(), this);
        Bukkit.getPluginManager().registerEvents(new KillerQuestListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
    }

    @Override
    public void onDisable() {
    }

    @NotNull
    public static MouBieCat getInstance() {
        return JavaPlugin.getPlugin(MouBieCat.class);
    }

    @NotNull
    public ConfigFile getConfigFile() {
        return configFile;
    }

    @NotNull
    public FormatFile getFormatFile() {
        return this.formatFile;
    }

    @NotNull
    public InventoryFile getInventoryFile() {
        return this.inventoryFile;
    }

    @NotNull
    public PlayerDataManager getPlayerDataManager() {
        return this.playerDataManager;
    }

    @NotNull
    public QuestManager<KillerQuest> getKillerQuestManager() {
        return this.killerQuestManager;
    }

    @NotNull
    public NMSManager getNmsManager() { return this.nmsManager; }

}
