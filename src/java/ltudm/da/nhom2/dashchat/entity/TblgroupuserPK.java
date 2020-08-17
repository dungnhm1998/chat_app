/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudm.da.nhom2.dashchat.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sangdz
 */
@Embeddable
public class TblgroupuserPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "groupID")
    private int groupID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userID")
    private int userID;

    public TblgroupuserPK() {
    }

    public TblgroupuserPK(int groupID, int userID) {
        this.groupID = groupID;
        this.userID = userID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) groupID;
        hash += (int) userID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblgroupuserPK)) {
            return false;
        }
        TblgroupuserPK other = (TblgroupuserPK) object;
        if (this.groupID != other.groupID) {
            return false;
        }
        if (this.userID != other.userID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ltudm.da.nhom2.dashchat.entity.TblgroupuserPK[ groupID=" + groupID + ", userID=" + userID + " ]";
    }
    
}
