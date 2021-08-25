package moubiequest.core.yaml;

import moubiequest.api.yaml.PluginFile;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個最基礎的插件嵌入式檔案載入器
 * @author MouBieCat
 */
public abstract class PluginLoader
        extends Loader
        implements PluginFile {

    /**
     * 建構子
     * @param path      檔案路徑
     * @param name      檔案
     */
    public PluginLoader(final @NotNull String path, final @NotNull String name) {
        super(path, name, false);
    }

}
