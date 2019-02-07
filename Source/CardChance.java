/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopony;

/**
 *
 * @author Phustih
 */
public class CardChance {
    private int index;
    private String pic;
    private int loc;

    public CardChance(int index, String pic, int loc) {
        this.index = index;
        this.pic = pic;
        this.loc = loc;
    }

    public int getIndex() {
        return index;
    }

    public String getPic() {
        return pic;
    }

    public int getLoc() {
        return loc;
    }
    
    
}
