package com.mechanic.workshop.controller;

import com.mechanic.workshop.dto.OrderRequestDto;
import com.mechanic.workshop.dto.OrderResponseDto;
import com.mechanic.workshop.model.Order;
import com.mechanic.workshop.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private OrderService orderService;

    public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDto payload){

        Order newOrder = this.orderService.createOrder(payload);

        return ResponseEntity.status(HttpStatus.OK).body(newOrder);
    }

    public ResponseEntity<OrderResponseDto> listOrder(@PathVariable long id){
        OrderResponseDto order = this.orderService.listOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    public ResponseEntity<OrderResponseDto> listOrderByUserId(@PathVariable long id){
        return null;
    }

    public ResponseEntity<List<OrderResponseDto>> listOrders(){
        List<OrderResponseDto> orders = this.orderService.listOrders();
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    public ResponseEntity<Long> updateOrder(@PathVariable long id, @RequestBody OrderRequestDto payload){
        long orderId = this.orderService.updateOrder(id, payload);
        return ResponseEntity.status(HttpStatus.OK).body(orderId);
    }

    public ResponseEntity<Long> deleteOrder(@PathVariable long id){
        long orderId = this.orderService.deleteOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderId);
    }

}
