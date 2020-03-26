const artistListAnchorElement = document.querySelector('.artistListAnchor');
const albumListAnchorElement = document.querySelector('.albumListAnchor');
const songListAnchorElement = document.querySelector('.songListAnchor');



const getAllArtists = () => {
    fetch('http://localhost:8080/artists/')
         .then(response => response.json())
         .then(artistsJson => renderArtistsView(artistsJson))
         .then(console.log("getAllArtists Ran"));
}




const renderArtistsView = (artists) =>{
    while(artistListAnchorElement.firstChild){
        artistListAnchorElement.removeChild(artistListAnchorElement.firstChild);
    }
    console.log("renderArtistsView ran")
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
    artistListAnchorElement.appendChild(mainElement);
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
            console.log("renderSongListView fires.")
            renderSingleAlbumView(album);
            console.log("renderSingleAlbumView fires.")
           
            
        })
    })
    albumListAnchorElement.appendChild(mainElement);


}

const renderSingleAlbumView = (album) =>{
    while(albumListAnchorElement.firstChild){
        albumListAnchorElement.removeChild(albumListAnchorElement.firstChild);
    }
    const mainElement = document.createElement('div');
    const title = document.createElement('h2')
    title.innerText = "Albums"
    mainElement.appendChild(title);
    // const artistName = document.createElement('h3');
    // artistName.innerText = artist.name;
    // mainElement.appendChild(artistName);
    const albumName = document.createElement('h4');
    albumName.innerText = album.name;
    mainElement.appendChild(albumName);
    const albumImage = document.createElement('IMG');
    const url = album.imagePath;
    albumImage.src = url;
    mainElement.appendChild(albumImage);
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

const submitButton = document.querySelector(".submit-button")
const addSongButton = document.querySelector(".add-song-button")

submitButton.addEventListener("click", ()=>{
    submitForm();
    event.preventDefault();
})

addSongButton.addEventListener("click", ()=>{
    addNewSongInput();
    event.preventDefault();

})

const addNewSongInput = ()=>{
    const inputAnchor = document.querySelector(".input-col-right")
    const newInput = document.createElement('div')
    newInput.innerHTML = `
    <label for="song-name">Song Title</label>
    <input class="song-name" type="text" name="songname">
    `
    inputAnchor.appendChild(newInput)
}
const submitForm = () =>{

    const addNewArtist = () => {
        const artistName = document.querySelector(".artist-name");

        const newArtistJson = {
            "name": artistName.value
        }
        console.log("fetching artist POST")
        fetch("http://localhost:8080/artists/", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newArtistJson)
        })
        .then(response => response.json())
        .then(artist => addNewAlbum(artist.id))
        .then(()=> getAllArtists())
    }


    const addNewAlbum = (newArtist) =>{
        console.log("Artist id: " + newArtist)
        const albumName = document.querySelector(".album-name");

        const newAlbumJson = {
            "name": albumName.value,
            "imagePath": "https://i.picsum.photos/id/825/200/300.jpg"
        }
        console.log("fetching album PATCH")
        fetch(`http://localhost:8080/artists/${newArtist}/albums/`, {
            method: "PATCH",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newAlbumJson)
        })
        .then(response => response.json())
        .then(album => addNewSong(album.id))
    }

    const addNewSong = (newAlbum) =>{
        console.log("Album id: " + newAlbum)
        console.log(newAlbum)
        const songNameList = document.querySelectorAll('.song-name')

        songNameList.forEach(song => {
            const newSongJson = {
                "title": song.value,
                "duration": "4:21"
            }
            console.log(newSongJson)
            fetch(`http://localhost:8080/albums/${newAlbum}/songs/`, {
                method: "PATCH",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newSongJson)
            })
            .then(response => response.json)
            
        })
        getAllArtists()
    }
    addNewArtist()
    console.log("Submitform fired")
}

    getAllArtists();



