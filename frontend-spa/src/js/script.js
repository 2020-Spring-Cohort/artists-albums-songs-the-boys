const artistListAnchorElement = document.querySelector('.artistListAnchor');

class DomMaker {

    constructor(elementType) {
        this.htmlElement = document.createElement(elementType);
    }

    appendChild(element) {
        this.htmlElement.append(element);
        return this;
    }

    changeContent(newContent) {
        this.htmlElement.innerText = newContent;
        return this;
    }

    render() {
        return this.htmlElement;
    }

    addClassName(className){
        this.htmlElement.classList.add(className)
        return this;
    }

    addOnClickAction(functionToRun){
        this.htmlElement.addEventListener('click', (event)=>{
            event.preventDefault();
            functionToRun();
        })
        return this;
    }
}

class InputMaker extends DomMaker{

    constructor(){
        super('input');
    }
    changeInputType(type){
        this.htmlElement.setAttribute('type',type);
        return this;
    }
    addPlaceholder(placeholder){
        this.htmlElement.setAttribute('placeholder',placeholder);
        return this;
    }
}

const fetchAllArtists = () => {
    fetch('http://localhost:8080/artists/')
        .then(response => response.json())
        .then(artists => displayArtists(artists));
}

const displayArtists = (artists) => {
    artistListAnchorElement.innerHTML='';
    let artistList = new DomMaker('ul')
        .changeContent('List of artists');

    artists.forEach((artist) => {
        artistList.appendChild(new DomMaker('li')
            .changeContent(artist.name)
            .addOnClickAction(fetchAlbumsByArtist)
            .render())
    });

    artistListAnchorElement.append(artistList.render());
}

function fetchAlbumsByArtist(){
    fetch('http://localhost:8080/albums/')
    .then(response => response.json())
    .then(artists => displayArtists(artists));
}


    fetchAllArtists();




