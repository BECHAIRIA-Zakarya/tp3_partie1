import static org.mockito.Mockito.*;

import exercice02.Order;
import exercice02.OrderController;
import exercice02.OrderDao;
import exercice02.OrderService;
import org.junit.jupiter.api.Test;

public class OrderControllerTest {

    @Test
    public void testCreateOrder() {
        OrderService orderServiceMock = mock(OrderService.class);
        OrderDao orderDaoMock = mock(OrderDao.class);
        Order order = new Order();

        doNothing().when(orderServiceMock).createOrder(order);

        OrderController orderController = new OrderController(orderServiceMock);
        orderController.createOrder(order);

        verify(orderServiceMock).createOrder(order);
        verify(orderDaoMock).saveOrder(order);
    }
}

