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
public class ShowLastMessageResponse {

    private int senderID; // userID đang đăng nhập
    private int receiverID; // ID của những user hoặc group đã nhận tin nhắn gần nhất từ sender
    private String content; // 
    private String type;

    public ShowLastMessageResponse() {
    }

    public ShowLastMessageResponse(int senderID, int receiverID, String content, String type) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.content = content;
        this.type = type;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    public String getContetnt() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
