/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/


import com.mysql.jdbc.Connection;
import com.sun.scenario.effect.impl.Renderer;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francesco
 */
public class ConnectionSqlMagic {
    
    Connection con;
    Statement stmt;
    public ConnectionSqlMagic(String NameDb) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/"+NameDb;
            con =(Connection) DriverManager.getConnection(connectionString, "root", "");
            stmt = con.createStatement();
        } catch (Exception e) {
            
        }
    }
    
    public ResultSet selectAll(String db){
        List<String> ValueList = new ArrayList<String>();
        try {
            String query = "select * from " + db;
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return null;
    }
    
    
    
    
    public void close() throws SQLException{
        con.close();
    }
    
    public void insertInto(String stringa) throws SQLException{
        
        stmt.executeUpdate(stringa);
        
    }
    
    void wipedata() {
        try {
            stmt.executeUpdate("DELETE from inventario");
            stmt.executeUpdate("DELETE from lavori");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionSqlMagic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
