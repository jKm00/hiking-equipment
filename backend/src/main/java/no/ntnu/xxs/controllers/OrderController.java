package no.ntnu.xxs.controllers;


import no.ntnu.xxs.entities.Order;
import no.ntnu.xxs.security.JwtUtil;
import no.ntnu.xxs.services.OrderService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
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
        
    }

    private int extractUserIdFromJwt (String authorization) {
        return jwtUtil.extractId(authorization.substring(7));
    }
}
