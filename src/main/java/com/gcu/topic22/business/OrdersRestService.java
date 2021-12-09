package com.gcu.topic22.business;

import com.gcu.topic22.model.OrderModel;
import com.gcu.topic22.model.OrdersList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service")
public class OrdersRestService
{
    @Autowired
    public OrdersBusinessServiceInterface service;

    @GetMapping(path="/getJson", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<OrderModel> getOrdersAsJson()
    {
        return service.getOrders();
    }

    @GetMapping(path="/getXml", produces={MediaType.APPLICATION_XML_VALUE})
    public OrdersList getOrdersAsXml()
    {
        OrdersList ordersList = new OrdersList();
        ordersList.setOrders(service.getOrders());
        return ordersList;
    }
}
