/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopony;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author visio
 */
public class Player {

    private String path;
    private int index;
    private String name;
    private JLabel label;
    private JPanel panel;
    private int money;
    private ArrayList<Deed> deeds;
    private ArrayList<Station> stations;
    
    public Player(String name, String p, int m) {
        this.name = name;
        index = 0;
        this.money = m;
        this.path = p;
        this.label = new JLabel();
        label.setIcon(new ImageIcon(getClass().getResource(this.path)));
        //this.label.setOpaque(false);
        this.panel = new JPanel();
        this.panel.setSize(70, 100);
        this.panel.setOpaque(false);
        this.panel.add(label);
        this.panel.setLayout(new GridBagLayout());
        deeds = new ArrayList();
        stations = new ArrayList();
    }
    
    public ArrayList<Deed> getDeeds() {
        return deeds;
    }
    
    public ArrayList<Station> getStation() {
        return stations;
    }
    
    public void addDeeds(Deed d) {
        this.deeds.add(d);
    }
    
    public void addStation(Station s) {
        this.stations.add(s);
    }

    public boolean buy(Block d) {
        if (d instanceof Deed) {
            if ((!deeds.contains((Deed) d)) && (!(((Deed) d).isBought()))) {
                this.takeMoney(((Deed) d).getPrice());
                this.deeds.add((Deed) d);
                ((Deed) d).setOwner_name(this.name);
                ((Deed) d).setOwner(this);
                ((Deed) d).setBought(true);
                return true;
            }
        } else if (d instanceof Station) {
            if ((!stations.contains((Station) d)) && (!(((Station) d).isBought()))) {
                this.stations.add((Station) d);
                ((Station) d).setOwner(this);
                ((Station) d).setOwner_name(this.name);
                this.takeMoney(((Station) d).getPrice());
                ((Station) d).setBought(false);
                return true;
            }
        }
        return false;
    }
    
    public boolean sell(Block d) {
        
        if (d instanceof Deed) {
            if (deeds.contains((Deed) d)) {
                this.deeds.remove((Deed) d);
                this.addMoney(((Deed) d).getPrice());
                ((Deed) d).setOwner_name("None");
                ((Deed) d).setOwner(null);
                ((Deed) d).setBought(false);
                return true;
            }
        } else if (d instanceof Station) {
            if (stations.contains((Station) d)) {
                this.stations.remove((Station) d);
                this.addMoney(((Station) d).getPrice());
                ((Station) d).setOwner_name("None");
                ((Station) d).setOwner(null);
                ((Station) d).setBought(false);
                return true;
            }
        }
        return false;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int m) {
        this.money += m;
    }

    public void setLabelImage(String path) {
        this.label.setIcon(new ImageIcon(this.path));
    }
    
    public JPanel getPanel() {
        return panel;
    }

    public void update() {
        label.validate();
        label.repaint();
    }

    public void walk(int step) {
        this.index += step;
        if (this.index > 39) {
            this.index %= 40;
        }
    }

    public int getIndex() {
        return this.index;
    }

    public String getPic() {
        return this.path;
    }
    
    public String getPath() {
        return path;
    }
    
    public String getName() {
        return name;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void takeMoney(int num) {
        this.money -= num;
    }
}
