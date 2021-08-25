package moubiequest.core.data;

import moubiequest.api.data.DataFile;
import moubiequest.core.yaml.Loader;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個最基礎的紀錄檔案載入器
 * @author MouBieCat
 */
public abstract class DataLoaderAbstract
        extends Loader
        implements DataFile {

    /**
     * 建構子
     * @param path      檔案路徑
     * @param name      檔案
     */
    public DataLoaderAbstract(final @NotNull String path, final @NotNull String name) {
        super(path, name, true);
        this.initData();
    }

    /**
     * 初始化
     */
    public void initData() {
        this.save();
    }

}
