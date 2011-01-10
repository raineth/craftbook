// $Id$
/*
 * CraftBook
 * Copyright (C) 2010 sk89q <http://www.sk89q.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package com.sk89q.craftbook;

import java.util.logging.Logger;

import com.sk89q.craftbook.access.PlayerInterface;
import com.sk89q.craftbook.access.ServerInterface;
import com.sk89q.craftbook.access.SignInterface;
import com.sk89q.craftbook.access.WorldInterface;
import com.sk89q.craftbook.util.Vector;

/**
 * Proxy plugin listener called by CraftBook. It has additional hooks
 * that are called by the main CraftBook listener, namely the Redstone
 * input hook.
 * 
 * @author sk89q
 */
public abstract class CraftBookDelegateListener {
    /**
     * Logger instance.
     */
    protected static final Logger logger = Logger.getLogger("Minecraft.CraftBook");
    
    /**
     * CraftBook.
     */
    protected CraftBookCore craftBook;
    
    /**
     * Server interface
     */
    protected ServerInterface server;
    
    /**
     * Construct the object.
     * 
     * @param craftBook
     * @param listener
     */
    public CraftBookDelegateListener(
            CraftBookCore craftBook,
            ServerInterface server) {
        this.craftBook = craftBook;
        this.server = server;
    }
    
    /**
     * Reads the configuration from the properties file.
     */
    public abstract void loadConfiguration();
    
    /**
     * Called on plugin unload.
     */
    public void disable() {
        
    }
    
    public void onTick() {}
    public void onSignCreate(WorldInterface world, int x, int y, int z) {}
    public boolean onSignChange(PlayerInterface i, WorldInterface world, Vector v, SignInterface s) {
        return false;
    }
    public boolean onCommand(PlayerInterface player, String[] split) {
        return false;
    }
    public boolean onServerCommand(String[] split) {
        return false;
    }
    public void onWireInput(WorldInterface world, Vector pt, boolean isOn, Vector changed) {}
    public void onDisconnect(PlayerInterface player) {}
    public boolean onBlockPlace(WorldInterface world, PlayerInterface p, Vector blockPlaced,
            Vector blockClicked, int itemInHand) {
        return false;
    }
    public boolean onBlockRightClicked(WorldInterface world, PlayerInterface p, Vector block,
            int itemInHand) {
        return false;
    }
    public boolean onBlockDestroy(PlayerInterface p, Vector block) {
        return false;
    }
}