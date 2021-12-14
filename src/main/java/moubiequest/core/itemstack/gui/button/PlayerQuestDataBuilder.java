package moubiequest.core.itemstack.gui.button;

import moubiequest.api.format.PlayerDataFormat;
import moubiequest.api.itemstack.gui.button.PlayerDataUItem;
import moubiequest.api.itemstack.gui.button.UItemBuilder;
import moubiequest.api.yaml.plugin.FormatFile;
import moubiequest.core.format.PlayerQuestDataFormat;
import moubiequest.main.MouBieCat;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 代表一個玩家資料介面類
 * @author MouBieCat
 */
public final class PlayerQuestDataBuilder
        extends UItemStackBuilder
        implements UItemBuilder, PlayerDataUItem {

    /**
     * 建構子
     * @param slot     介面位置
     */
    public PlayerQuestDataBuilder(final int slot) {
        super(Material.PLAYER_HEAD, slot);
    }

    /**
     * 將物品建置出來
     * @return 物品
     */
    @NotNull
    public ItemStack build(final @NotNull Player player) {
        final FormatFile formatFile = MouBieCat.getInstance().getFormatFile();

        // 獲取格式
        final String dataFormatHead = formatFile.getPlayerDataFormatHead();
        final List<String> dataFormatBody = formatFile.getPlayerDataFormatBody();

        // 轉換佔位符格式
        final PlayerDataFormat dataFormat = new PlayerQuestDataFormat(player, formatFile);

        // 轉換開始
        this.displayName(dataFormat.replace(dataFormatHead));
        this.lore(dataFormat.replaceList(dataFormatBody));

        // 設定頭顱
        this.skullMeta(player);

        return super.build();
    }

}
