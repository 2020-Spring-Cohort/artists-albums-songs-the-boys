import {
    DomMaker
} from './DomMaker.js'


const anchorElement = document.querySelector('.anchor');

const displaySongs = (songs) => {
    anchorElement.innerHTML='';
    let songList = new DomMaker('ul')
        .changeContent('List of songs');

    songs.forEach((song) => {
        songList.appendChild(new DomMaker('li')
            .changeContent(song.title)
            .render())
    });

    anchorElement.append(songList.render());
}


export {
    displaySongs
}