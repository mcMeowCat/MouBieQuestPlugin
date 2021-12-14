/**
 * LICENSE
 * MouBieQuest
 * -------------
 * Copyright (C) 2021 MouBieCat(MouBie_Yuki)
 * -------------
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 */

package moubiequest.core.format;

import moubiequest.api.data.quest.PlayerQuestDataFile;
import moubiequest.api.format.PlayerDataFormat;
import moubiequest.api.yaml.plugin.FormatFile;
import moubiequest.main.MouBieCat;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 有關轉換玩家紀錄的站位符介面
 * @author MouBoeCat
 */
public final class PlayerQuestDataFormat
        extends FormatAbstract<Player>
        implements PlayerDataFormat {

    private static final String PLAYER_DATA_NAME = "{PLAYER_NAME}";
    private static final String PLAYER_TITLE_NAME = "{PLAYER_TITLE_NAME}";
    private static final String PLAYER_DATA_HONOR_POINT = "{PLAYER_HONOR_POINT}";
    private static final String PLAYER_DATA_RECEIVE_MESSAGE = "{PLAYER_RECEIVE_MESSAGE}";
    private static final String PLAYER_DATA_VIEW_PARTICLE = "{PLAYER_VIEW_PARTICLE}";

    /**
     * 建構子
     * @param obj  轉換物件
     * @param file 格式檔案
     */
    public PlayerQuestDataFormat(final @NotNull Player obj, final @NotNull FormatFile file) {
        super(obj, file);
    }

    /**
     * 將文字的站位符轉換
     * @param msg    訊息格式
     * @param player 傳患的玩家資訊
     */
    @NotNull
    public String replace(final @NotNull String msg, final @NotNull Player player) {
        return msg;
    }

    /**
     * 將文字的站位符轉換
     *
     * @param msg 訊息格式
     */
    @NotNull
    public String replace(final @NotNull String msg) {
        String replaceStr = msg;
        final PlayerQuestDataFile dataFile = MouBieCat.getInstance().getPlayerDataManager().get(this.replacer);

        // 轉換玩家名稱
        replaceStr = replaceStr.replace(
                PLAYER_DATA_NAME, this.replacer.getName()
        );

        // 轉換玩家當前使用的稱號
        replaceStr = replaceStr.replace(
                PLAYER_TITLE_NAME,
                this.formatFile.getPlayerUseTitle(dataFile.getPlayerTitle())
        );

        // 轉換玩家榮譽點數
        replaceStr = replaceStr.replace(
                PLAYER_DATA_HONOR_POINT, ""+dataFile.getHonorPoint()
        );

        // 轉換是否接收任務消息
        replaceStr = replaceStr.replace(
                PLAYER_DATA_RECEIVE_MESSAGE,
                this.formatFile.getPlayerReceiveMessageString(dataFile.isReceiveMessage())
        );

        return replaceStr;
    }

    /**
     * 將文字集合的站位符轉換
     *
     * @param list 訊息格式
     * @return 轉換後的文字集合
     */
    @NotNull
    public List<String> replaceList(final @NotNull List<String> list) {
        final List<String> newList = new ArrayList<>();

        // 迴圈轉換所有字串
        for (String str : list)
            newList.add(this.replace(str));

        return newList;
    }

}
