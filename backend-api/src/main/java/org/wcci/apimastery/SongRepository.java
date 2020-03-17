package org.wcci.apimastery;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SongRepository extends CrudRepository <Song,Long> {


    Optional<Song> findByTitle (String songTitle);
}
