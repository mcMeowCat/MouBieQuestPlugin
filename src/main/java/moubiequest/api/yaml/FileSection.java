package moubiequest.api.yaml;

import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * 有關於檔案的IO方法介面
 * @author MouBieCat
 */
public interface FileSection
        extends MemorySection {

    /**
     * 將檔案載入
     */
    void load();

    /**
     * 將特定檔案載入
     * @param file 檔案
     */
    void load(final @NotNull File file);

    /**
     * 保存至實體檔案
     */
    void save();

    /**
     * 保存至指定實體檔案
     * @param file 實體檔案
     */
    void save(final @NotNull File file);

}
