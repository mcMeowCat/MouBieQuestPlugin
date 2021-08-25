package moubiequest.api.yaml;

/**
 * 代表一個檔案載入介面
 * @author MouBieCat
 */
public interface FileLoader {

    /**
     * 可用於保存
     */
    void saveFile();

    /**
     * 可用於重載
     */
    void loadFile();

}
