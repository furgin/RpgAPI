package com.vartala.soulofw0lf.rpgapi.warpsapi;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 6/24/13
 * Time: 6:29 PM
 * <p/>
 * This file is part of the Rpg Suite Created by Soulofw0lf and Linksy.
 * <p/>
 * The Rpg Suite is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * The Rpg Suite is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with The Rpg Suite Plugin you have downloaded.  If not, see <http://www.gnu.org/licenses/>.
 */
public class RpgWarp {
    //name of this warp
    private String warpName = "";
    //should this warp use a variance for the location it puts you at
    private Boolean variance = false;
    //variance radius for the warp
    private Integer warpVariance = 0;
    //what set does this warp belong to
    private String warpSet = "";
    //X location of the warp
    private Double warpX = 0.0;
    //Y location of the warp
    private Double warpY = 0.0;
    //Z location of the warp
    private Double warpZ = 0.0;
    //Yaw of the warp
    private Float warpYaw = 0.0f;
    //pitch of the warp
    private Float warpPitch = 0.0f;
    //world the warp is on
    private String worldName = "";
    //should the warp only be allowed to be entered from the same world
    private Boolean sameWorld = false;
    //cooldown for a player to be able to use the same warp
    private Integer warpCoolDown = 0;
    //is an item needed to use the warp
    private Boolean itemNeeded = false;
    //should the item be consumed if it is needed for a warp
    private Boolean itemConsumed = false;
    //should you need to use the item to activate the warp
    private Boolean useItemForWarp = false;
    //list of all material types that can be used for this warp
    private List<Material> itemMaterial = new ArrayList<Material>();
    //should an item need a specific name for this warp
    private Boolean itemNeedsName = false;
    //list of all item names for this warp
    private List<String> itemNames = new ArrayList<String>();
    //should a specific lore be needed for this warp
    private Boolean needsLore = false;
    //list of all lores needed for this warp
    private List<String> loreNeeded = new ArrayList<String>();
    //does this warp need it's own permission?
    private Boolean singlePerm = false;
    //what is the permission this warp needs if it needs one
    private String permNeeded = "";
    //special behaviors for the warps to do
    private List<WarpBehavior> warpBehaviors = new ArrayList<WarpBehavior>();
    //does the player need to be a certain level to use this warp?
    private Boolean levelNeeded = false;
    //if a level is required what should it be?
    private Integer warpLevel = 1;
    //should this warp use a cool down
    private Boolean useCD = false;

    /**
     *
     * @return
     */
    public List<String> getLoreNeeded() {
        return loreNeeded;
    }

    /**
     *
     * @param loreNeeded
     */
    public void setLoreNeeded(List<String> loreNeeded) {
        this.loreNeeded = loreNeeded;
    }

    /**
     *
     * @return
     */
    public Boolean getNeedsLore() {
        return needsLore;
    }

    /**
     *
     * @param needsLore
     */
    public void setNeedsLore(Boolean needsLore) {
        this.needsLore = needsLore;
    }

    /**
     *
     * @return
     */
    public List<String> getItemNames() {
        return itemNames;
    }

    /**
     *
     * @param itemNames
     */
    public void setItemNames(List<String> itemNames) {
        this.itemNames = itemNames;
    }

    /**
     *
     * @return
     */
    public Boolean getItemNeedsName() {
        return itemNeedsName;
    }

    /**
     *
     * @param itemNeedsName
     */
    public void setItemNeedsName(Boolean itemNeedsName) {
        this.itemNeedsName = itemNeedsName;
    }

    /**
     *
     * @return
     */
    public List<Material> getItemMaterial() {
        return itemMaterial;
    }

    /**
     *
     * @param itemMaterial
     */
    public void setItemMaterial(List<Material> itemMaterial) {
        this.itemMaterial = itemMaterial;
    }

    /**
     *
     * @return
     */
    public Boolean getUseItemForWarp() {
        return useItemForWarp;
    }

    /**
     *
     * @param useItemForWarp
     */
    public void setUseItemForWarp(Boolean useItemForWarp) {
        this.useItemForWarp = useItemForWarp;
    }

    /**
     *
     * @return
     */
    public Boolean getItemConsumed() {
        return itemConsumed;
    }

    /**
     *
     * @param itemConsumed
     */
    public void setItemConsumed(Boolean itemConsumed) {
        this.itemConsumed = itemConsumed;
    }

    /**
     *
     * @return
     */
    public Boolean getItemNeeded() {
        return itemNeeded;
    }

