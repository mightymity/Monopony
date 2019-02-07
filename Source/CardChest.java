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
public class CardChest {
    private int index;
    private String pic;
    private int price;
    public CardChest(int index, String pic, int price) {
        this.index = index;
        this.pic = pic;
        this.price = price;
    }

    public int getIndex() {
        return index;
    }

    public String getPic() {
        return pic;
    }

    public int getPrice() {
        return price;
    }
    
    
}
