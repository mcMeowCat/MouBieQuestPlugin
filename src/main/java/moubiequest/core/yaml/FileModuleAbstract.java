package moubiequest.core.yaml;

import moubiequest.api.yaml.FileSection;
import moubiequest.main.MouBieCat;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

/**
 * 載入黨案所需的IO處理類
 * @author MouBieCat
 */
public abstract class FileModuleAbstract
        extends MemoryModuleAbstract
        implements FileSection {

    /**
     * 建構子
     * @param path 檔案路徑
     * @param name 檔案
     * @param isNewFile 是否新創建
     */
    public FileModuleAbstract(final @NotNull String path, final @NotNull String name, final boolean isNewFile) {
        super(path);

        final File pathObj = new File(MouBieCat.getInstance().getDataFolder(), path);
        final File fileObj = new File(pathObj, name);

        if (!fileObj.exists()) {
            if (isNewFile) {
                if (!this.createFile(fileObj))
                    System.out.println(MouBieCat.PLUGIN_TITLE + "§c創建一個新的檔案配置失敗，這是一個錯誤訊息。");
            }
            else
                MouBieCat.getInstance().saveResource(path + name, false);
        }

        this.file = fileObj;
    }

    /**
     * 將檔案載入
     */
    public final void load() {
        this.load(this.file);
    }

    /**
     * 將特定檔案載入
     * @param file 檔案
     */
    public final void load(final @NotNull File file) {
        this.file = file;
        this.configuration = YamlConfiguration.loadConfiguration(file);
    }

    /**
     * 保存至實體檔案
     */
    public final void save() {
        this.save(this.file);
    }

    /**
     * 保存至指定實體檔案
     * @param file 實體檔案
     */
    public final void save(final @NotNull File file) {
        try {
            this.file = file;
            this.configuration.save(file);
        } catch (final IOException e) {
            e.printStackTrace();
            System.out.println(MouBieCat.PLUGIN_TITLE + "§c嘗試將檔案保存至實體位置失敗，這是一個錯誤訊息。");
        }
    }

    /**
     * 創建檔案方法
     * @param file 檔案
     * @return 是否成功創建
     */
    protected final boolean createFile(final @NotNull File file) {
        if (!file.exists()) {
            try {
                return file.createNewFile();
            } catch (final IOException ignored) { return false; }
        }
        return true;
    }

}
