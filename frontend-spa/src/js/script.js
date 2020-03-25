const artistListAnchorElement = document.querySelector('.artistListAnchor');
const albumListAnchorElement = document.querySelector('.albumListAnchor');
const songListAnchorElement = document.querySelector('.songListAnchor');

const artistsPromise = fetch('http://localhost:8080/artists/')
                        .then(response => response.json());


const renderArtistsView = (artists) =>{
    const title = document.createElement('h2');
    title.innerText = 'Artists';
    const mainElement = document.createElement('div');
    mainElement.appendChild(title);
    const artistsList = document.createElement('ul');
    mainElement.appendChild(artistsList);
    artists.forEach(artist=>{
        const artistName = document.createElement('li');
        artistName.innerText = artist.name;
        mainElement.appendChild(artistName);

        artistName.addEventListener('click', ()=>{
            renderAlbumListView(artist);
        })
    })
    return mainElement
}

const renderAlbumListView = (artist) =>{
    while(albumListAnchorElement.firstChild){
        albumListAnchorElement.removeChild(albumListAnchorElement.firstChild);
    }
    const mainElement = document.createElement('div');
    const title = document.createElement('h2')
    title.innerText = "Albums"
    mainElement.appendChild(title);
    const artistName = document.createElement('h3');
    artistName.innerText = artist.name;
    mainElement.appendChild(artistName);
    const albumsList = document.createElement('ul');
    mainElement.appendChild(albumsList);
    artist.albums.forEach(album=>{
        const albumElement = document.createElement('li');
        albumElement.innerText = album.name;
        albumsList.appendChild(albumElement);

        albumElement.addEventListener('click', ()=>{
            renderSongListView(album);
        })
    })
    albumListAnchorElement.appendChild(mainElement);


}

const renderSongListView = (album) =>{
    while(songListAnchorElement.firstChild){
        songListAnchorElement.removeChild(songListAnchorElement.firstChild);
    }
    const mainElement = document.createElement('div');
    const title = document.createElement('h2');
    title.innerText = "Songs"
    mainElement.appendChild(title);
    const albumName = document.createElement('h3');
    albumName.innerText = album.name;
    mainElement.appendChild(albumName);
    const songsList = document.createElement('ul');
    mainElement.appendChild(songsList);
    album.songs.forEach(song=>{
        const songElement = document.createElement('li');
        songElement.innerText = song.title;
        songsList.appendChild(songElement);

        songElement.addEventListener('click', ()=>{
            renderSingleSongView(song);
        })
    })
    songListAnchorElement.appendChild(mainElement);
}

const renderSingleSongView = (song) =>{
    while(songListAnchorElement.firstChild){
        songListAnchorElement.removeChild(songListAnchorElement.firstChild);
    }
    const mainElement = document.createElement('div');
    const title = document.createElement('h2');
    title.innerText = song.title;
    mainElement.appendChild(title);
    const songDuration = document.createElement('h3');
    songDuration.innerText = "Duration: " + song.duration;
    mainElement.appendChild(songDuration);
    songListAnchorElement.appendChild(mainElement);
}


artistsPromise
    .then(promiseValue => renderArtistsView(promiseValue))
    .then(element =>artistListAnchorElement.appendChild(element))



