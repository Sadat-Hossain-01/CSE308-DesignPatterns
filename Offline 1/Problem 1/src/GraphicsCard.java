abstract class GraphicsCard extends Component {

}

class GCard2 extends GraphicsCard {

    @Override
    void setType() {
        this.type = "2 GB";
        this.componentPrice = 6500;
    }
}

class GCard4 extends GraphicsCard {

    @Override
    void setType() {
        this.type = "4 GB";
        this.componentPrice = 7600;
    }
}
