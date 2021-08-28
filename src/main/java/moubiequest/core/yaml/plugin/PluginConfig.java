package moubiequest.core.yaml.plugin;

import moubiequest.api.yaml.plugin.ConfigFile;

/**
 * 代表一個最基礎的插件嵌入式檔案載入器
 * @author MouBieCat
 */
public final class PluginConfig
        extends PluginLoader
        implements ConfigFile {

    private static final String CONFIG_SPAWN_PARTICLE_MAIN_RANGE = "SpawnParticleMinRange";

    private static final String CONFIG_SPAWN_PARTICLE_MAIN_DOT = "SpawnParticleMinDot";

    private static final String CONFIG_SPAWN_PARTICLE_TO_PLAYER_MAX_RANGE = "SpawnParticleToPlayerMaxRange";

    /**
     * 建構子
     */
    public PluginConfig() {
        super("", "Config.yml");
    }

    /**
     * 獲取生成粒子特校的最小距離
     * @return 距離
     */
    public double getSpawnParticleMinRange() {
        return this.getDouble(CONFIG_SPAWN_PARTICLE_MAIN_RANGE);
    }

    /**
     * 獲取生成特效距離準新的最小角度
     * @return 角度
     */
    public double getSpawnParticleMinDot() {
        return this.getDouble(CONFIG_SPAWN_PARTICLE_MAIN_DOT);
    }

    /**
     * 對最大距離多遠的玩家生成特效
     * @return 距離
     */
    public double getSpawnParticleToPlayerMaxRange() {
        return this.getDouble(CONFIG_SPAWN_PARTICLE_TO_PLAYER_MAX_RANGE);
    }

}
