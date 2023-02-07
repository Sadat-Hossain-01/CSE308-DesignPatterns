public abstract class Decorator extends Coffee {
}

class ExtraCoffeeBeans extends Decorator {
    private Coffee coffee;

    public ExtraCoffeeBeans(Coffee coffee) {
        this.coffee = coffee;
        this.name = coffee.name;
        this.ingredients = coffee.ingredients;
        this.ingredients.add("Ground Coffee Beans");
    }

    public int getCost() {
        return coffee.getCost() + 30;
    }
}

class ExtraMilk extends Decorator {
    private Coffee coffee;

    public ExtraMilk(Coffee coffee) {
        this.coffee = coffee;
        this.name = coffee.name;
        this.ingredients = coffee.ingredients;
        this.ingredients.add("Milk");
    }

    public int getCost() {
        return coffee.getCost() + 50;
    }
}

class ExtraDairyCream extends Decorator {
    private Coffee coffee;

    public ExtraDairyCream(Coffee coffee) {
        this.coffee = coffee;
        this.name = coffee.name;
        this.ingredients = coffee.ingredients;
        this.ingredients.add("Dairy Cream");
    }

    public int getCost() {
        return coffee.getCost() + 40;
    }
}

class ExtraCinnamonPowder extends Decorator {
    private Coffee coffee;

    public ExtraCinnamonPowder(Coffee coffee) {
        this.coffee = coffee;
        this.name = coffee.name;
        this.ingredients = coffee.ingredients;
        this.ingredients.add("Cinnamon Powder");
    }

    public int getCost() {
        return coffee.getCost() + 50;
    }
}

class ExtraChocolateSauce extends Decorator {
    private Coffee coffee;

    public ExtraChocolateSauce(Coffee coffee) {
        this.coffee = coffee;
        this.name = coffee.name;
        this.ingredients = coffee.ingredients;
        this.ingredients.add("Chocolate Sauce");
    }

    public int getCost() {
        return coffee.getCost() + 60;
    }
}
