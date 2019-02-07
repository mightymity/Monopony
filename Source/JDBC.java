/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopony;

import java.io.IOException;
import java.sql.*;

/**
 *
 * @author visio
 */
public class JDBC {

    private String username = "monopony";
    private String password = "1212312121";
    private String connect = "jdbc:mysql://161.246.94.202:3306/monopony?useSSL=true";
    private Statement stmd = null;

    public JDBC() throws SQLException {
        Connection conn = DriverManager.getConnection(connect, username, password);
        System.out.println("Connected");
        stmd = (Statement) conn.createStatement();
    }

    public ResultSet query(String col, String table, String exten) throws SQLException {
        String statement = "SELECT " + col + " FROM " + table + " " + exten + ";";
        ResultSet result = stmd.executeQuery(statement);
        return result;
    }

    public void execute(String table, String value, String exten) throws SQLException {
        String statement = "INSERT INTO " + table + exten + " VALUES " + value + ";";
        stmd.execute(statement);
    }

    public void close() throws SQLException {
        stmd.close();
    }

    public void update(String table, String exten, String value) throws SQLException {
        String statement = "UPDATE " + table +" SET "+ exten + value + ";";
        System.out.println("update -> " + statement);
        //System.out.println("");
        stmd.executeUpdate(statement);//execute("user","(\"ham\", 1234), null")
    }
    public static void main(String[] args) throws IOException, SQLException {
        // TODO code application logic here
        JDBC test = new JDBC();
        test.execute("user", "(\"Charnchyyy\",1415)", "(username, password,name)"); //ใส่ user
        //INSERT INTO user VALUES ("first","2345yu","Phusith");
        ResultSet user = test.query("password", "user", "WHERE username LIKE \"treesakul\""); //ดึง password จาก user
        while (user.next()) {
            System.out.println(user.getString(1));
        }
        test.close();
        
    }

}
