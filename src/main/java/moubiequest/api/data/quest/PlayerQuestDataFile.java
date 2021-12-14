package moubiequest.api.data.quest;

import moubiequest.api.data.PlayerDataFile;

/**
 * 有關玩家的任務資料載入器介面
 * @author MouBieCat
 */
public interface PlayerQuestDataFile
        extends PlayerDataFile,
        TitleData,
        HonorData,
        MessageData,
        ProgressQuestData {
}
