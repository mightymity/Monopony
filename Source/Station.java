/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopony;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author visio
 */
public class Station implements Block {
    private int index;
    private String name;
    private int price;
    private boolean bought;
    private String deed_path;
    private String map_path;
    private JPanel map_panel;
    private JPanel deed_panel;
    private JLabel deed_label;
    private JLabel map_label;
    private Player owner;
    private String owner_name;

    public Station(int index, String name, String deed_path, String map_path,int price) {
        this.index = index;
        this.name = name;
        this.owner_name = "None";
        this.price = price;
        this.deed_path = deed_path;
        this.map_path = map_path;
        this.owner = null;
        this.bought = false;
        this.deed_panel = new JPanel();
        this.map_panel = new JPanel();
        this.deed_label = new JLabel();
        this.map_label = new JLabel();
        this.deed_label.setIcon(new ImageIcon(getClass().getResource(this.deed_path)));
        this.deed_label.setBackground(new Color(0,204,204));
        this.map_label.setIcon(new ImageIcon(getClass().getResource(this.map_path)));
        this.map_panel.add(this.map_label);
        this.deed_panel.add(this.deed_label);
        this.deed_panel.setName(this.name);
        deed_panel.setBackground(new java.awt.Color(51, 51, 51));
        deed_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 185, 148), 5, true));
        
    }
    @Override
    public String getOwner_name() {
        return owner_name;
    }
    
    public void action(Player player){
        if(this.owner_name.equals("None") && player.getName().equals(this.owner_name)){
            player.takeMoney(this.price);
            this.owner.addMoney(this.price);
            
        } 
    }
    @Override
    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public void addImageMap(String p){
        this.map_label.setIcon(new ImageIcon(this.map_path));
    }
    public void addImageDeed(String p){
        this.deed_label.setIcon(new ImageIcon(this.deed_path));
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public boolean isBought() {
        return bought;
    }

    public Player getOwner() {
        return owner;
    }
    
    @Override
    public int getIndex() {
        return this.index;
    }

    public JPanel getMap_panel() {
        return map_panel;
    }

    public JPanel getDeed_panel() {
        return deed_panel;
    }

    @Override
    public String getDeedPath() {
        return this.deed_path;
    }

    @Override
    public void setDeedPath(String p) {
        this.deed_path  =p;
    }

    @Override
    public String getMapPath() {
        return this.map_path;
    }

    @Override
    public void setMapPath(String p) {
        this.map_path = p;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String n) {
        this.name = n;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(int p) {
        this.price = p;
    }
    
    public void setOwner(Player p) {
        this.owner = p;
    }
    
}
