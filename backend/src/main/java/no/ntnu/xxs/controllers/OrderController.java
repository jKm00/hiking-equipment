package no.ntnu.xxs.controllers;


import no.ntnu.xxs.entities.Order;
import no.ntnu.xxs.exception.EmptyCartException;
import no.ntnu.xxs.exception.NoSuchOrderException;
import no.ntnu.xxs.security.JwtUtil;
import no.ntnu.xxs.services.OrderService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A controller class for our order entities.
 */
@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {


    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    OrderService orderService;

    /**
     * Returns all orders for the user in the jwt token sent as a header
     *
     * @param authorization the jwt token of the user to get the orders for
     * @return the order
     */
    @GetMapping
    public List<Order> getOrder(@RequestHeader ("Authorization") String authorization) {
        return orderService.getAllOrdersById((long) extractUserIdFromJwt(authorization));
    }

    /**
     * Adds an order to the user with the same id as the one in the jwt token
     *
     * @param authorization the jwt token of the user to add the order for
     * @return HttpStatus.OK order was successfully added to the user or
     * HttpStatus.BAD_REQUEST, the cart we're taking the order from is empty
     */
    @PostMapping
    public ResponseEntity<?> addOrder (@RequestHeader ("Authorization") String authorization) {
        try {
            orderService.addOrder((long) extractUserIdFromJwt(authorization));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyCartException e) {
            return new ResponseEntity<>("cart is empty", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Deletes an order from the user with the same id as the one in the jwt token
     *
     * @param id the id of the order, we want to delete
     * @param authorization the jwt token of the user to delete the order from
     * HttpStatus.OK order was successfully deleted from the user or
     * HttpStatus.BAD_REQUEST, the order we're trying to delete wasn't found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder (@PathVariable Long id, @RequestHeader ("Authorization") String authorization) {
        try {
            orderService.removeOrder(id, (long) extractUserIdFromJwt(authorization));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchOrderException e) {
            return new ResponseEntity<>("No order found that is matching the order id and/ or user id", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Extracts the user id from a jwt token
     *
     * @param authorization the jwt token of the user we want to extract the user id from
     */
    private int extractUserIdFromJwt (String authorization) {
        return jwtUtil.extractId(authorization.substring(7));
    }
}
