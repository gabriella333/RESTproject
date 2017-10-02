package org.diana;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.tools.examples.model.Media;


@Path("/media")
public class MediaResourceRESTService {

	@Inject
	MediaDao mediadao;
	

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public void addMedia(Media media) {
		mediadao.createMedia(media);
	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public void refreshMedia(Media media) {
		mediadao.updateMedia(media);
	}

	@POST
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public void deletemedia( @PathParam("id") int id) {
		mediadao.deleteMedia(id);
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Media> mediaList() {
		return mediadao.getAllMedia();
	}
	
	@GET
	@Path("/listbyauthor/{a}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Media> mediaByAuthor( @PathParam("a") String author) {
		return mediadao.findMediaByAuthor(author);
	}
		
	
	@GET
	@Path("/listbytitle/{t}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Media> mediaByTitle( @PathParam("t") String title) {
		return mediadao.findMediaByTitle(title);
	}
	
	
	
}
