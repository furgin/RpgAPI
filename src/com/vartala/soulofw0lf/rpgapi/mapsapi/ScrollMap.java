package com.vartala.soulofw0lf.rpgapi.mapsapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class ScrollMap {

    //Local
    private MapView MV = null;
    private MapMenu SMR = null;
    ;

    //Global
    private static Map<Short, ScrollMap> AllScrollMaps = new HashMap<>();
    private static List<String> DirtyPlayers = new ArrayList<>();
    private static List<Short> DirtyMaps = new ArrayList<>();

    /**
     *
     * @param id
     */
    public ScrollMap(short id) {
        this.MV = Bukkit.getMap(id);
        this.SMR = new MapMenu();
        this.removeAllRenders();
    }

    /**
     *
     */
    public void removeAllRenders() {
        for (MapRenderer mr : this.MV.getRenderers()) {
            this.MV.removeRenderer(mr);
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public static ScrollMap addScrollMap(short id) {
        if (containsScrollMap(id))
            return null;
        ScrollMap SM = new ScrollMap(id);
        AllScrollMaps.put(id, SM);
        DirtyMaps.add(id);
        return SM;
    }

    /**
     *
     * @param id
     * @return
     */
    public static ScrollMap getScrollMap(short id) {
        if (containsScrollMap(id)) {
            return AllScrollMaps.get(id);
        }
        return null;
    }

    /**
     *
     * @param key
     * @return
     */
    public static boolean containsScrollMap(short key) {
        return AllScrollMaps.containsKey(key);
    }

    /**
     *
     * @param name
     * @return
     */
    public static boolean isPlayerDirty(String name) {
        return DirtyPlayers.contains(name);
    }

    /**
     *
     * @param id
     * @return
     */
    public static boolean isMapDirty(short id) {
        return DirtyMaps.contains(id);
    }

    /**
     *
     * @param name
     */
    public static void removeDirtyPlayer(String name) {
        DirtyPlayers.remove(name);
    }

    /**
     *
     * @param id
     */
    public static void removeDirtyMap(short id) {
        DirtyMaps.remove(new Short(id));
    }

    /**
     *
     * @return
     */
    public static List<String> getDirtyPlayers() {
        return DirtyPlayers;
    }

    /**
     *
     * @return
     */
    public static List<Short> getDirtyMaps() {
        return DirtyMaps;
    }

    /**
     *
     * @return
     */
    public MapMenu getMapRender() {
        return this.SMR;
    }

    /**
     *
     * @param name
     */
    public void update(String name) {
        if (this.MV.getRenderers().contains(this.SMR)) {
            this.MV.removeRenderer(this.getMapRender());
        }
        this.MV.addRenderer(this.getMapRender());
        DirtyPlayers.add(name);
    }

}
