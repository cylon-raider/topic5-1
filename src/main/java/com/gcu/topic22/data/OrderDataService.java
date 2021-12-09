package com.gcu.topic22.data;

import com.gcu.topic22.data.entity.OrderEntity;
import com.gcu.topic22.data.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity> {

    @Autowired
    private OrdersRepository ordersRepository;

    /**
     * Non-default constructor for constructor injection
     */

    public OrderDataService(OrdersRepository ordersRepository)
    {
        this.ordersRepository = ordersRepository;
    }

    /**
     * CRUD: finder to return all entities
     */

    public List findAll()
    {
        List<OrderEntity> orders = new ArrayList<>();

        try
        {
            // Get all Entity Orders
            Iterable<OrderEntity> orderEntities = ordersRepository.findAll();

            // Convert to a List and return the List

            orderEntities.forEach(orders::add);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        // Return the List
        return orders;
    }

    /**
     * CRUD: finder to return a single entity
     */

    public OrderEntity findById(int id) {
        return null;
    }

    /**
     * CRUD: Create an entity
     */

    public boolean create(OrderEntity order)
    {
        try
        {
            this.ordersRepository.save(order);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(OrderEntity order)
    {
        return true;
    }


    public boolean delete(OrderEntity order)
    {
        return true;
    }

}

