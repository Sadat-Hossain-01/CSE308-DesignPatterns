abstract class Component {
    protected int componentPrice;
    protected String type;

    public int getComponentPrice() {
        return componentPrice;
    }

    abstract void setType();

    Component() {
        setType();
    }
}

class HardDisk extends Component {

    @Override
    void setType() {
        this.type = "1 TB HDD";
        this.componentPrice = 0; //since this price is included in base price
    }
}

class Motherboard extends Component {

    @Override
    void setType() {
        this.type = "Default Motherboard";
        this.componentPrice = 0; //since this price is included in base price
    }
}

class DVDDrive extends Component {

    @Override
    void setType() {
        this.type = "DVD Drive";
        this.componentPrice = 6000;
    }
}
