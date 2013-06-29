package com.vartala.soulofw0lf.rpgapi.chatapi;

/**
 * Created by: soulofw0lf
 * Date: 6/28/13
 * Time: 7:04 PM
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
public class RpgCities {
    private String regionName = "";
    private Double regionX = 0.0;
    private Double regionY = 0.0;
    private Double regionZ = 0.0;
    private String regionWorld = "";
    private Integer regionRadius = 0;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Double getRegionX() {
        return regionX;
    }

    public void setRegionX(Double regionX) {
        this.regionX = regionX;
    }

    public Double getRegionY() {
        return regionY;
    }

    public void setRegionY(Double regionY) {
        this.regionY = regionY;
    }

    public Double getRegionZ() {
        return regionZ;
    }

    public void setRegionZ(Double regionZ) {
        this.regionZ = regionZ;
    }

    public String getRegionWorld() {
        return regionWorld;
    }

    public void setRegionWorld(String regionWorld) {
        this.regionWorld = regionWorld;
    }

    public Integer getRegionRadius() {
        return regionRadius;
    }

    public void setRegionRadius(Integer regionRadius) {
        this.regionRadius = regionRadius;
    }
}
