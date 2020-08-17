/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudm.da.nhom2.dashchat.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ltudm.da.nhom2.dashchat.entity.Tbluser;

/**
 *
 * @author sangdz
 */
@Stateless
public class TbluserFacade extends AbstractFacade<Tbluser> {

    @PersistenceContext(unitName = "DashChatPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbluserFacade() {
        super(Tbluser.class);
    }
    
    
}
