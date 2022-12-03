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
        this.type = "11th Generation Core i5 Processor";
        this.componentPrice = 20000;
    }
}

class Processor7 extends Processor {

    @Override
    void setType() {
        this.type = "11th Generation Core i7 Processor";
        this.componentPrice = 37000;
    }
}

class Processor9 extends Processor {

    @Override
    void setType() {
        this.type = "11th Generation Core i9 Processor";
        this.componentPrice = 65000;
    }
}