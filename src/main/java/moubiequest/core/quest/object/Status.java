package moubiequest.core.quest.object;

/**
 * 用於儲存任務相關的當前狀態
 * @author MouBieCat
 */
public final class Status {

    // 任務是否開放
    private boolean quest_enable;

    // 任務是否可見(介面、任務總攬被隱藏)
    private boolean quest_visible;

    /**
     * 建構子
     * @param enable 是否開啟任務
     * @param visible 是否可見任務
     */
    public Status(final boolean enable, final boolean visible) {
        this.quest_enable = enable;
        this.quest_visible = visible;
    }

    /**
     * 獲取任務是否開放
     * @return 是否開放
     */
    public boolean isEnable() {
        return quest_enable;
    }

    /**
     * 獲取任務是否隱藏
     * @return 是否隱藏
     */
    public boolean isVisible() {
        return quest_visible;
    }

    /**
     * 設定任務是否開啟
     * @param enable 狀態
     */
    public void setEnable(final boolean enable) {
        this.quest_enable = enable;
    }

    /**
     * 設定任務是否隱藏
     * @param visible 狀態
     */
    public void setVisible(final boolean visible) {
        this.quest_visible = visible;
    }

}
