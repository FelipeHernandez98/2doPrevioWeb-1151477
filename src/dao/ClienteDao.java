package dao;

import java.util.List;

import javax.persistence.EntityManager;



import util.JPAUtil;

public class ClienteDao {
EntityManager em = null;
	
	public ClienteDao() {
		this.em = JPAUtil.getEntityManagerFactory().createEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public List<ClienteDao> listar (){
		return (List<ClienteDao>) em.createQuery("select c from Cliente c").getResultList();
	}
}
