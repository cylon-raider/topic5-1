package com.gcu.topic22.business;

import com.gcu.topic22.model.OrderModel;

import java.util.List;

public interface OrdersBusinessServiceInterface {

    public void test();

    public List<OrderModel> getOrders();

    public OrderModel getOrderById(String id);

    public void init();

    public void destroy();


}
