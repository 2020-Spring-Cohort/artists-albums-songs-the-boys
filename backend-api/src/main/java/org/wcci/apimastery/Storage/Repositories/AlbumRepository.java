package org.wcci.apimastery.Storage.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Entities.Album;

import java.util.Optional;

public interface AlbumRepository extends CrudRepository<Album, Long> {


}
