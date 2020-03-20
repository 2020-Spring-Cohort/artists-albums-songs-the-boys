import {
    displaySongs
} from './SongsPage.js'


const getAllSongs = () => {
    fetch('http://localhost:8080/songs/')
        .then(response => response.json())
        .then(songs => displaySongs(songs));
}


getAllSongs();

export {getAllSongs}