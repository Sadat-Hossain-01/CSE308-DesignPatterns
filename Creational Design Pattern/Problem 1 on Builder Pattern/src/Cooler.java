abstract class Cooler extends Component {
}

class CPUCooler extends Cooler {

    @Override
    void setType() {
        this.type = "CPU Cooler";
        this.componentPrice = 36000;
    }
}

class LiquidCooler extends Cooler {

    @Override
    void setType() {
        this.type = "Liquid Cooler";
        this.componentPrice = 17000;
    }
}
