/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopony;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author visio
 */
public class Corner implements Block {

    private int index;
    private String name;
    private String map_path;
    private String deed_path;
    private JPanel map_panel;
    private JLabel map_label;
    private String dialog_path;
    private JLabel dialog_label;
    private int price;
    private String owner_name;
    private JDialog showcard;
    private JButton[] buttons;

    public Corner(int index, String name, String map_path, int price, String dialog_path) {
        this.index = index;
        this.name = name;
        this.dialog_path = dialog_path;
        this.owner_name = "Government";
        this.map_path = map_path;
        this.deed_path = "";
        this.price = price;
        this.map_panel = new JPanel();
        this.map_label = new JLabel();
        this.showcard = new JDialog();
        this.dialog_label = new JLabel();
        this.map_label.setIcon(new ImageIcon(getClass().getResource(this.map_path)));
        this.map_panel.add(this.map_label);
        this.dialog_label.setIcon(new ImageIcon(getClass().getResource(this.dialog_path)));

        //map_label.setIcon(new ImageIcon(getClass().getResource("/Pic/tony.png")));
        //map_panel.add(map_label);
    }

    public String getDialog_path() {
        return dialog_path;
    }

    public JLabel getDialog_label() {
        return dialog_label;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public void action(Player player) {
        if (this.getName().equals("Go")) {
            this.showcard.setLayout(new BorderLayout());
            this.showcard.add(dialog_label, BorderLayout.CENTER);
            this.showcard.setSize(291, 197);
            this.showcard.setAlwaysOnTop(true);
            this.showcard.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            this.showcard.setLocation(650, 350);
            this.showcard.setVisible(true);
            player.takeMoney(2000000);
            player.addMoney(2000000);

        } else if (this.getName().equals("Jail")) {
            this.showcard.setLayout(new BorderLayout());
            this.showcard.add(dialog_label, BorderLayout.CENTER);
            this.showcard.setSize(291, 197);
            this.showcard.setAlwaysOnTop(true);
            this.showcard.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            this.showcard.setLocation(650, 350);
            this.showcard.setVisible(true);
            

                //player.takeMoney(this.price);
                //this.owner.addMoney(this.price);
            
                player.takeMoney(2000000);
            
        } else if (this.getName().equals("Go Jail")) {
            System.out.println("money ="+player.getMoney());
            if (player.getMoney() < 2000000) {
                System.out.println("\t\t-> " + player.getDeeds().size());
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

                    showDeeds.setAlwaysOnTop(true);
                    showDeeds.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    showDeeds.setLocation(650, 350);
                    showDeeds.setVisible(true);
                }
            }
            this.showcard.setLayout(new BorderLayout());
            this.showcard.add(dialog_label, BorderLayout.CENTER);
            this.showcard.setSize(291, 197);
            this.showcard.setAlwaysOnTop(true);
            this.showcard.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            this.showcard.setLocation(650, 350);
            this.showcard.setVisible(true);
            player.takeMoney(2000000);
            player.setIndex(10);
        }
    }

    @Override
    public int getIndex() {
        return this.index;
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

    @Override
    public JPanel getDeed_panel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JPanel getMap_panel() {
        return map_panel;
    }
}
