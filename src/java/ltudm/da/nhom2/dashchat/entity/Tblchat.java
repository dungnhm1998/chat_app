/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudm.da.nhom2.dashchat.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sangdz
 */
@Entity
@Table(name = "tblchat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblchat.findAll", query = "SELECT t FROM Tblchat t")
    , @NamedQuery(name = "Tblchat.findByChatID", query = "SELECT t FROM Tblchat t WHERE t.chatID = :chatID")
    , @NamedQuery(name = "Tblchat.findBySender", query = "SELECT t FROM Tblchat t WHERE t.sender = :sender")
    , @NamedQuery(name = "Tblchat.findByReceiver", query = "SELECT t FROM Tblchat t WHERE t.receiver = :receiver")
    , @NamedQuery(name = "Tblchat.findByType", query = "SELECT t FROM Tblchat t WHERE t.type = :type")
    , @NamedQuery(name = "Tblchat.findByTime", query = "SELECT t FROM Tblchat t WHERE t.time = :time")})
public class Tblchat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "chatID")
    private Integer chatID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sender")
    private int sender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "receiver")
    private int receiver;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "content")
    private String content;
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    public Tblchat() {
    }

    public Tblchat(Integer chatID) {
        this.chatID = chatID;
    }

    public Tblchat(Integer chatID, int sender, int receiver, String type, String content) {
        this.chatID = chatID;
        this.sender = sender;
        this.receiver = receiver;
        this.type = type;
        this.content = content;
    }

    public Integer getChatID() {
        return chatID;
    }

    public void setChatID(Integer chatID) {
        this.chatID = chatID;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chatID != null ? chatID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblchat)) {
            return false;
        }
        Tblchat other = (Tblchat) object;
        if ((this.chatID == null && other.chatID != null) || (this.chatID != null && !this.chatID.equals(other.chatID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ltudm.da.nhom2.dashchat.entity.Tblchat[ chatID=" + chatID + " ]";
    }
    
}
