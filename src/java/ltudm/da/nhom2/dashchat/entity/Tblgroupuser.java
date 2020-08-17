/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudm.da.nhom2.dashchat.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sangdz
 */
@Entity
@Table(name = "tblgroupuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblgroupuser.findAll", query = "SELECT t FROM Tblgroupuser t")
    , @NamedQuery(name = "Tblgroupuser.findByGroupID", query = "SELECT t FROM Tblgroupuser t WHERE t.tblgroupuserPK.groupID = :groupID")
    , @NamedQuery(name = "Tblgroupuser.findByUserID", query = "SELECT t FROM Tblgroupuser t WHERE t.tblgroupuserPK.userID = :userID")})
public class Tblgroupuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblgroupuserPK tblgroupuserPK;

    public Tblgroupuser() {
    }

    public Tblgroupuser(TblgroupuserPK tblgroupuserPK) {
        this.tblgroupuserPK = tblgroupuserPK;
    }

    public Tblgroupuser(int groupID, int userID) {
        this.tblgroupuserPK = new TblgroupuserPK(groupID, userID);
    }

    public TblgroupuserPK getTblgroupuserPK() {
        return tblgroupuserPK;
    }

    public void setTblgroupuserPK(TblgroupuserPK tblgroupuserPK) {
        this.tblgroupuserPK = tblgroupuserPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblgroupuserPK != null ? tblgroupuserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblgroupuser)) {
            return false;
        }
        Tblgroupuser other = (Tblgroupuser) object;
        if ((this.tblgroupuserPK == null && other.tblgroupuserPK != null) || (this.tblgroupuserPK != null && !this.tblgroupuserPK.equals(other.tblgroupuserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ltudm.da.nhom2.dashchat.entity.Tblgroupuser[ tblgroupuserPK=" + tblgroupuserPK + " ]";
    }
    
}
