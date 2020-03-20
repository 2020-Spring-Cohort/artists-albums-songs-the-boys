import {
    DomMaker
} from './DomMaker.js'


const anchorElement = document.querySelector('.anchor');

const displayAlbums = (albums) => {
    anchorElement.innerHTML='';
    let albumList = new DomMaker('ul')
        .changeContent('List of albums');

    albums.forEach((album) => {
        albumList.appendChild(new DomMaker('li')
            .changeContent(album.name)
            .render())
    });

    anchorElement.append(albumList.render());
}


export {
    displayAlbums
}