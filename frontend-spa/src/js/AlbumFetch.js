import {
    displayAlbums
} from './AlbumRender.js'


const getAllAlbums = () => {
    fetch('http://localhost:8080/albums/')
        .then(response => response.json())
        .then(albums => displayAlbums(albums));
}


getAllAlbums();

export {getAllAlbums}