
import java.util.*;

public class DeliveryTime {

    private final Random random;

    public DeliveryTime() {
        random = new Random();
    }

    public String getRandomDeliveryTime() {
        int deliveryTimeInMinutes = 30 + random.nextInt(151);
        int minutes = deliveryTimeInMinutes % 60;

        return String.format("Estimated delivery time: %d minutes.", minutes);
    }
}
