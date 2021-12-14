package moubiequest.api.itemstack.gui.button;

import moubiequest.api.quest.Quest;
import moubiequest.api.quest.QuestType;
import moubiequest.core.itemstack.gui.button.QuestUItemBuilder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一個任務介面按鈕
 * @param <T> 繼承 Quest
 * @author MouBieCat
 */
public interface QuestUItem<T extends Quest>
        extends PlayerUItem {

    /**
     * 獲取按鈕代表的任務
     * @return 任務
     */
    @NotNull T getQuest();

    /**
     * 解析物品上的任務類型
     * @param itemStack 物品
     * @return 類型
     */
    static @Nullable QuestType getItemStackQuestType(final @NotNull ItemStack itemStack) {
        return QuestUItemBuilder.getItemStackQuestType(itemStack);
    }

    /**
     * 解析物品上的任務識別名稱
     * @param itemStack 物品
     * @return 識別名稱
     */
    static @NotNull String getItemStackQuestKey(final @NotNull ItemStack itemStack) {
        return QuestUItemBuilder.getItemStackQuestKey(itemStack);
    }

}
