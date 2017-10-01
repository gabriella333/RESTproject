package org.diana;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.print.attribute.standard.Media;

@Stateless
public class MediaDaoImp implements MediaDao {
	
	@Inject
	private EntityManager em;

	@Override
	public void createMedia(Media media) {
		em.persist(media);
		
	}

	@Override
	public void removeMedia(Media media) {
		em.remove(media);
		
	}

	@Override
	public void updateMedia(Media media) {
		em.merge(media);
		
	}

	@Override
	public List<Media> getAllMedia(Media media) {
		return em.createQuery("from Media m", Media.class).getResultList();
	}

	@Override
	public List<Media> findMediaByAuthor(String author) {
		return em.createQuery("from Media m where m.author like:author", Media.class).
				setParameter("author", author).getResultList();
	}

	@Override
	public List<Media> findMediaByTitle(String title) {
		return em.createQuery("from Media m where m.title like:title", Media.class).
				setParameter("title", title).getResultList();
	}

	
}
