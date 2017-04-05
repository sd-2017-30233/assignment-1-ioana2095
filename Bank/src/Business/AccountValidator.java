/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ioana
 */
public class AccountValidator {
    public boolean validare(String idNrAccount,float ammountOfMoney,String dataCreation,String cnp)
    {
        ClientValidator cv=new ClientValidator();
        if(String.valueOf(idNrAccount.charAt(0)).equals("R") && String.valueOf(idNrAccount.charAt(1)).equals("O") && String.valueOf(idNrAccount.charAt(11)).equals("B") && String.valueOf(idNrAccount.charAt(12)).equals("T"))
            if(ammountOfMoney>0)
                if(isDateValid(dataCreation))
                    if(cv.validateCnp(cnp))
                    return true;
        return false;
    }
    public boolean validare(String idNrAccount)
    {
        Pattern p = Pattern.compile("([A-Z])");
        Matcher m =null;
        int i=0;
        if(String.valueOf(idNrAccount.charAt(0)).equals("R") && String.valueOf(idNrAccount.charAt(1)).equals("O")){
            while(i<idNrAccount.length()){
                 if(p.matcher(String.valueOf(idNrAccount.charAt(i))).find())
                 {
                     if(String.valueOf(idNrAccount.charAt(i)).equals("B") && String.valueOf(idNrAccount.charAt(i+1)).equals("T") )
                         return true;
                 }
                 i++;
            }
                 
        }
        return false;
    }
    public static boolean isDateValid(String date) 
    {
    String DATE_FORMAT = "dd/MM/yyyy";
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}

