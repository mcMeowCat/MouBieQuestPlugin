package moubiequest.core.format;

import moubiequest.api.quest.KillerQuest;
import moubiequest.api.yaml.plugin.FormatFile;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表擊殺任務的格式轉換類
 * @author MouBieCat
 */
public class KillerQuestFormat
        extends ProgressQuestFormat<KillerQuest> {

    /**
     * ## KILLER QUEST 佔位符 ## 擴展 (Progress Quest) (Base Quest)
     * # {QUEST_KILLER_ENTITY_TYPE} - 擊殺哪個種類的生物
     */
    private static final String QUEST_KILLER_ENTITY_TYPE = "{QUEST_KILLER_ENTITY_TYPE}";


    /**
     * 建構子
     * @param quest 任務
     * @param file 讀取格式的檔案
     */
    public KillerQuestFormat(final @NotNull KillerQuest quest, final @NotNull FormatFile file) {
        super(quest, file);
    }

    @NotNull
    public String replace(final @NotNull String msg, final @NotNull Player player) {
        String replaceStr = msg;

        // 轉換生物類型
        replaceStr = replaceStr.replace(
                QUEST_KILLER_ENTITY_TYPE,
                this.replacer.getKillEntity().toString()
        );

        return super.replace(replaceStr, player);
    }

}
