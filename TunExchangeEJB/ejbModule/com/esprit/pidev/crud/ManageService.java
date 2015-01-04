package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.pidev.jpa.Category;
import com.esprit.pidev.jpa.Service;

/**
 * Session Bean implementation class ManageService
 */
@Stateless
@LocalBean
public class ManageService implements ManageServiceRemote, ManageServiceLocal {

	@PersistenceContext(unitName = "TunExchange")
	private EntityManager em;
	private List<String> ch;

	/**
	 * Default constructor.
	 */
	public ManageService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addService(Service s) {
		em.persist(s);

	}

	@Override
	public Service findById(int id) {

		return em.find(Service.class, id);
	}

	@Override
	public void update(Service s) {
		em.merge(s);

	}

	@Override
	public void delete(int id) {
		Service service=findById(id);
		
		em.remove(em.merge(service));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> findService() {

		Query query = em.createQuery("SELECT s FROM Service s where s.etat= 0 ");
		List<Service> services = query.getResultList();

		return services;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> afficheAllService() {
		Query query = em.createQuery("SELECT s FROM Service s ");
		List<Service> services = query.getResultList();

		return services;
	}
	
	public List<Service> afficheAlldesactiveService() {
		Query query = em.createQuery("SELECT s FROM Service s where s.etat= 0 ");
		List<Service> services = query.getResultList();

		return services;
	}
	public List<Service> afficheAllactiveService() {
		Query query = em.createQuery("SELECT s FROM Service s where s.etat= 1 ");
		List<Service> services = query.getResultList();

		return services;
	}

	@Override
	public int NbreDeService() {
		Query query =em.createQuery("SELECT COUNT(s) FROM Service c");
		return (Integer) query.getSingleResult();
	}

	@Override
	public void updateById(int id) {
Service service=findById(id);
		
		em.merge(service);
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> afficheCompanyService() {
		
		Query query = em.createQuery("SELECT s FROM Service s where s.etat= 1 ");
		List<Service> services = query.getResultList();

		return services;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> afficheCustomerService() {
		Query query = em.createQuery("SELECT s FROM Service s where s.etat= 1 ");
		List<Service> services = query.getResultList();

		return services;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> afficheCategory() {
		Query q=em.createQuery("Select c from Category c");
		List<Category> listeCategorie=q.getResultList();
		return listeCategorie ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> serchByName(String name) {
		
		Query query=em.createQuery("SELECT s FROM Service s where s.etat=1 and s.name like :name").setParameter("name", "%"+name+"%");
		
		
		List<Service> services = query.getResultList();

		return services;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> searchByCategory(String category) {
		Query query=em.createQuery("SELECT s from Service s where s.etat=1 and s.category.nameCategory='"+category+"'");
		List<Service> services = query.getResultList();

		return services;
	}

	@Override
	public void MoveToOtherCategory(int id, String namCategory) {
		Service s =findById(id);
		Query query=em.createQuery("SELECT c FROM Category c where c.nameCategory='"+namCategory+"'");
		Category category=(Category) query.getSingleResult();
	//	s.setCategory(category);
		
	}

	@Override
	public int nbVote(int id) {
	return (Integer) em.createQuery("SELECT  s.nbVote from Service s where s.idService=:p1").setParameter("p1", id).getSingleResult();
		
	}

	@Override
	public float getnote(int id) {
	
		return (Float) em.createQuery("SELECT  s.note from Service s where s.idService=:p1").setParameter("p1", id).getSingleResult();
	}
	


	@Override
	public String getnbservice() {
		return (String) em.createQuery("SELECT count(s) FROM Service s where s.etat=false").getSingleResult().toString();
	}


	@Override
	public List<Service> findService(String name,String note1,String note2,String price1,String price2,String cat) {
		if(name.equals(" ")){name="";}
		if(cat.equals(" ")){cat="";}
		Query query=em.createQuery("SELECT s from Service s where s.etat=1 and s.name like '%"+name+"%' and (s.note Between '"+note1+"' and '"+note2+"' ) and (s.prixToken Between '"+price1+"' and '"+price2+"' ) and s.category.nameCategory like '%"+cat+"%'");
		List<Service> services = query.getResultList();

		return services;
	}

	@Override
	public Service ShowService(int id) {
		// TODO Auto-generated method stub
		return em.find(Service.class, id);
	}



}
