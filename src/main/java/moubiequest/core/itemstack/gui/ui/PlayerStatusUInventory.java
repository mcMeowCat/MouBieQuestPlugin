package moubiequest.core.itemstack.gui.ui;

import moubiequest.api.data.quest.PlayerQuestDataFile;
import moubiequest.api.itemstack.gui.button.UItem;
import moubiequest.api.itemstack.gui.button.UItemBuilder;
import moubiequest.api.itemstack.gui.quest.PlayerStatusGUI;
import moubiequest.api.yaml.plugin.InventoryFile;
import moubiequest.core.itemstack.gui.button.UItemStackBuilder;
import moubiequest.main.MouBieCat;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 有關玩家狀態設定的選單介面類
 * @author MouBieCat
 */
public final class PlayerStatusUInventory
        extends UInventoryAbstract
        implements PlayerStatusGUI {

    private static final int INVENTORY_PLAYER_STATUS_RECEIVE_MESSAGE_BUTTON = 11;
    private static final int INVENTORY_PLAYER_STATUS_VIEW_PARTICLE_BUTTON = 15;

    // 玩家
    private final Player player;

    // 開啟功能
    private final UItemBuilder enableButton;

    // 關閉功能
    private final UItemBuilder disableButton;

    // 可見粒子特效
    private final UItem viewParticleButton;

    // 接收任務消息
    private final UItem receiveMessageButton;

    /**
     * 建構子
     * @param player 玩家
     */
    public PlayerStatusUInventory(final @NotNull Player player) {
        super(MouBieCat.getInstance().getInventoryFile().getPlayerStatusInventoryTitle(player), InventorySize.FIVE);
        this.player = player;

        final InventoryFile inventoryFile = MouBieCat.getInstance().getInventoryFile();
        UItemStackBuilder builder;

        // 解析通用按鈕 (開啟功能)
        builder = new UItemStackBuilder(inventoryFile.getPlayerStatusInventoryCommonButton("enable_button"), 0);
        this.enableButton = builder;

        // 解析通用按鈕 (關閉功能)
        builder = new UItemStackBuilder(inventoryFile.getPlayerStatusInventoryCommonButton("disable_button"), 0);
        this.disableButton = builder;

        // 解析通用按鈕 (可見粒子特效)
        builder = new UItemStackBuilder(inventoryFile.getPlayerStatusInventoryCommonButton("view_particle_button"), INVENTORY_PLAYER_STATUS_VIEW_PARTICLE_BUTTON);
        this.viewParticleButton = builder;

        // 解析通用按鈕 (接收任務消息)
        builder = new UItemStackBuilder(inventoryFile.getPlayerStatusInventoryCommonButton("receive_message_button"), INVENTORY_PLAYER_STATUS_RECEIVE_MESSAGE_BUTTON);
        this.receiveMessageButton = builder;

    }

    /**
     * 初始化介面
     * @param player 玩家
     */
    @Override
    protected void initInventory(final @NotNull Player player) {
        this.clearInventory();

        final PlayerQuestDataFile dataFile = MouBieCat.getInstance().getPlayerDataManager().get(player);
        this.addUItem(this.viewParticleButton).addUItem(this.receiveMessageButton);

        // 判斷可見粒子狀態
        if (dataFile.isViewParticle()) {
            this.disableButton.setSlotId(29);
            this.addUItem(this.disableButton);
        } else {
            this.enableButton.setSlotId(20);
            this.addUItem(this.enableButton);
        }

        // 判斷接收消息狀態
        if (dataFile.isReceiveMessage()) {
            this.disableButton.setSlotId(33);
            this.addUItem(this.disableButton);
        } else {
            this.enableButton.setSlotId(24);
            this.addUItem(this.enableButton);
        }
    }

    /**
     * 代表當介面被點擊的事件
     * @param event 介面點擊事件
     */
    @Override
    public void clickInventory(final @NotNull InventoryClickEvent event) {
        super.clickInventory(event);
        final HumanEntity whoClicked = event.getWhoClicked();

        if (whoClicked instanceof Player && event.getCurrentItem() != null) {
            final PlayerQuestDataFile dataFile = MouBieCat.getInstance().getPlayerDataManager().get(player);
            final int clickSlot = event.getSlot();

            switch (clickSlot) {
                // 判斷可見粒子狀態
                case 20:
                    dataFile.setViewParticle(true);
                    break;
                case 29:
                    dataFile.setViewParticle(false);
                    break;

                // 判斷接收消息狀態
                case 24:
                    dataFile.setReceiveMessage(true);
                    break;
                case 33:
                    dataFile.setReceiveMessage(false);
                    break;
            }

            this.initInventory(this.player);
        }
    }

    /**
     * 獲取是誰的狀態介面
     * @return 玩家
     */
    @NotNull
    public Player getPlayer() {
        return this.player;
    }

}
