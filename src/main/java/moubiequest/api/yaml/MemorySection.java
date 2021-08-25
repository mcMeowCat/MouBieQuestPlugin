package moubiequest.api.yaml;

import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * 載入檔案最底層的介面
 * @author MouBieCat
 */
public interface MemorySection {

    /**
     * 獲取檔案實例
     * @return 檔案
     */
    @NotNull File getFile();

    /**
     * 獲取YAML實例
     * @return YAML
     */
    @NotNull YamlConfiguration getConfiguration();

}
