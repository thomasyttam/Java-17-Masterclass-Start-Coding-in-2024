public class SmartKitchen {

    private CoffeeMaker brewMaster;
    private Dishwasher dishwasher;
    private Refrigerator iceBox;

    public SmartKitchen() {
        brewMaster = new CoffeeMaker();
        dishwasher = new Dishwasher();
        iceBox = new Refrigerator();
    }

    public CoffeeMaker getBrewMaster() {
        return brewMaster;
    }

    public Dishwasher getDishwasher() {
        return dishwasher;
    }

    public Refrigerator getIceBox() {
        return iceBox;
    }

//    public void addWater() {
//        brewMaster.hasWorkToDo() = true;
//    }
//
//    public void pourMilk() {
//        iceBox.hasWorkToDo = true;
//    }
//
//    public void loadDishwasher() {
//        dishwasher.hasWorkToDo = true;
//    }
//
    public void setKitchenState(boolean coffee, boolean ice, boolean dish) {
        brewMaster.setHasWorkToDO(coffee);
        iceBox.setHasWorkToDO(ice);
        dishwasher.setHasWorkToDO(dish);
    }

    public void doKitchenWork() {
        brewMaster.brewCoffee();
        iceBox.orderFood();
        dishwasher.doDishes();
    }
}

class CoffeeMaker {
    private boolean hasWorkToDO;

    public void setHasWorkToDO(boolean hasWorkToDO) {
        this.hasWorkToDO = hasWorkToDO;
    }

    public void brewCoffee() {
        if (hasWorkToDO) {
            System.out.println("Brewing Coffee");
            hasWorkToDO = false;
        }
    }
}

class Dishwasher {
    private boolean hasWorkToDO;

    public void setHasWorkToDO(boolean hasWorkToDO) {
        this.hasWorkToDO = hasWorkToDO;
    }

    public void doDishes() {
        if (hasWorkToDO) {
            System.out.println("Washing Dishes");
            hasWorkToDO = false;
        }
    }
}

class Refrigerator {
    private boolean hasWorkToDO;

    public void setHasWorkToDO(boolean hasWorkToDO) {
        this.hasWorkToDO = hasWorkToDO;
    }

    public void orderFood() {
        if (hasWorkToDO) {
            System.out.println("Ordering Food");
            hasWorkToDO = false;
        }
    }
}