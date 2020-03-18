package org.wcci.apimastery.Storage.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Entities.Song;

import java.util.Optional;

public interface SongRepository extends CrudRepository <Song,Long> {
    Optional<Song> findByTitle (String title);
}
