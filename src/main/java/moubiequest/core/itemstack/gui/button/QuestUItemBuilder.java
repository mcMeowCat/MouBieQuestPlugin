package moubiequest.core.itemstack.gui.button;

import moubiequest.api.itemstack.gui.quest.QuestUItem;
import moubiequest.api.nms.NBTHandler;
import moubiequest.api.quest.Quest;
import moubiequest.api.quest.QuestType;
import moubiequest.main.MouBieCat;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一任務介面上的按鈕
 * @param <T> 繼承 Quest
 * @author MouBieCat
 */
public abstract class QuestUItemBuilder<T extends Quest>
        extends UItemStackBuilder
        implements QuestUItem<T> {

    // 任務介面物品主要TAG
    private static final String UI_ITEM_QUEST_MAIN_TAG = "UI_ITEM_QUEST_MAIN_TAG";

    // 任務介面物品任務類型TAG
    private static final String UI_ITEM_QUEST_QUEST_TYPE_TAG = "QUEST_TYPE";
    // 任務介面物品任務名稱TAG
    private static final String UI_ITEM_QUEST_QUEST_KEY_TAG = "QUEST_KEY";

    // 任務
    protected final T quest;

    /**
     * 建構子
     * @param quest 代表任務
     * @param slot 介面位置
     */
    public QuestUItemBuilder(final @NotNull T quest, final int slot) {
        super(quest.getQuestItemMaterial(), slot);
        this.quest = quest;
    }

    /**
     * 獲取按鈕代表的任務
     * @return 任務
     */
    @NotNull
    public final T getQuest() {
        return this.quest;
    }

    /**
     * 解析物品上的任務類型
     * @param itemStack 物品
     * @return 類型
     */
    @Nullable
    public static QuestType getItemStackQuestType(final @NotNull ItemStack itemStack) {
        final NBTHandler handler = MouBieCat.getInstance().getNmsManager().getNbtHandler();

        if (handler.hasTag(itemStack, UI_ITEM_QUEST_MAIN_TAG))
            return QuestType.valueOf(
                    handler.getString(itemStack, UI_ITEM_QUEST_MAIN_TAG, UI_ITEM_QUEST_QUEST_TYPE_TAG)
            );

        return null;
    }

    /**
     * 解析物品上的任務識別名稱
     * @param itemStack 物品
     * @return 識別名稱
     */
    @NotNull
    public static String getItemStackQuestKey(final @NotNull ItemStack itemStack) {
        final NBTHandler handler = MouBieCat.getInstance().getNmsManager().getNbtHandler();

        if (handler.hasTag(itemStack, UI_ITEM_QUEST_MAIN_TAG))
            return handler.getString(itemStack, UI_ITEM_QUEST_MAIN_TAG, UI_ITEM_QUEST_QUEST_KEY_TAG);

        return "";
    }

    /**
     * 將物品建置出來
     * @return 物品
     */
    @NotNull
    public final ItemStack build() {
        final NBTHandler handler = MouBieCat.getInstance().getNmsManager().getNbtHandler();

        // 配置 TAG 屬性
        handler.setMainTagName(UI_ITEM_QUEST_MAIN_TAG)
                .setString(UI_ITEM_QUEST_QUEST_TYPE_TAG, this.quest.getQuestType().getName())
                .setString(UI_ITEM_QUEST_QUEST_KEY_TAG, this.quest.getQuestKey());

        // 寫入到物品中
        this.itemStack = handler.build(this.itemStack);

        return super.build();
    }

}
