package moubiequest.api.yaml.plugin;

/**
 * 代表插件的嵌入式檔案 Config.yml
 * @author MouBieCat
 */
public interface ConfigFile
        extends PluginFile {

    /**
     * 獲取生成粒子特校的最小距離
     * @return 距離
     */
    double getSpawnParticleMinRange();

    /**
     * 獲取生成特效距離準新的最小角度
     * @return 角度
     */
    double getSpawnParticleMinDot();

    /**
     * 對最大距離多遠的玩家生成特效
     * @return 距離
     */
    double getSpawnParticleToPlayerMaxRange();

}
