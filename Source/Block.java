/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopony;
import javax.swing.*;
/**
 *
 * @author visio
 */
public interface Block {
    int getIndex();
    String getDeedPath();
    void setDeedPath(String p);
    String getMapPath();
    void setMapPath(String p);
    String getName();
    void setName(String n);
    int getPrice();
    void setPrice(int p);
    JPanel getDeed_panel();
    JPanel getMap_panel();
    public void action(Player player);
    public String getOwner_name();
    public void setOwner_name(String owner_name);

}
