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

export {
    DomMaker
};