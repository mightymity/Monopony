/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopony;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author visio
 */
public class Deed implements Block {
    private JDBC jdbc;
    private javax.swing.JLabel jLabel1;
    private int index;
    private String name;
    private Player owner;
    private int price;
    private int house;
    private int fine;
    private boolean bought;
    private boolean hotel;
    private String deed_path;
    private String map_path;
    private JPanel map_panel;
    private JPanel deed_panel;
    private JLabel deed_label;
    private JLabel map_label;
    private String owner_name;
    private JButton[] buttons;

    public Deed(int i, String name, String dp, String mp, int price) throws SQLException {
        this.index = i;
        this.owner = null;
        this.name = name;
        this.price = price;
        jdbc = new JDBC();
        fine = 10;
        house = 0;
        hotel = false;
        this.owner_name = "None";
        this.bought = false;
        this.deed_path = dp;
        this.map_path = mp;
        this.deed_panel = new JPanel();
        this.map_panel = new JPanel();
        this.deed_label = new JLabel();
        this.map_label = new JLabel();
        this.deed_label.setIcon(new ImageIcon(getClass().getResource(this.deed_path)));
        this.deed_label.setBackground(new Color(0, 204, 204));
        this.map_label.setIcon(new ImageIcon(getClass().getResource(this.map_path)));
        this.map_panel.add(this.map_label);
        this.deed_panel.add(this.deed_label);
        this.deed_panel.setName(this.name);
        deed_panel.setBackground(new Color(51, 51, 51));
        deed_panel.setBorder(new javax.swing.border.LineBorder(new Color(54, 185, 148), 5, true));

    }

    public void action(Player player) {
        if (!player.getName().equals(this.owner_name)) {
            while (player.getMoney() < this.getPrice() && player.getDeeds().size() > 0) {
                JDialog showDeeds = new JDialog();
                buttons = new JButton[player.getDeeds().size()];
                System.out.println(player.getDeeds().size());
                showDeeds.setSize(400, 200);

                showDeeds.setLayout(new GridBagLayout());
                GridBagConstraints gc = new GridBagConstraints();
                gc.gridx = 0;
                gc.gridy = 0;
                gc.weightx = 0.5;
                gc.weighty = 0.5;
                gc.fill = GridBagConstraints.NONE;
                gc.anchor = GridBagConstraints.CENTER;
                for (int i = 0; i < buttons.length; i++) {

                    System.out.println("in");
                    buttons[i] = new JButton("" + player.getDeeds().get(i).getName()); //create button & add to 
                    buttons[i].setName(player.getDeeds().get(i).getName());
                    buttons[i].setPreferredSize(new Dimension(200, 50));
                    int buttonNdx = i;
                    buttons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            int ndx = player.getDeeds().indexOf(this);
                            System.out.println(this.toString());
                            System.out.println(buttonNdx);
                            /*
                            for (int i =0;i<player.getDeeds().size();++i){
                                System.out.println(i+": "+player.getDeeds().get(i).getName());
                                if (player.getDeeds().get(i).getName().equals("123")){
                                    ndx = i;
                                }
                            }*/
                            ndx = buttonNdx;
                            player.getDeeds().get(ndx).setOwner_name("None");
                            player.getDeeds().get(ndx).setOwner(null);
                            player.getDeeds().get(ndx).setBought(false);
                            System.out.println(player.getMoney());
                            player.addMoney(player.getDeeds().get(ndx).getPrice());
                            System.out.println(player.getDeeds().get(ndx).getPrice());
                            System.out.println(player.getMoney());

                            //player.takeMoney(price);
                            player.getDeeds().remove(ndx);
                            buttons[ndx].setVisible(false);
                            showDeeds.dispose();

                            //this.owner.addMoney(this.price);
                        }
                    }); //add an action listener to the current button
                    if (i % 3 == 0 && i != 0) {
                        gc.gridy++;
                        gc.gridx = 0;
                    }
                    gc.gridx++;
                    showDeeds.add(buttons[i], gc); //add that same button to the panel

                }

                //showCard.add(picture,BorderLayout.CENTER);
                showDeeds.setAlwaysOnTop(true);
                showDeeds.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                showDeeds.setLocation(650, 350);
                showDeeds.setVisible(true);
            }
            
            //player.takeMoney(this.price);
            //this.owner.addMoney(this.price);
            /*try {
                jdbc.execute("update", "("+1+","+this.getPrice()+")", "(check, money)");
            } catch (SQLException ex) {
                Logger.getLogger(Deed.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        
        }
        
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public boolean isBought() {
        return bought;
    }

    public void addImageMap(String p) {
        this.map_label.setIcon(new ImageIcon(this.map_path));
    }

    public void addImageDeed(String p) {
        this.deed_label.setIcon(new ImageIcon(getClass().getResource(this.deed_path)));
    }

    public int getIndex() {
        return index;
    }

    public JPanel getMap_panel() {
        return map_panel;
    }

    public JLabel getDeed_label() {
        return deed_label;
    }

    public JPanel getDeed_panel() {
        return deed_panel;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner.getName();
    }

    public void add_house() {
        if (this.house <= 3) {
            this.house += 1;
        }
    }

    public void remove_house() {
        if (this.house > 0) {
            this.house -= 1;
        }
    }

    public void add_hotel() {
        if (!this.hotel) {
            this.hotel = true;
            this.house += 1;
        }
    }

    public void remove_hotel() {
        if (this.hotel) {
            this.hotel = false;
        }
    }

    public int getRent() {
        return (int) ((price * 0.1) + ((price * 0.5) * this.house));
    }

    public int getPrice() {
        return this.price;
    }

    public int getHouse() {
        return house;
    }

    public boolean hasHotel() {
        return hotel;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    @Override
    public String getDeedPath() {
        return this.deed_path;
    }

    @Override
    public void setDeedPath(String p) {
        this.deed_path = p;
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
    public void setName(String n) {
        this.name = n;
    }

    @Override
    public void setPrice(int p) {
        this.price = p;
    }

    @Override
    public String toString() {
        return "Deed: " + this.name;
    }
}
