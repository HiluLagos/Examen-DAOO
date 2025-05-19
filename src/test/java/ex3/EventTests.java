package ex3;

import ex3.event.Cancellation;
import ex3.event.DeliveryIssue;
import ex3.event.Event;
import ex3.event.PurchaseItem;
import ex3.handler.GenericHandler;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventTests {

    @Test
    public void purchaseEventHandlerHandlerHandlesPurchaseEvent_01() {
        // Capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            List<String> products = new ArrayList<>();
            products.add("Apple");
            products.add("Banana");
            Event event = new PurchaseItem(1, 1, products, "Buenos Aires", "card");
            GenericHandler hanGen = new GenericHandler();
            hanGen.handle(event);

            // Assert console output
            String output = outputStream.toString();
            assertTrue(output.contains("Purchased: [Apple, Banana]---> With method:card"));
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }
    }

    @Test
    public void CancellationEventHandlerHandlesCancellationEvent_02() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Event event = new Cancellation(1, 5, "Didn't like it", "Customer");
            GenericHandler hanGen = new GenericHandler();
            hanGen.handle(event);

            String output = outputStream.toString();
            assertTrue(output.contains("Cancelation of purchase id:5 Done with reason: Didn't like it---> By solicitant: Customer"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void DeliveryIssueCanHandleIssues_03() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Event event = new DeliveryIssue(1, 10, 5.3, "Truck ran out of fuel", "La Plata");
            GenericHandler hanGen = new GenericHandler();
            hanGen.handle(event);

            String output = outputStream.toString();
            assertTrue(output.contains("Issue: Truck ran out of fuel occurred at La Plata"));
        } finally {
            System.setOut(originalOut);
        }
    }
}