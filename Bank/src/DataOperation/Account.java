/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperation;


/**
 *
 * @author Ioana
 */
public class Account extends DomainObject {
    private String idNrAccount;
    private float ammountOfMoney;
    private String dataCreation;
    private String cnp;
    private int idType;
    
    public Account(String idNrAccount,float ammountOfMoney,String dataCreation,String cnp,int type)
    {
        this.idNrAccount=idNrAccount;
        this.ammountOfMoney=ammountOfMoney;
        this.dataCreation=dataCreation;
        this.cnp=cnp;
        this.idType=type;
    }
    public Account()
    {}
    public String getIdNrAccount() {
        return idNrAccount;
    }

    public void setIdNrAccount(String idNrAccount) {
        this.idNrAccount = idNrAccount;
    }

    public float getAmmountOfMoney() {
        return ammountOfMoney;
    }

    public void setAmmountOfMoney(float ammountOfMoney) {
        this.ammountOfMoney = ammountOfMoney;
    }

    public String getDataCreation() {
        return dataCreation;
    }

    public void setDataCreation(String dataCreation) {
        this.dataCreation = dataCreation;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

  

    
    
}
