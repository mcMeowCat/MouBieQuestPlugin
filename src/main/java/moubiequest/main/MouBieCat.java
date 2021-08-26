package moubiequest.main;

import moubiequest.api.manager.PlayerDataManager;
import moubiequest.api.manager.QuestManager;
import moubiequest.api.quest.KillerQuest;
import moubiequest.core.manager.KillerQuestManager;
import moubiequest.core.manager.PlayerQuestDataManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MouBieCat extends JavaPlugin {

    // 插件標題
    public static final String PLUGIN_TITLE = "§7[§fMouBie§6Quest§7] §r";

    private PlayerDataManager playerDataManager;

    private QuestManager<KillerQuest> killerQuestManager;

    @Override
    public void onEnable() {
        this.playerDataManager = new PlayerQuestDataManager();
        this.killerQuestManager = new KillerQuestManager();
    }

    @Override
    public void onDisable() {
    }

    public static MouBieCat getInstance() {
        return JavaPlugin.getPlugin(MouBieCat.class);
    }

    public PlayerDataManager getPlayerDataManager() {
        return this.playerDataManager;
    }

    public QuestManager<KillerQuest> getKillerQuestManager() {
        return this.killerQuestManager;
    }

}
