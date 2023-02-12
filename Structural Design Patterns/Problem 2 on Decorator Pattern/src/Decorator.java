public abstract class Decorator extends Coffee {
    protected Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
        this.name = coffee.name;
        this.ingredients = coffee.ingredients;
    }
}

class ExtraCoffeeBeans extends Decorator {
    public ExtraCoffeeBeans(Coffee coffee) {
        super(coffee);
        ingredients.add("Extra Grinded Coffee Beans");
    }

    public int getCost() {
        return coffee.getCost() + 30;
    }
}

class ExtraMilk extends Decorator {
    public ExtraMilk(Coffee coffee) {
        super(coffee);
        ingredients.add("Milk");
    }

    public int getCost() {
        return coffee.getCost() + 50;
    }
}

class ExtraDairyCream extends Decorator {
    public ExtraDairyCream(Coffee coffee) {
        super(coffee);
        ingredients.add("Dairy Cream");
    }

    public int getCost() {
        return coffee.getCost() + 40;
    }
}

class ExtraCinnamonPowder extends Decorator {
    public ExtraCinnamonPowder(Coffee coffee) {
        super(coffee);
        ingredients.add("Cinnamon Powder");
    }

    public int getCost() {
        return coffee.getCost() + 50;
    }
}

class ExtraChocolateSauce extends Decorator {
    public ExtraChocolateSauce(Coffee coffee) {
        super(coffee);
        ingredients.add("Chocolate Sauce");
    }

    public int getCost() {
        return coffee.getCost() + 60;
    }
}
