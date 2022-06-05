package no.ntnu.xxs.controllers;


import no.ntnu.xxs.entities.Order;
import no.ntnu.xxs.exception.EmptyCartException;
import no.ntnu.xxs.security.JwtUtil;
import no.ntnu.xxs.services.OrderService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {


    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    OrderService orderService;

    @GetMapping
    public List<Order> getOrder(@RequestHeader ("Authorization") String authorization) {
        return orderService.getAllOrdersById((long) extractUserIdFromJwt(authorization));
    }

    @PostMapping
    public ResponseEntity<?> addOrder (@RequestHeader ("Authorization") String authorization) {
        try {
            orderService.addOrder((long) extractUserIdFromJwt(authorization));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyCartException e) {
            return new ResponseEntity<>("cart is empty", HttpStatus.BAD_REQUEST);
        }
    }

    private int extractUserIdFromJwt (String authorization) {
        return jwtUtil.extractId(authorization.substring(7));
    }
}
