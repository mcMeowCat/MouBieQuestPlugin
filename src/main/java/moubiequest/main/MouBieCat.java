package moubiequest.main;

import moubiequest.api.manager.NMSManager;
import moubiequest.api.manager.PlayerDataManager;
import moubiequest.api.manager.QuestManager;
import moubiequest.api.quest.KillerQuest;
import moubiequest.core.manager.HandlerManager;
import moubiequest.core.manager.KillerQuestManager;
import moubiequest.core.manager.PlayerQuestDataManager;
import moubiequest.listener.KillerQuestListener;
import moubiequest.listener.PlayerDataListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class MouBieCat extends JavaPlugin {

    // 插件標題
    public static final String PLUGIN_TITLE = "§7[§fMouBie§6Quest§7] §r";

    private PlayerDataManager playerDataManager;

    private QuestManager<KillerQuest> killerQuestManager;

    private NMSManager nmsManager;

    @Override
    public void onEnable() {
        this.playerDataManager = new PlayerQuestDataManager();
        this.killerQuestManager = new KillerQuestManager();
        this.nmsManager = new HandlerManager();

        Bukkit.getPluginManager().registerEvents(new PlayerDataListener(), this);
        Bukkit.getPluginManager().registerEvents(new KillerQuestListener(), this);
    }

    @Override
    public void onDisable() {
    }

    public static MouBieCat getInstance() {
        return JavaPlugin.getPlugin(MouBieCat.class);
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
