/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import TransaksiDermaga.Controller.LoginController;
import TransaksiDermaga.Model.Database;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hanvito Michael Lee
 */
public class Driver {

    public static void main(String[] args) {
        try {
            Database db = new Database();
            db.connectDB();
            db.execute("INSERT INTO `user` (`id`, `name`) VALUES (NULL, 'test');");
            db.executeQuery("SELECT * FROM user");            
            while (db.getRs().next()) {
                String name = db.getRs().getString("name");                
                System.out.println(name);
            }
            db.disconnectDB();
//        LoginController login = new LoginController();
        } catch (SQLException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
