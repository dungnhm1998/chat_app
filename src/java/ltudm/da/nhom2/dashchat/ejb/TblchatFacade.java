/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudm.da.nhom2.dashchat.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ltudm.da.nhom2.dashchat.entity.IDchat;
import ltudm.da.nhom2.dashchat.entity.Tblchat;

/**
 *
 * @author sangdz
 */
@Stateless
public class TblchatFacade extends AbstractFacade<Tblchat> {

    @PersistenceContext(unitName = "DashChatPU")
    private EntityManager em;


    //public List<Tblchat> findchatID(Object ID1) {
       // TypedQuery<Tblchat> q2 = getEntityManager().createQuery("SELECT  t.sender AS ID1,t.receiver AS ID2,t.type FROM Tblchat t WHERE t.sender = :ID1 OR t.receiver = :ID1 GROUP BY t.receiver,t.sender", Tblchat.class);
       // return (List<Tblchat>) q2.setParameter("ID1", ID1).getResultList();

    //}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblchatFacade() {
        super(Tblchat.class);
    }

}
