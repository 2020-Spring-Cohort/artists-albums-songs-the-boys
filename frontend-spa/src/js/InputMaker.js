import { DomMaker } from './DomMaker.js'

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

export{ InputMaker }