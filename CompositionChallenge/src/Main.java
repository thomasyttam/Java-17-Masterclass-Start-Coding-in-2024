public class Main {

    public static void main(String[] args) {

        SmartKitchen kitchen = new SmartKitchen();

        kitchen.getDishwasher().setHasWorkToDO(true);
        kitchen.getBrewMaster().setHasWorkToDO(true);
        kitchen.getIceBox().setHasWorkToDO(true);

        kitchen.getDishwasher().doDishes();
        kitchen.getBrewMaster().brewCoffee();
        kitchen.getIceBox().orderFood();

        System.out.println("------------------");

        kitchen.setKitchenState(true, false, true);
        kitchen.doKitchenWork();
    }
}
