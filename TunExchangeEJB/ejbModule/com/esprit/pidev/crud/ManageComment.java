package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.esprit.pidev.jpa.Comment;
import com.esprit.pidev.jpa.Service;
import com.esprit.pidev.jpa.User;

/**
 * Session Bean implementation class ManageComment
 */
@Stateless
@LocalBean
public class ManageComment implements ManageCommentRemote, ManageCommentLocal {

	@PersistenceContext(unitName = "TunExchange")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManageComment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addComment(int iduser, int idservice, String description) {
		Comment c = new Comment();
		c.setDescription(description);
		c.setUser(em.find(User.class, iduser));
		c.setService(em.find(Service.class, idservice));
		em.persist(c);

	}
	@Override
	public void delete(int id) {
		Comment comment = findById(id);
		em.remove(em.merge(comment));
	}

	@Override
	public List<Comment> afficheComment(int id) {
		String query = "select c from Comment c   join c.service s where s.id=:idService ";
		return em.createQuery(query).setParameter("idService", id)
				.getResultList();

	}

	@Override
	public Comment findById(int id) {
		return em.find(Comment.class, id);
	}

}
