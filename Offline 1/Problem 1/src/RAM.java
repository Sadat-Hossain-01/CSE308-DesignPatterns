abstract class RAM extends Component {
}

class RAM2666 extends RAM {

    @Override
    void setType() {
        this.type = "8GB DDR4 RAM (2666 MHz)";
        this.componentPrice = 2620;
    }
}

class RAM3200 extends RAM {

    @Override
    void setType() {
        this.type = "8GB DDR4 RAM (3200 MHz)";
        this.componentPrice = 2950;
    }
}
