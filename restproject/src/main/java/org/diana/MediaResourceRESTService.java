package org.diana;

import java.util.List;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/media")
public class MediaResourceRESTService {

	@Inject
	MediaDao mediadao;

	@POST
	@Path("/createmedia")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addMedia(Media media) {
		mediadao.createMedia(media);
	}

	@POST
	@Path("/updatemedia")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void refreshMedia(Media media) {
		mediadao.updateMedia(media);
	}

	@POST
	@Path("/deletemedia")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deletemedia(Media media) {
		mediadao.removeMedia(media);
	}

	@GET
	@Path("/medialist")
	public List<Media> m(Media media) {
		return mediadao.getAllMedia(media);
	}
}
