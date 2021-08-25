package moubiequest.yaml;

import moubiequest.api.yaml.FileLoader;
import org.jetbrains.annotations.NotNull;

/**
 * 一個最基礎功能的檔案加載器 可被其他類繼承功能
 * @author MouBieCat
 */
public class Loader
        extends YamlModuleAbstract
        implements FileLoader {

    /**
     * 建構尺
     *
     * @param path      檔案路徑
     * @param name      檔案
     * @param isNewFile 是否新創建
     */
    public Loader(final @NotNull String path, final @NotNull String name, final boolean isNewFile) {
        super(path, name, isNewFile);
    }

    /**
     * 可用於重載
     */
    public void loadFile() {
        this.load();
    }

    /**
     * 可用於保存
     */
    public void saveFile() {
        this.save();
    }

}
