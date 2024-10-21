
public class Flower extends Order {

    //child class for flower order
    public Flower() {
        super();
        FlowerMenu();
    }

    private void FlowerMenu() {
        add("Rose", 100, 1);
        add("Lily", 150, 1);
        add("Sunflower", 200, 1);
        add("Azalea", 300, 1);
        add("Daisy", 400, 1);
        add("Carnation", 102, 1);
        add("Marigold", 153, 1);
        add("l=Lavender", 223, 1);
        add("Iris", 300, 1);
        add("Anemone", 500, 1);
    }
}
