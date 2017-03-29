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
public class ProcessOp {
    private int ID_Employee;
    private String idNumberAcc;
    private float ammountOfMoney;
    private String dataOperation;
    private String op;

    public ProcessOp(int ID_Employee, String idNumberAcc, float ammountOfMoney, String dataOperation, String op) {
        this.ID_Employee = ID_Employee;
        this.idNumberAcc = idNumberAcc;
        this.ammountOfMoney = ammountOfMoney;
        this.dataOperation = dataOperation;
        this.op = op;
    }

    public ProcessOp() {}

    public int getIdEmployee() {
        return ID_Employee;
    }

    public void setIdEmployee(int ID_Employee) {
        this.ID_Employee = ID_Employee;
    }

    public String getIdNumberAcc() {
        return idNumberAcc;
    }

    public void setIdNumberAcc(String idNumberAcc) {
        this.idNumberAcc = idNumberAcc;
    }

    public float getAmmountOfMoney() {
        return ammountOfMoney;
    }

    public void setAmmountOfMoney(float ammountOfMoney) {
        this.ammountOfMoney = ammountOfMoney;
    }

    public String getDataOperation() {
        return dataOperation;
    }

    public void setDataOperation(String dataOperation) {
        this.dataOperation = dataOperation;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
}
