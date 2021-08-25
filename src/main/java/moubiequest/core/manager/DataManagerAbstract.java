package moubiequest.core.manager;

import moubiequest.api.data.DataFile;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個資料管理器
 * @param <K> 任何
 * @param <V> 繼承 DataFile
 * @author MouBieCat
 */
public abstract class DataManagerAbstract<K, V extends DataFile>
        extends ManagerAbstract<K, V> {

    /**
     * 添加資料到管理器中
     * @param key   k
     * @param value v
     */
    @Override
    public void add(final @NotNull K key, final @NotNull V value) {
        if (this.hasKey(key))
            this.remove(key);

        super.add(key, value);
    }

    /**
     * 從管理器中刪除資料
     * @param key k
     */
    @Override
    public void remove(final @NotNull K key) {
        final V v = this.get(key);
        if (v != null)
            v.saveFile();

        super.remove(key);
    }

}
