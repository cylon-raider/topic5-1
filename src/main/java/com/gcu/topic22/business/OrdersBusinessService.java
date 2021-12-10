package com.gcu.topic22.business;

import com.gcu.topic22.data.OrderDataService;
import com.gcu.topic22.data.entity.OrderEntity;
import com.gcu.topic22.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OrdersBusinessService implements OrdersBusinessServiceInterface
{

    @Autowired
    private OrderDataService service;

    @Override
    public void test()
    {
        System.out.println("Hello from the OrdersBusinessServiceInterface");
    }

    @Override
    public OrderModel getOrderById(String id)
    {
        // Get the Entity Order
        OrderEntity orderEntity = service.findById(id);

        // Convert Entity Order to Domain Order
        return new OrderModel(orderEntity.getId(), orderEntity.getOrderNo(), orderEntity.getProductName(), orderEntity.getPrice(), orderEntity.getQuantity());
    }

    @Override
    public List<OrderModel> getOrders()
    {
        // Get all the Entity Orders
        List<OrderEntity> ordersEntity = service.findAll();

        // Iterate over the Entity Orders and create a list of Domain Orders
        List<OrderModel> ordersDomain = new ArrayList<>();
        for(OrderEntity entity:ordersEntity)
        {
            ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
        }

        // Return list of Domain Orders
        return ordersDomain;
    }

    @Override
    public void init()
    {
        System.out.println("Hello from init()!");
    }

    @Override
    public void destroy()
    {
        System.out.println("Hello from destroy()!");
    }

}

