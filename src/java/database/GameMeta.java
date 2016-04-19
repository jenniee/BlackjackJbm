/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author kepoly
 */
public class GameMeta {

    /*
     *
     * Model the GAME META table here
     * GAME META may need to extend the Game Class.
     *
     */

    /**
     *
     */
    
    public int meta_id;

    /**
     *
     */
    public int game_id;

    /**
     *
     */
    public String metaKey;

    /**
     *
     */
    public String metaValue;

    /**
     *
     * @return
     */
    public int getMeta_id() {
        return meta_id;
    }

    /**
     *
     * @param meta_id
     */
    public void setMeta_id(int meta_id) {
        this.meta_id = meta_id;
    }

    /**
     *
     * @return
     */
    public int getGame_id() {
        return game_id;
    }

    /**
     *
     * @param game_id
     */
    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    /**
     *
     * @return
     */
    public String getMetaKey() {
        return metaKey;
    }

    /**
     *
     * @param metaKey
     */
    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    /**
     *
     * @return
     */
    public String getMetaValue() {
        return metaValue;
    }

    /**
     *
     * @param metaValue
     */
    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }
    
    /**
     *
     * @param m_id
     * @param g_id
     * @param key
     * @param val
     * @return
     */
    public String returnGameMetaJson(int m_id, int g_id, String key, String val){
        return "{ \"meta_id\" : \"" + m_id + "\", \"game_id\" : \"" + g_id + "\", \"metaKey\" : \"" +
                key + "\", \"metaValue\" : \"" + val + "\" }";
    }
}
