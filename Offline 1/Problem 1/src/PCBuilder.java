import java.util.ArrayList;

class PCBuilder {
    private int totalPrice;
    private ArrayList<RAM> ramList;
    private ArrayList<GraphicsCard> gCardList;

    void addRAM(int frequency) {
        RAM r = null;

        if (frequency == 2666) {
            r = new RAM2666();
        } else if (frequency == 3200) {
            r = new RAM3200();
        }

        if (r != null) {
            ramList.add(r);
            totalPrice += r.price;
        }
    }

    void addGraphicsCard(int memory) {
        GraphicsCard g = null;

        if (memory == 2) {
            g = new GCard2();
        } else if (memory == 4) {
            g = new GCard4();
        }

        if (g != null) {
            gCardList.add(g);
            totalPrice += g.price;
        }
    }

}

