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
    public int meta_id;
    public int game_id;
    public String metaKey;
    public String metaValue;

    public int getMeta_id() {
        return meta_id;
    }

    public void setMeta_id(int meta_id) {
        this.meta_id = meta_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getMetaKey() {
        return metaKey;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    public String getMetaValue() {
        return metaValue;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }
    
     public String returnGameMetaJson(int m_id, int g_id, String key, String val){
        return "{ \"meta_id\" : \"" + m_id + "\", \"game_id\" : \"" + g_id + "\", \"metaKey\" : \"" +
                key + "\", \"metaValue\" : \"" + val + "\" }";
    }
}
