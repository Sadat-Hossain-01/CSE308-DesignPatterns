abstract class Processor extends Component {
}

class Processor5700 extends Processor {

    @Override
    void setType() {
        this.type = "AMD Ryzen 7 5700X Processor";
        this.componentPrice = 28000;
    }
}

class Processor5 extends Processor {

    @Override
    void setType() {
        this.type = "Intel Core i5 11th Generation Processor";
        this.componentPrice = 20000;
    }
}

class Processor7 extends Processor {

    @Override
    void setType() {
        this.type = "Intel Core i7 11th Generation Processor";
        this.componentPrice = 37000;
    }
}

class Processor9 extends Processor {

    @Override
    void setType() {
        this.type = "Intel Core i9 11th Generation Processor";
        this.componentPrice = 65000;
    }
}