package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Remote;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.esprit.pidev.jpa.Comment;

@Remote

public interface ManageCommentRemote {

	public void addComment(int iduser, int idservice, String description);
	public void delete(int id);
	public List<Comment> afficheComment(int id);
	public Comment findById(int id);
	
}
