package com.mechanic.workshop.model;

import com.mechanic.workshop.dto.OrderRequestDto;
import com.mechanic.workshop.dto.OrderResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double workforce;

    @OneToOne
    @JoinColumn(name = "part_id", nullable = false)
    private Part part;

    @Column(name = "part_amount")
    private int partAmount;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "status", nullable = false)
    private boolean status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Order() {
    }

    public Order(OrderRequestDto data) {
        this.description = data.description();
        this.workforce = data.workforce();
        this.part = data.part();
        this.partAmount = data.partAmount();
        this.user = data.user();
        this.status = data.status();
    }

    public Order(OrderResponseDto data) {
        this.id = data.id();
        this.description = data.description();
        this.workforce = data.workforce();
        this.part = data.part();
        this.partAmount = data.partAmount();
        this.user = data.user();
        this.status = data.status();
        this.createdAt = data.createdAt();
        this.updatedAt = data.updatedAt();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWorkforce() {
        return workforce;
    }

    public void setWorkforce(double workforce) {
        this.workforce = workforce;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public int getPartAmount() {
        return partAmount;
    }

    public void setPartAmount(int partAmount) {
        this.partAmount = partAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
