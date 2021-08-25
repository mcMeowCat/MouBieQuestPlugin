package moubiequest.core.yaml;

import moubiequest.api.yaml.MemorySection;
import moubiequest.main.MouBieCat;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * 一個載入檔案最底層的工作類
 * @author MouBieCat
 */
public abstract class MemoryModuleAbstract
        implements MemorySection {

    // 檔案
    protected File file;

    // YAML
    protected YamlConfiguration configuration = new YamlConfiguration();

    /**
     * 建構子
     * @param path 路徑
     */
    public MemoryModuleAbstract(final @NotNull String path) {
        final File pathFileObj = new File(MouBieCat.getInstance().getDataFolder(), path);
        if (!this.createPath(pathFileObj))
            System.out.println(MouBieCat.PLUGIN_TITLE + "§c用於存放檔案路徑創建失敗，這是一個錯誤訊息。");
    }

    /**
     * 創建路徑
     * @param path 檔案路徑
     * @return 是否成功創建
     */
    protected final boolean createPath(final @NotNull File path) {
        if(!path.exists())
            return path.mkdirs();

        return true;
    }

    /**
     * 獲取檔案實例
     * @return 檔案
     */
    @NotNull
    public final File getFile() {
        return this.file;
    }

    /**
     * 獲取YAML實例
     * @return YAML
     */
    @NotNull
    public final YamlConfiguration getConfiguration() {
        return this.configuration;
    }

}