    /**
     *
     * @param itemNeeded
     */
    public void setItemNeeded(Boolean itemNeeded) {
        this.itemNeeded = itemNeeded;
    }

    /**
     *
     * @return
     */
    public Integer getWarpCoolDown() {
        return warpCoolDown;
    }

    /**
     *
     * @param warpCoolDown
     */
    public void setWarpCoolDown(Integer warpCoolDown) {
        this.warpCoolDown = warpCoolDown;
    }

    /**
     *
     * @return
     */
    public Boolean getSameWorld() {
        return sameWorld;
    }

    /**
     *
     * @param sameWorld
     */
    public void setSameWorld(Boolean sameWorld) {
        this.sameWorld = sameWorld;
    }

    /**
     *
     * @return
     */
    public String getWorldName() {
        return worldName;
    }

    /**
     *
     * @param worldName
     */
    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    /**
     *
     * @return
     */
    public Float getWarpPitch() {
        return warpPitch;
    }

    /**
     *
     * @param warpPitch
     */
    public void setWarpPitch(Float warpPitch) {
        this.warpPitch = warpPitch;
    }

    /**
     *
     * @return
     */
    public Float getWarpYaw() {
        return warpYaw;
    }

    /**
     *
     * @param warpYaw
     */
    public void setWarpYaw(Float warpYaw) {
        this.warpYaw = warpYaw;
    }

    /**
     *
     * @return
     */
    public Double getWarpZ() {
        return warpZ;
    }

    /**
     *
     * @param warpZ
     */
    public void setWarpZ(Double warpZ) {
        this.warpZ = warpZ;
    }

    /**
     *
     * @return
     */
    public Double getWarpY() {
        return warpY;
    }

    /**
     *
     * @param warpY
     */
    public void setWarpY(Double warpY) {
        this.warpY = warpY;
    }

    /**
     *
     * @return
     */
    public Double getWarpX() {
        return warpX;
    }

    /**
     *
     * @param warpX
     */
    public void setWarpX(Double warpX) {
        this.warpX = warpX;
    }

    /**
     *
     * @return
     */
    public String getWarpSet() {
        return warpSet;
    }

    /**
     *
     * @param warpSet
     */
    public void setWarpSet(String warpSet) {
        this.warpSet = warpSet;
    }

    /**
     *
     * @return
     */
    public Integer getWarpVariance() {
        return warpVariance;
    }

    /**
     *
     * @param warpVariance
     */
    public void setWarpVariance(Integer warpVariance) {
        this.warpVariance = warpVariance;
    }

    /**
     *
     * @return
     */
    public Boolean getVariance() {
        return variance;
    }

    /**
     *
     * @param variance
     */
    public void setVariance(Boolean variance) {
        this.variance = variance;
    }

    /**
     *
     * @return
     */
    public String getWarpName() {
        return warpName;
    }

    /**
     *
     * @param warpName
     */
    public void setWarpName(String warpName) {
        this.warpName = warpName;
    }

    /**
     *
     * @return
     */
    public Boolean getSinglePerm() {
        return singlePerm;
    }

    /**
     *
     * @param singlePerm
     */
    public void setSinglePerm(Boolean singlePerm) {
        this.singlePerm = singlePerm;
    }

    /**
     *
     * @return
     */
    public String getPermNeeded() {
        return permNeeded;
    }

    /**
     *
     * @param permNeeded
     */
    public void setPermNeeded(String permNeeded) {
        this.permNeeded = permNeeded;
    }

    /**
     *
     * @return
     */
    public List<WarpBehavior> getWarpBehaviors() {
        return warpBehaviors;
    }

    /**
     *
     * @param warpBehaviors
     */
    public void setWarpBehaviors(List<WarpBehavior> warpBehaviors) {
        this.warpBehaviors = warpBehaviors;
    }

    /**
     *
     * @return
     */
    public Boolean getLevelNeeded() {
        return levelNeeded;
    }

    /**
     *
     * @param levelNeeded
     */
    public void setLevelNeeded(Boolean levelNeeded) {
        this.levelNeeded = levelNeeded;
    }

    /**
     *
     * @return
     */
    public Integer getWarpLevel() {
        return warpLevel;
    }

    /**
     *
     * @param warpLevel
     */
    public void setWarpLevel(Integer warpLevel) {
        this.warpLevel = warpLevel;
    }

    /**
     *
     * @return
     */
    public Boolean getUseCD() {
        return useCD;
    }

    /**
     *
     * @param useCD
     */
    public void setUseCD(Boolean useCD) {
        this.useCD = useCD;
    }
}
