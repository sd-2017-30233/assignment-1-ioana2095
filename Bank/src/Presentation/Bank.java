/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DataOperation.*;
import Business.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Ioana
 */
public class Bank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Login gui=new Login();
        gui.setVisible(true);
        
    }
    
}
