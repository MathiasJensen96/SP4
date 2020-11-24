import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class OrderTest {
    @Test
    public void OrderTest_addOrder_verifyNewOrder() {
        Main.mariosSystem = new MariosSystem();
        Main.menu = new Menu();
        //Main.mariosSystem.step2 = new ArrayList<>();
        Assert.assertEquals(0, Main.mariosSystem.activeOrders.size());
        Main.mariosSystem.activeOrders.add(Main.menu.temps.get(3));
        Order order = new Order();
        order.addOrder();
        Assert.assertEquals(1, Main.mariosSystem.activeOrders.size());
    }
}