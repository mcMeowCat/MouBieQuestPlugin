package moubiequest.core.itemstack.gui.ui;

import moubiequest.api.data.quest.PlayerQuestDataFile;
import moubiequest.api.itemstack.gui.GUI;
import moubiequest.api.itemstack.gui.Pageable;
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
import org.jetbrains.annotations.Nullable;

/**
 * 有關玩家狀態設定的選單介面類
 * @author MouBieCat
 */
public final class PlayerStatusUInventory
        extends UInventoryAbstract
        implements PlayerStatusGUI {

    private static final int INVENTORY_PLAYER_STATUS_RECEIVE_MESSAGE_BUTTON = 11;
    private static final int INVENTORY_PLAYER_STATUS_VIEW_PARTICLE_BUTTON = 15;
    private static final int INVENTORY_PLAYER_STATUS_BACK_INVENTORY_BUTTON = 40;

    // 返回上一層介面
    private final GUI returnInventory;

    // 開啟功能
    private final UItemBuilder enableButton;

    // 關閉功能
    private final UItemBuilder disableButton;

    // 可見粒子特效
    private final UItem viewParticleButton;

    // 接收任務消息
    private final UItem receiveMessageButton;

    // 返回上一層清單
    private final UItem backInventoryButton;

    /**
     * 建構子
     * @param player 玩家
     * @param backGUI 要返回的介面 (null 則直接關閉介面)
     */
    public PlayerStatusUInventory(final @NotNull Player player, final @Nullable GUI backGUI) {
        super(MouBieCat.getInstance().getInventoryFile().getPlayerStatusInventoryTitle(player), InventorySize.FIVE);
        this.returnInventory = backGUI;

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

        // 解析通用按鈕 (返回上一層清單)
        builder = new UItemStackBuilder(inventoryFile.getPlayerStatusInventoryCommonButton("back_button"), INVENTORY_PLAYER_STATUS_BACK_INVENTORY_BUTTON);
        this.backInventoryButton = builder;
    }

    /**
     * 初始化介面
     * @param player 玩家
     */
    @Override
    protected void initInventory(final @NotNull Player player) {
        // 清除當前介面上的所有按鈕
        this.clearInventory();

        // 添加介面基本按鈕
        this.addUItem(this.viewParticleButton).addUItem(this.receiveMessageButton).addUItem(this.backInventoryButton);

        final PlayerQuestDataFile dataFile = MouBieCat.getInstance().getPlayerDataManager().get(player);
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
            final Player clickPlayer = (Player) whoClicked;
            final PlayerQuestDataFile dataFile = MouBieCat.getInstance().getPlayerDataManager().get(clickPlayer);
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

                // 判斷返回上一層清單
                case INVENTORY_PLAYER_STATUS_BACK_INVENTORY_BUTTON:
                    this.backGUI(clickPlayer);
                    break;
            }

            this.initInventory(clickPlayer);
        }
    }

    /**
     * 返回上一層介面
     * @param player 玩家
     */
    public void backGUI(final @NotNull Player player) {
        // 如果沒有上層介面，則直接關閉該介面
        if (this.returnInventory == null)
            player.closeInventory();

        // 如果該介面帶有頁數，則回到第一頁(0)
        else if (this.returnInventory instanceof Pageable) {
            final Pageable pageableGUI = (Pageable) this.returnInventory;
            pageableGUI.open(player, 0);

        } else // 否則，正常情況下開啟
            this.returnInventory.open(player);

    }

    /**
     * 獲取返回的介面
     * @return 介面
     */
    @NotNull
    public GUI getReturnGUI() {
        return this.returnInventory;
    }

}
