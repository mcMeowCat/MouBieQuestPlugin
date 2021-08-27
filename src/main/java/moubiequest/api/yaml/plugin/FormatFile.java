package moubiequest.api.yaml.plugin;

import moubiequest.api.quest.Quest;
import moubiequest.api.quest.QuestType;
import moubiequest.core.quest.objects.Title;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 代表該插件的嵌入式文件介面(Format.yml)
 * @author MouBieCat
 */
public interface FormatFile
        extends PluginFile {

    /**
     * 獲取任務類型的字串
     * @param type 任務類型
     * @return 字串
     */
    @NotNull String getQuestTypeString(final @NotNull QuestType type);

    /**
     * 獲取任務開放狀態的字串
     * @param isEnable 是否啟用
     * @return 字串
     */
    @NotNull String getQuestEnableString(final boolean isEnable);

    /**
     * 獲取任務隱藏狀態的字串
     * @param isVisible 是否隱藏
     * @return 字串
     */
    @NotNull String getQuestVisibleString(final boolean isVisible);

    /**
     * 獲取玩家應該看到的任務訊息
     * @param quest 任務
     * @param player 玩家
     * @return 字串
     */
    @NotNull String getPlayerQuestMessageString(final @NotNull Quest quest, final @NotNull Player player);

    /**
     * 獲取任務進行中或是達成的訊息
     * @param isSuccess 是否完成
     * @return 字串
     */
    @NotNull String getQuestSuccessString(final boolean isSuccess);

    /**
     * 獲取任務引王狀態的字串
     * @param progressNumber 百分比
     * @return 字串
     */
    @NotNull String getQuestProgressImage(final int progressNumber);

    /**
     * 獲取任務的介面物品標題
     * @param quest 任務
     * @return 字串
     */
    @NotNull String getFormatHead(final @NotNull Quest quest);

    /**
     * 獲取任務的介面物品說明
     * @param quest 任務
     * @return 字串
     */
    @NotNull List<String> getFormatBody(final @NotNull Quest quest);

    /**
     * 獲取任務開放狀態的字串
     * @param isViewParticle 是否可見
     * @return 字串
     */
    @NotNull String getPlayerViewParticleString(final boolean isViewParticle);

    /**
     * 獲取任務隱藏狀態的字串
     * @param isReceiveMessage 是否接收
     * @return 字串
     */
    @NotNull String getPlayerReceiveMessageString(final boolean isReceiveMessage);

    /**
     * 獲取玩家當前使用的稱號
     * @param title 稱號
     * @return 字串
     */
    @NotNull String getPlayerUseTitle(final @Nullable Title title);

    /**
     * 獲取任務開放狀態的字串
     * @return 字串
     */
    @NotNull String getPlayerDataFormatHead();

    /**
     * 獲取任務的介面物品說明
     * @return 字串
     */
    @NotNull List<String> getPlayerDataFormatBody();

}
