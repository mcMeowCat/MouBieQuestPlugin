package moubiequest.core.format;

import moubiequest.api.data.quest.PlayerQuestDataFile;
import moubiequest.api.format.PlayerDataFormat;
import moubiequest.api.yaml.plugin.FormatFile;
import moubiequest.main.MouBieCat;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 有關轉換玩家紀錄的站位符介面
 * @author MouBoeCat
 */
public final class PlayerQuestDataFormat
        extends FormatAbstract<Player>
        implements PlayerDataFormat {

    private static final String PLAYER_DATA_NAME = "{PLAYER_NAME}";
    private static final String PLAYER_DATA_HONOR_POINT = "{PLAYER_HONOR_POINT}";
    private static final String PLAYER_DATA_RECEIVE_MESSAGE = "{PLAYER_RECEIVE_MESSAGE}";
    private static final String PLAYER_DATA_VIEW_PARTICLE = "{PLAYER_VIEW_PARTICLE}";

    /**
     * 建構子
     * @param obj  轉換物件
     * @param file 格式檔案
     */
    public PlayerQuestDataFormat(final @NotNull Player obj, final @NotNull FormatFile file) {
        super(obj, file);
    }

    /**
     * 將文字的站位符轉換
     * @param msg    訊息格式
     * @param player 傳患的玩家資訊
     */
    @NotNull
    public String replace(final @NotNull String msg, final @NotNull Player player) {
        return msg;
    }

    /**
     * 將文字的站位符轉換
     *
     * @param msg 訊息格式
     */
    @NotNull
    public String replace(final @NotNull String msg) {
        String replaceStr = msg;
        final PlayerQuestDataFile dataFile = MouBieCat.getInstance().getPlayerDataManager().get(this.replacer);

        // 轉換玩家名稱
        replaceStr = replaceStr.replace(
                PLAYER_DATA_NAME, this.replacer.getName()
        );

        // 轉換玩家榮譽點數
        replaceStr = replaceStr.replace(
                PLAYER_DATA_HONOR_POINT, this.replacer.getName()
        );

        // 轉換是否接收任務消息
        replaceStr = replaceStr.replace(
                PLAYER_DATA_RECEIVE_MESSAGE,
                this.formatFile.getPlayerReceiveMessageString(dataFile.isReceiveMessage())
        );

        // 轉換是否可見特效
        replaceStr = replaceStr.replace(
                PLAYER_DATA_VIEW_PARTICLE,
                this.formatFile.getPlayerReceiveMessageString(dataFile.isViewParticle())
        );

        return replaceStr;
    }

    /**
     * 將文字集合的站位符轉換
     *
     * @param list 訊息格式
     * @return 轉換後的文字集合
     */
    @NotNull
    public List<String> replaceList(final @NotNull List<String> list) {
        return this.replaceList(list, replacer);
    }

}
