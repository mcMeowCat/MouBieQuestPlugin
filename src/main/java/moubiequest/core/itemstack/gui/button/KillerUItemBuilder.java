package moubiequest.core.itemstack.gui.button;

import moubiequest.api.format.QuestFormat;
import moubiequest.api.quest.KillerQuest;
import moubiequest.api.yaml.plugin.FormatFile;
import moubiequest.core.format.KillerQuestFormat;
import moubiequest.main.MouBieCat;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 代表一個擊殺任務的介面按鈕
 * @author MouBieCat
 */
public class KillerUItemBuilder
        extends QuestUItemBuilder<KillerQuest> {

    /**
     * 建構子
     * @param quest 代表任務
     */
    public KillerUItemBuilder(final @NotNull KillerQuest quest) {
        super(quest);
    }

    /**
     * 將物品建置出來
     *
     * @param player 玩家
     * @return 物品
     */
    @NotNull
    public ItemStack build(final @NotNull Player player) {
        final FormatFile formatFile = MouBieCat.getInstance().getFormatFile();

        // 獲取格式
        final String formatHead = formatFile.getFormatHead(this.quest);
        final List<String> formatBody = formatFile.getFormatBody(this.quest);

        // 轉換佔位符格式
        final QuestFormat<KillerQuest> killerFormat = new KillerQuestFormat(this.quest, formatFile);

        // 轉換開始
        this.displayName(killerFormat.replace(formatHead, player));
        this.lore(killerFormat.replaceList(formatBody, player));

        return super.build();
    }

}
