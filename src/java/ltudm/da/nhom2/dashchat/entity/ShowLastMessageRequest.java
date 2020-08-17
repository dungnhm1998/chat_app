/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudm.da.nhom2.dashchat.entity;

/**
 *
 * @author Admin
 */
public class ShowLastMessageRequest {

    private int userID; //user ID của người đang đăng nhập

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public ShowLastMessageRequest() {
    }
    
}
