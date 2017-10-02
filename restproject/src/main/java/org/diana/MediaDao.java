package org.diana;

import java.util.List;

import javax.ejb.Local;

import org.jboss.tools.examples.model.Media;


@Local
public interface MediaDao {

	void createMedia(Media media);

	void removeMedia(Media media);

	void updateMedia(Media media);

	List<Media> getAllMedia();

	List<Media> findMediaByAuthor(String author);

	List<Media> findMediaByTitle(String title);
}
