/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudm.da.nhom2.dashchat.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ltudm.da.nhom2.dashchat.entity.Tblgroupuser;

/**
 *
 * @author sangdz
 */
@Stateless
public class TblgroupuserFacade extends AbstractFacade<Tblgroupuser> {

    @PersistenceContext(unitName = "DashChatPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblgroupuserFacade() {
        super(Tblgroupuser.class);
    }
    
}
