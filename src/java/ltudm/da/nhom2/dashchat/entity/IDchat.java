/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudm.da.nhom2.dashchat.entity;

/**
 *
 * @author sangdz
 */
public class IDchat {
    int ID1; // ID sender va receiver
    int ID2;
    String type;

    public IDchat() {
    }

    public int getID1() {
        return ID1;
    }

    public int getID2() {
        return ID2;
    }

    public String getType() {
        return type;
    }

    public void setID1(int ID1) {
        this.ID1 = ID1;
    }

    public void setID2(int ID2) {
        this.ID2 = ID2;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
