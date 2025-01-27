package com.mechanic.workshop.model;

import com.mechanic.workshop.dto.PartRequestDto;
import com.mechanic.workshop.dto.PartResponseDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "parts")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "part_name", nullable = false)
    private String partName;

    @Column(name = "vehicle_brand", nullable = false)
    private String vehicleBrand;

    @Column(name = "vehicle_model", nullable = false)
    private String vehicleModel;

    @Column(name = "vehicle_year", nullable = false)
    private int vehicleYear;

    @Column(name = "unity_price", nullable = false)
    private double unityPrice;

    @Column(name = "quantity", nullable = false)
    private long quantity;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Part() {
    }

    public Part(PartRequestDto data){
        this.partName = data.partName();
        this.vehicleBrand = data.vehicleBrand();
        this.vehicleModel = data.vehicleModel();
        this.vehicleYear = data.vehicleYear();
        this.unityPrice = data.unityPrice();
        this.quantity = data.quantity();
    }

    public Part(PartResponseDto data) {
        this.id = data.id();
        this.partName = data.partName();
        this.vehicleBrand = data.vehicleBrand();
        this.vehicleModel = data.vehicleModel();
        this.vehicleYear = data.vehicleYear();
        this.unityPrice = data.unityPrice();
        this.quantity = data.quantity();
        this.createdAt = data.createdAt();
        this.updatedAt = data.updatedAt();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public double getUnityPrice() {
        return unityPrice;
    }

    public void setUnityPrice(double unityPrice) {
        this.unityPrice = unityPrice;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
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
