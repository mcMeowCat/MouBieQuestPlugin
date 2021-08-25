package moubiequest.api.data.quest;

/**
 * 有關玩家接收訊息管理介面
 * @author MouBieCat
 */
public interface MessageData {

    /**
     * 獲取玩家是否接收有關任務的訊息
     * @return 是否可看見
     */
    boolean isReceiveMessage();

    /**
     * 設定玩家是否接收有關任務的訊息
     * @param status 狀態
     */
    void setReceiveMessage(final boolean status);

}
