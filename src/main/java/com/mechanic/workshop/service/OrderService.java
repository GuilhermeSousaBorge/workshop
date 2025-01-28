package com.mechanic.workshop.service;

import com.mechanic.workshop.dto.OrderRequestDto;
import com.mechanic.workshop.dto.OrderResponseDto;
import com.mechanic.workshop.exception.BadRequestException;
import com.mechanic.workshop.model.Order;
import com.mechanic.workshop.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public Order createOrder(OrderRequestDto payload){
        Order newOrder = new Order(payload);

        this.orderRepository.save(newOrder);

        return newOrder;
    }

    public OrderResponseDto listOrder(long id){
        Optional<Order> order = this.orderRepository.findById(id);
        if(order.isPresent()){
            return new OrderResponseDto(order.get().getId(), order.get().getDescription(), order.get().getWorkforce(),
                    order.get().getPart(), order.get().getPartAmount(), order.get().getUser(), order.get().isStatus(), order.get().getCreatedAt(),
                    order.get().getUpdatedAt());
        }
        throw new BadRequestException("Orçamento nao encontrado");
    }

    public List<OrderResponseDto> listOrders(){
        return this.orderRepository.findAll().stream().map(order -> new OrderResponseDto(
                order.getId(), order.getDescription(), order.getWorkforce(), order.getPart(), order.getPartAmount(),
                order.getUser(), order.isStatus(), order.getCreatedAt(), order.getUpdatedAt()
        )).toList();
    }

    public long updateOrder(long id, OrderRequestDto payload){
        Optional<Order> order = this.orderRepository.findById(id);

        if(order.isPresent()){
            Order rawOrder = order.get();
            if(payload.description() != null){
                rawOrder.setDescription(payload.description());
            }
            rawOrder.setPart(payload.part());
            rawOrder.setWorkforce(payload.workforce());
            rawOrder.setStatus(payload.status());
            rawOrder.setPartAmount(payload.partAmount());
            return id;
        }
        throw new BadRequestException("Orçamento nao encontrado");
    }

    public long deleteOrder(long id){
        Optional<Order> order = this.orderRepository.findById(id);

        if(order.isPresent()){
            this.orderRepository.delete(order.get());
            return id;
        }
        throw new BadRequestException("Orçamento nao encontrado");
    }
}
