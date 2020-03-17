package org.wcci.apimastery;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SongNotFoundException extends Throwable {

    public SongNotFoundException(String message) {
    }
}
