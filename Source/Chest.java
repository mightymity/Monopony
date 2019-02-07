/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopony;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author visio
 */
public class Chest implements Block {

    private int index;
    private String name;
    private String map_path;
    private JLabel label;
    private JPanel panel;
    private String owner_name;
    private ArrayList<CardChest> card;
    private Random randomGenerator;
    
    public Chest(int i,String c) {
        this.card = new ArrayList();
        this.index = i;
        this.name = "Chest";
        this.map_path = c;
        this.label = new JLabel();
        this.panel = new JPanel();
        this.label.setIcon(new ImageIcon(getClass().getResource(this.map_path)));
        this.panel.add(this.label);
        this.owner_name = "Chance";
        randomGenerator = new Random();
        card.add(new CardChest(0,"/Pic/chest/bankerror.jpg",200000));
        card.add(new CardChest(1,"/Pic/chest/doctorfee.jpg",-125000));
        card.add(new CardChest(2,"/Pic/chest/getstock.jpg",50000));
        card.add(new CardChest(3,"/Pic/chest/Life.jpg",100000));
        card.add(new CardChest(4,"/Pic/chest/Payhospital.jpg",-100000));
        card.add(new CardChest(5,"/Pic/chest/Paysch.jpg",-150000));
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public String getDeedPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDeedPath(String p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPrice(int p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JPanel getDeed_panel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JPanel getMap_panel() {
        return this.panel;
    }

    @Override
    public String getOwner_name() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOwner_name(String owner_name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public void action(Player a){
        int index = randomGenerator.nextInt(card.size());
        CardChest cardChest = card.get(index);
        a.addMoney(cardChest.getPrice());
        System.out.println(a.getMoney());
        JDialog showCard = new JDialog();
        JLabel picture = new JLabel();
        ImageIcon image = new ImageIcon(getClass().getResource(card.get(index).getPic()));
        picture.setIcon(image);
        showCard.setLayout(new BorderLayout());
        showCard.add(picture,BorderLayout.CENTER);
        showCard.setSize(291,197);
        showCard.setAlwaysOnTop(true);
        showCard.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        showCard.setLocation(650, 350);
        showCard.setVisible(true);
    }

}
