package moubiequest.main;

import moubiequest.api.manager.PlayerDataManager;
import moubiequest.core.manager.PlayerQuestDataManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MouBieCat extends JavaPlugin {

    // 插件標題
    public static final String PLUGIN_TITLE = "§7[§fMouBie§6Quest§7] §r";

    private PlayerDataManager playerDataManager;

    @Override
    public void onEnable() {
        this.playerDataManager = new PlayerQuestDataManager();
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

}
