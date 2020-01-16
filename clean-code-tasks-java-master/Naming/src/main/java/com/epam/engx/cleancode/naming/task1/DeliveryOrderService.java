package com.epam.engx.cleancode.naming.task1;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.*;

import java.util.List;

public class DeliveryOrderService implements OrderService {

    private DeliveryService derliveryService;

    private OrderFulfilmentService orderFulfilmentService;

    public void submitOrder(Order order) {
        if (derliveryService.isDeliverable()) {
            List<Product> products = order.getProducts();
            orderFulfilmentService.fulfilProducts(products);
        } else {
            throw new NotDeliverableOrderException();
        }
    }

    public void setDeliveryService(DeliveryService deliveryService) {
        this.derliveryService = deliveryService;
    }

    public void setOrderFulfilmentService(OrderFulfilmentService pOrderFulfilmentService) {
        this.orderFulfilmentService = pOrderFulfilmentService;
    }
}
