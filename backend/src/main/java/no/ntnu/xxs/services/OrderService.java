package no.ntnu.xxs.services;

import no.ntnu.xxs.entities.Order;
import no.ntnu.xxs.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrdersById(Long id) {
        return orderRepository.findAllOrdersByUserId(id);
    }

}
