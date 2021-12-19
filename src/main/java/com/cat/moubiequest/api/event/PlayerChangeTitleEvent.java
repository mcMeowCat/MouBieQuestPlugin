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

package com.cat.moubiequest.api.event;

import com.cat.moubiequest.api.quests.Quest;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個準備套用一個任務稱號
 * @author MouBieCat
 */
public final class PlayerChangeTitleEvent
        extends PlayerQuestEvent<Quest>
        implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    // 是否為取消狀態(預設=false)
    private boolean isCancel = false;

    /**
     * 建構子
     * @param quest 事件任務
     * @param who 玩家
     */
    public PlayerChangeTitleEvent(final @NotNull Quest quest, final @NotNull Player who) {
        super(quest, who);
    }

    /**
     * 是否為取消事件
     * @return 為取消事件
     */
    @Override
    public boolean isCancelled() {
        return this.isCancel;
    }

    /**
     * 設定該事件是否取消
     * @param b 取消
     */
    @Override
    public void setCancelled(final boolean b) {
        this.isCancel = b;
    }

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return PlayerChangeTitleEvent.handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return PlayerChangeTitleEvent.handlers;
    }

}
