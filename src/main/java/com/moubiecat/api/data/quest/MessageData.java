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

package com.moubiecat.api.data.quest;

/**
 * 有關玩家接收訊息管理介面
 * @author MouBieCat
 */
public interface MessageData {

    /**
     * 獲取玩家是否接收有關任務的訊息
     * @return 是否可看見
     */
    boolean isReceiveMessage();

    /**
     * 設定玩家是否接收有關任務的訊息
     * @param status 狀態
     */
    void setReceiveMessage(final boolean status);

}
