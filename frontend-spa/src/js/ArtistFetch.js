import {
    displayArtists
} from './ArtistRender.js'


const getAllArtists = () => {
    fetch('http://localhost:8080/artists/')
        .then(response => response.json())
        .then(artists => displayArtists(artists));
}


getAllArtists();

export {getAllArtists}