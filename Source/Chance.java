/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopony;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;



/**
 *
 * @author visio
 */
public class Chance implements Block {
    private int index;
    private String name;
    private String map_path;
    private JLabel label;
    private JPanel panel;
    private String owner_name;
    
    private ArrayList<CardChance> card;
    private Random randomGenerator;
    public Chance(int i,String c) {
        this.card = new ArrayList();
        randomGenerator = new Random();
        this.index=  i;
        this.name ="Chance";
        this.map_path = c;
        this.label = new JLabel();
        this.panel = new JPanel();
        this.label.setIcon(new ImageIcon(getClass().getResource(this.map_path)));
        this.panel.add(this.label);
        this.owner_name = "Chance";
        
        card.add(new CardChance(0,"/Pic/chance/forward3.jpg",3));
        card.add(new CardChance(1,"/Pic/chance/go.jpg",0));
        card.add(new CardChance(2,"/Pic/chance/goback.jpg",-3));
        card.add(new CardChance(3,"/Pic/chance/gojail.jpg",10));
        card.add(new CardChance(4,"/Pic/chance/goback2.jpg",-2));
        card.add(new CardChance(5,"/Pic/chance/forward2.jpg",2));
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
        CardChance cardChance = card.get(index);
        if(cardChance.getLoc() == 0 || cardChance.getLoc() == 10){
            a.setIndex(cardChance.getLoc());
        }else{
            a.setIndex(a.getIndex()+cardChance.getLoc());
        }
        
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
