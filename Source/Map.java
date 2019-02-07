/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopony;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Phustih
 */
public class Map{
    private ArrayList<Block> map;
    private ArrayList<Integer> special_index;

    public ArrayList<Block> getMap() {
        return map;
    }

    public ArrayList<Integer> getSpecial() {
        return special_index;
    }
    
    public Map() throws SQLException {
        map = new ArrayList();
        special_index = new ArrayList();
        special_index.add(2);
        special_index.add(4);
        special_index.add(7);
        special_index.add(17);
        special_index.add(22);
        special_index.add(33);
        special_index.add(36);
        special_index.add(40);
        special_index.add(30);
        special_index.add(20);
        special_index.add(10);
        map.add(0,new Corner(0,"Start","/Pic/corner/go.png",2000000,"/Pic/card/go.png"));
        //map.add(1,new Deed(1,"Jacob Field","/Pic.deed/player1.png",20000));
        map.add(1,new Deed(1,"Jacob Field","/Pic/jacobfield.png","/Pic/lands/jacobfield.png",20000));
        map.add(2,new Chest(2,"/Pic/lands/chest.png"));
        map.add(3, new Deed(3,"Texas Stadium","/Pic/texasstadium.png","/Pic/lands/texusstadium.png",40000));
        map.add(4, new Deed(4,"Tax","/Pic/TAX.png","/Pic/lands/tax.png",2000000));
        map.add(5, new Station(5,"ORD_AIRPORT","/Pic/ORD_AIRPORT.png","/Pic/lands/ord_airport.png",250000));
        map.add(6,new Deed(6,"Grand Ole Opry","/Pic/grand_ole_opry.png","/Pic/lands/grandole.png",60000));
        map.add(7, new Chance(7,"/Pic/lands/chance.png"));
        map.add(8, new Deed(8,"Gateway of Arh","/Pic/gateway.png","/Pic/lands/gateway.png",60000));
        map.add(9, new Deed(9,"Mall of America","/Pic/mallofamerica.png","/Pic/lands/mallof.png",80000));
        map.add(10, new Corner(10,"Jail","/Pic/corner/jail.png",2000000,"/Pic/card/Jail.png"));
        map.add(11, new Deed(11,"Olypic park","/Pic/olympic_park.png","/Pic/lands/centennial.png",100000));
        map.add(12, new Station(11,"Mobile Service","/Pic/MIGHTY_FIBRE.png","/Pic/lands/mightymobile.png",250000));
        map.add(13, new Deed(13,"Red Rocks","/Pic/redrocks.png","/Pic/lands/redrock.png",100000));
        map.add(14, new Deed(14,"Liberty Bell","/Pic/libertybell.png","/Pic/lands/libretybell.png",120000));
        map.add(15, new Station(15,"LAD","/Pic/LAX_AIRPORT.png","/Pic/lands/lax_airport.png",250000));
        map.add(16, new Deed(16,"South Beach","/Pic/southbeach.png","/Pic/lands/southbeach.png",140000));
        map.add(17, new Chest(17,"/Pic/lands/chest_2.png"));
        map.add(18, new Deed(18,"Jason Space Center","/Pic/johnson.png","/Pic/lands/johnson.png",140000));
        map.add(19, new Deed(19,"Pioneer Square","/Pic/pioneer_square.png","/Pic/lands/pioneersquare.png",160000));
        map.add(20, new Corner(20,"FreeParking","/Pic/corner/parking.png",2000000,""));
        map.add(21, new Deed(21,"Cameback","/Pic/cameback.png","/Pic/lands/came.png",180000));
        map.add(22, new Chance(22,"/Pic/lands/chance_2.png"));
        map.add(23, new Deed(23,"Waikiki Beach","/Pic/waikiki_beach.png","/Pic/lands/waikiki.png",180000));
        map.add(24, new Deed(24,"Disney World","/Pic/disneyworld.png","/Pic/lands/disneyworld.png",200000));
        map.add(25, new Station(25,"JFK","/Pic/JFK_AIRPORT.png","/Pic/lands/jfk_airport.png",250000));
        map.add(26, new Deed(26,"French Quater","/Pic/frechquarter.png","/Pic/lands/french.png",220000));
        map.add(27, new Deed(27,"Hollywood","/Pic/hollywood.png","/Pic/lands/hollywood.png",220000));
        map.add(28, new Station(28,"Internet Service","/Pic/MIGHTY_MOBILE.png","/Pic/lands/mightyinternet.png",250000));
        map.add(29, new Deed(29,"Golden Gate","/Pic/goldengatebeidge.png","/Pic/lands/golden.png",240000));
        map.add(30, new Corner(30,"Go Jail","/Pic/corner/gojail.png",2000000,"/Pic/card/gojail.png"));
        map.add(31, new Deed(31,"Las Vegas","/Pic/lasvegas.png","/Pic/lands/lasvegas.png",260000));
        map.add(32, new Deed(32,"Wrigley Field","/Pic/wrigley field.png","/Pic/lands/wrigley.png",260000));
        map.add(33, new Chest(33,"/Pic/lands/chest_3.png"));
        map.add(34, new Deed(34,"Whitehouse","/Pic/whitehouse.png","/Pic/lands/whitehouse.png",280000));
        map.add(35, new Station(35,"ATL","/Pic/ATL_AIRPORT.png","/Pic/lands/atl_airport.png",250000));
        map.add(36, new Chance(36,"/Pic/lands/chance_3.png"));
        map.add(37, new Deed(37,"Fenway Park","/Pic/fenwaypark.png","/Pic/lands/fenwaypark.png",350000));
        map.add(38, new Deed(38,"Credit","/Pic/CREDITCARDDEBT.png","/Pic/lands/credit.png",750000));
        map.add(39, new Deed(39,"Time Square","/Pic/time_square.png","/Pic/lands/time.png",500000));
        
    }
   
    
}
