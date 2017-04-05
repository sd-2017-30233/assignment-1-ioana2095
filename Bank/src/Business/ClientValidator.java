/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.regex.*;

/**
 *
 * @author Ioana
 */
public class ClientValidator {
    public boolean validateCnp(String cnp){
        try
	{
            Pattern p = Pattern.compile("([a-z])");
            Matcher m =null;
		if(cnp.length()<13&& p.matcher(cnp).find()==true) return false;
                
		int suma =  Integer.parseInt(String.valueOf(cnp.charAt(0))) * 2 +
			Integer.parseInt(String.valueOf(cnp.charAt(1))) * 7 +
			Integer.parseInt(String.valueOf(cnp.charAt(2))) * 9 +
			Integer.parseInt(String.valueOf(cnp.charAt(3))) * 1 +
			Integer.parseInt(String.valueOf(cnp.charAt(4))) * 4 +
			Integer.parseInt(String.valueOf(cnp.charAt(5))) * 6 +
			Integer.parseInt(String.valueOf(cnp.charAt(6))) * 3 +
			Integer.parseInt(String.valueOf(cnp.charAt(7))) * 5 +
			Integer.parseInt(String.valueOf(cnp.charAt(8))) * 8 +
			Integer.parseInt(String.valueOf(cnp.charAt(9))) * 2 +
			Integer.parseInt(String.valueOf(cnp.charAt(10))) * 7 +
			Integer.parseInt(String.valueOf(cnp.charAt(11))) * 9;
		int rest = suma % 11;

		if((rest<10) && (String.valueOf(rest).equals(String.valueOf(cnp.charAt(12))))||(rest == 10) && String.valueOf(cnp.charAt(12)).equals("1") )
		{
			if(Integer.parseInt(String.valueOf(cnp.charAt(0)))==1 || Integer.parseInt(String.valueOf(cnp.charAt(0)))==2)
                        {
                            return true;
                        }
		}
	}
	catch(Exception ex)
	{
		System.out.println(ex.getMessage());
	}   
        return false;
    }
    
    
}
