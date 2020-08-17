/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudm.da.nhom2.dashchat.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sangdz
 */
@Entity
@Table(name = "tblgroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblgroup.findAll", query = "SELECT t FROM Tblgroup t")
    , @NamedQuery(name = "Tblgroup.findByGroupID", query = "SELECT t FROM Tblgroup t WHERE t.groupID = :groupID")
    , @NamedQuery(name = "Tblgroup.findByGroupName", query = "SELECT t FROM Tblgroup t WHERE t.groupName = :groupName")
    , @NamedQuery(name = "Tblgroup.findByAdmin", query = "SELECT t FROM Tblgroup t WHERE t.admin = :admin")})
public class Tblgroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "groupID")
    private Integer groupID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "groupName")
    private String groupName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "admin")
    private int admin;

    public Tblgroup() {
    }

    public Tblgroup(Integer groupID) {
        this.groupID = groupID;
    }

    public Tblgroup(Integer groupID, String groupName, int admin) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.admin = admin;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupID != null ? groupID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblgroup)) {
            return false;
        }
        Tblgroup other = (Tblgroup) object;
        if ((this.groupID == null && other.groupID != null) || (this.groupID != null && !this.groupID.equals(other.groupID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ltudm.da.nhom2.dashchat.entity.Tblgroup[ groupID=" + groupID + " ]";
    }
    
}
