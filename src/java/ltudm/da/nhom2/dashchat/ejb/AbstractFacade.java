/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudm.da.nhom2.dashchat.ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import ltudm.da.nhom2.dashchat.entity.IDchat;
import ltudm.da.nhom2.dashchat.entity.Tblchat;
import ltudm.da.nhom2.dashchat.entity.Tblgroup;
import ltudm.da.nhom2.dashchat.entity.Tblgroupuser;
import ltudm.da.nhom2.dashchat.entity.TblgroupuserPK;
import ltudm.da.nhom2.dashchat.entity.Tbluser;

/**
 *
 * @author sangdz
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    // Tìm theo tên userName 
    public List<T> findbyUserName(Object userName) {
        TypedQuery<Tbluser> q = getEntityManager().createQuery("SELECT t FROM Tbluser t WHERE t.userName = :userName", Tbluser.class);
        return (List<T>) q.setParameter("userName", userName).getResultList();
    }

    // Tìm theo tên userName 
    public Tbluser findbyAccount(Object account) {
        TypedQuery<Tbluser> query = getEntityManager().createQuery("SELECT t FROM Tbluser t WHERE t.account = :account", Tbluser.class);
        return query.setParameter("account", account).getSingleResult();
    }

    // Tìm lịch sử chat theo group name
    public List<T> findbyGroupName(Object groupName) {
        TypedQuery<Tblgroup> q2 = getEntityManager().createQuery("SELECT t FROM Tblgroup t WHERE t.groupName = :groupName", Tblgroup.class);
        return (List<T>) q2.setParameter("GroupName", groupName).getResultList();
    }

    // Tìm lịch sử chat theo ID 
    public List<T> findchatbyID(Object ID1, Object ID2, Object type) {
        if (type.equals("u")) {
            TypedQuery<Tblchat> q2 = getEntityManager().createQuery("SELECT t FROM Tblchat t WHERE (t.sender = :ID1 or t.sender = :ID2) and (t.receiver= :ID1 or t.receiver= :ID2) and t.type=:type ", Tblchat.class);
            return (List<T>) q2.setParameter("ID1", ID1).setParameter("ID2", ID2).setParameter("type", type).getResultList();
        } else {
            TypedQuery<Tblchat> q2 = getEntityManager().createQuery("SELECT t FROM Tblchat t WHERE t.receiver= :ID2 and t.type=:type ", Tblchat.class);
            return (List<T>) q2.setParameter("ID2", ID2).setParameter("type", type).getResultList();
        }
    }

    public List<T> findMessageByID(Object ID1) {
        TypedQuery<Tblchat> q2 = getEntityManager().createQuery("SELECT t FROM Tblchat t WHERE t.sender = :ID1 or t.receiver = :ID1", Tblchat.class);
        return (List<T>) q2.setParameter("ID1", ID1).getResultList();

    }
    
    public List<T> findchatID(Object ID1) {
        TypedQuery<Tblchat> q2 = getEntityManager().createQuery("SELECT t FROM Tblchat t WHERE t.sender = :ID1 OR t.receiver = :ID1 GROUP BY t.receiver,t.sender", Tblchat.class);
        return (List<T>) q2.setParameter("ID1", ID1).getResultList();
    }
    
    public List<T> findGroupByID(Object ID1) {
        TypedQuery<Tblgroupuser> q2 = getEntityManager().createQuery("SELECT t FROM Tblgroupuser t WHERE t.tblgroupuserPK.userID = :ID1", Tblgroupuser.class);
        return (List<T>) q2.setParameter("ID1", ID1).getResultList();
    }
    
      public Tblgroup findgroupbyID(Object ID1) {
        TypedQuery<Tblgroup> q2 = getEntityManager().createQuery("SELECT t FROM Tblgroup t WHERE t.groupID = :ID1", Tblgroup.class);
        return  q2.setParameter("ID1", ID1).getSingleResult();
    }

}
