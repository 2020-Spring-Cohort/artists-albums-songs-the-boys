import {
    DomMaker
} from './DomMaker.js'


const anchorElement = document.querySelector('.anchor');

const displayArtists = (artists) => {
    anchorElement.innerHTML='';
    let artistList = new DomMaker('ul')
        .changeContent('List of artists');

    artists.forEach((artist) => {
        artistList.appendChild(new DomMaker('li')
            .changeContent(artist.name)
            .render())
    });

    anchorElement.append(artistList.render());
}


export {
    displayArtists
}