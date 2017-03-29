/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Ioana
 */
public class Client {
    private String nume;
    private int idCard;
    private String cnp;
    private String adress;
    public Client(String nume,int idCard,String cnp,String adress)
    {
        this.nume=nume;
        this.cnp=cnp;
        this.idCard=idCard;
        this.adress=adress;
    }
    public Client()
    {
    }
    public String getNume()
    {
        return this.nume;
    }
    public String getCnp()
    {
        return this.cnp;
    }
    public int getIdCard()
    {
        return this.idCard;
    }
    public String getAdress()
    {
        return this.adress;
    }
    public void setNume(String nume)
    {
        this.nume=nume;
    }
    public void setCnp(String cnp)
    {
       this.cnp=cnp;
    }
    public void setIdCard(int idCard)
    {
      this.idCard=idCard;
    }
    public void setAdress(String adress)
    {
        this.adress=adress;
    }
}
