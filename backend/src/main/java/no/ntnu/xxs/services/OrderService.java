package no.ntnu.xxs.services;

import no.ntnu.xxs.entities.Order;
import no.ntnu.xxs.entities.OrderItem;
import no.ntnu.xxs.entities.cart.Cart;
import no.ntnu.xxs.entities.cart.CartItem;
import no.ntnu.xxs.entities.user.User;
import no.ntnu.xxs.exception.EmptyCartException;
import no.ntnu.xxs.exception.NoSuchOrderException;
import no.ntnu.xxs.repositories.CartItemRepository;
import no.ntnu.xxs.repositories.OrderItemRepository;
import no.ntnu.xxs.repositories.OrderRepository;
import no.ntnu.xxs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The a service claas for order entities.
 */
@Service
public class OrderService {

    /**
     * The Order repository.
     */
    @Autowired
    OrderRepository orderRepository;

    /**
     * The Cart service.
     */
    @Autowired
    CartService cartService;

    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * The Order item repository.
     */
    @Autowired
    OrderItemRepository orderItemRepository;

    /**
     * The Cart item repository.
     */
    @Autowired
    CartItemRepository cartItemRepository;

    /**
     * The Access user service.
     */
    @Autowired
    AccessUserService accessUserService;

    /**
     * Returns all orders for the user with id given as param
     *
     * @param id the id of the user to find the orders for
     * @return one or more orders or null if no cart is found
     */
    public List<Order> getAllOrdersById(Long id) {
        return orderRepository.findAllOrdersByUserId(id);
    }


    /**
     * Takes the info of a cart by using the user's id and makes an order out of said information
     * @param id the user id of the user to create an order for
     * @throws EmptyCartException an exception thrown if the cart is empty
     */
    public void addOrder(Long id) throws EmptyCartException {
        //gets the cart
        Cart cart = cartService.getCart(id);
        //gets the user
        User user = accessUserService.getUser(id);
        //checks if the cart is epmty
        if (cart.getCartItems().size() == 0) {
            throw new EmptyCartException("Can't create an order if the cart is empty");
        }
        //creates an order and assigns a user to it using the given id
        Order order = new Order();
        order.setUser(user);
        orderRepository.save(order);
        float totalPrice = 0;
        //iterates through the cart getting cart items
        for (CartItem cartItem : cart.getCartItems()) {
            // uses the information from the cart item to create a new order item entity
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
            //calculates the sum of all the prices of the order items in the order
            totalPrice += (cartItem.getProductPrice() * (1 - cartItem.getDiscount()/100) * cartItem.getQuantity());
            // adds the order item to the order
            order.addOrderItem(orderItem);
            cartItemRepository.delete(cartItem);

        }
        //sets the total price of the order
        order.setTotalPrice(totalPrice);
        //sets the status of the order
        order.initializeStatus();
        //saves the order entity
        orderRepository.save(order);
        //adds a user to the order
        user.addOrder(order);
        //empties the cart we used
        cart.emptyCart();
        //saves the user entity
        userRepository.save(user);
    }

    /**
     * Removes and order using the order's id and the user's id
     *
     * @param orderId the id of the order we wish to delete
     * @param userId  the id of the user which the order belongs to
     * @throws NoSuchOrderException the no such order exception
     */
    public void removeOrder(Long orderId, Long userId) throws NoSuchOrderException {
        Optional<Order> result = orderRepository.findOrderByIdAndUserId(orderId, userId);
        if (result.isEmpty()) {
            throw new NoSuchOrderException("No order found that is matching the order id and/ or user id");
        }
        Order order = result.get();
        for (OrderItem orderItem : order.getOrderItems()) {
            orderItemRepository.delete(orderItem);
        }
        orderRepository.delete(order);
    }
}
