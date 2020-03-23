package org.wcci.apimastery.Storage.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Entities.Album;
import org.wcci.apimastery.Entities.Artist;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Long> {


}
