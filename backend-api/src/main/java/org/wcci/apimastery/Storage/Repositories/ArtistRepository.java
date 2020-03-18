package org.wcci.apimastery.Storage.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Entities.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {

}
