package moubiequest.api.quest;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 該類用來枚舉任務類型
 * @author MouBieCat
 */
public enum QuestType {

    KILLER("KILLER", 1);

    // 類型名稱
    private final String name;

    // 識別碼
    private final int id;

    /**
     * 建構子
     * @param name 類型名稱
     * @param id 識別碼
     */
    QuestType(final @NotNull String name, final int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * 獲取類型名稱
     * @return 類型名稱
     */
    public final String getName() {
        return this.name;
    }

    /**
     * 獲取類型識別碼
     * @return 識別碼
     */
    public final int getId() {
        return this.id;
    }

    /**
     * 根據識別碼獲取一種任務類型
     * @param id 識別碼
     * @return 任務類型
     */
    @Nullable
    public static QuestType getById(final int id) {
        for (final QuestType type : QuestType.values())
            if (type.getId() == id) return type;
        return null;
    }

    /**
     * 根類型名稱獲取一種任務類型
     * @param name 名稱
     * @return 任務類型
     */
    @Nullable
    public static QuestType getByName(final @NotNull String name) {
        for (final QuestType type : QuestType.values())
            if (type.getName().equalsIgnoreCase(name)) return type;
        return null;
    }

    /**
     * 轉換成字串類型
     * @return 字串
     */
    @Override
    public String toString() {
        return "QuestType{" + "name='" + name + '\'' + ", id=" + id + '}';
    }

}
