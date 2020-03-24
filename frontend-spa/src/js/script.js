// class DomMaker {

//     constructor(elementType) {
//         this.htmlElement = document.createElement(elementType);
//     }

//     appendChild(element) {
//         this.htmlElement.append(element);
//         return this;
//     }

//     changeContent(newContent) {
//         this.htmlElement.innerText = newContent;
//         return this;
//     }

//     render() {
//         return this.htmlElement;
//     }

//     addClassName(className){
//         this.htmlElement.classList.add(className)
//         return this;
//     }

//     addOnClickAction(functionToRun){
//         this.htmlElement.addEventListener('click', (event)=>{
//             event.preventDefault();
//             functionToRun();
//         })
//         return this;
//     }
// }

// class InputMaker extends DomMaker{

//     constructor(){
//         super('input');
//     }
//     changeInputType(type){
//         this.htmlElement.setAttribute('type',type);
//         return this;
//     }
//     addPlaceholder(placeholder){
//         this.htmlElement.setAttribute('placeholder',placeholder);
//         return this;
//     }
// }

// const fetchAllArtists = () => {
//     fetch('http://localhost:8080/artists/')
//         .then(response => response.json())
//         .then(artists => displayArtists(artists));
// }

// const displayArtists = (artists) => {
//     artistListAnchorElement.innerHTML='';
//     let artistList = new DomMaker('ul')
//         .changeContent('List of artists');

//     artists.forEach((artist) => {
//         artistList.appendChild(new DomMaker('li')
//             .changeContent(artist.name)
//             .addOnClickAction(fetchAlbumsByArtist(artist.id))
//             .render())
//     });

//     artistListAnchorElement.append(artistList.render());
// }

// function fetchAlbumsByArtist(id){
//     fetch(`http://localhost:8080/artists/${id}/`)
//     .then(response => response.json())
//     .then(artists => console.log(artists));
// }


    // fetchAllArtists();

const artistListAnchorElement = document.querySelector('.artistListAnchor');
const albumListAnchorElement = document.querySelector('.albumListAnchor')

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
            console.log(artist)
            renderAlbumListView(artist);
        })
    })
    return mainElement
}

const renderAlbumListView = (artist) =>{
    while(albumListAnchorElement.firstChild){
        albumListAnchorElement.removeChild(albumListAnchorElement.firstChild);
    }
    console.log(albumListAnchorElement.firstChild)
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
    })
    albumListAnchorElement.appendChild(mainElement);
}

artistsPromise
    .then(promiseValue => renderArtistsView(promiseValue))
    .then(element =>artistListAnchorElement.appendChild(element))



