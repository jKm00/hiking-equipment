package no.ntnu.xxs.services;

import no.ntnu.xxs.entities.Order;
import no.ntnu.xxs.entities.OrderItem;
import no.ntnu.xxs.entities.cart.Cart;
import no.ntnu.xxs.entities.cart.CartItem;
import no.ntnu.xxs.entities.user.User;
import no.ntnu.xxs.exception.EmptyCartException;
import no.ntnu.xxs.repositories.CartItemRepository;
import no.ntnu.xxs.repositories.OrderItemRepository;
import no.ntnu.xxs.repositories.OrderRepository;
import no.ntnu.xxs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartService cartService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    AccessUserService accessUserService;

    public List<Order> getAllOrdersById(Long id) {
        return orderRepository.findAllOrdersByUserId(id);
    }

    public void addOrder(Long id) throws EmptyCartException {
        Cart cart = cartService.getCart(id);
        User user = accessUserService.getUser(id);
        if (cart.getCartItems().size() == 0) {
            throw new EmptyCartException("Can't create an order if the cart is empty");
        }
        Order order = new Order();
        order.setUser(user);
        orderRepository.save(order);
        float totalPrice = 0;
        for (CartItem cartItem : cart.getCartItems()) {
            OrderItem orderItem = new OrderItem(cartItem.getProductId(),
                    cartItem.getProductName(),
                    cartItem.getProductPrice(),
                    cartItem.getProductCategory(),
                    cartItem.getProductSex(),
                    cartItem.getDiscount(),
                    cartItem.getColor(),
                    cartItem.getSize(),
                    cartItem.getQuantity());
            orderItem.setOrder(order);
            orderItemRepository.save(orderItem);
            totalPrice += (cartItem.getProductPrice() * (1 - cartItem.getDiscount()/100) * cartItem.getQuantity());
            order.addOrderItem(orderItem);
            cartItemRepository.delete(cartItem);

        }
        order.setTotalPrice(totalPrice);
        order.initializeStatus();
        orderRepository.save(order);
        user.addOrder(order);
        cart.emptyCart();
        userRepository.save(user);
    }

}
