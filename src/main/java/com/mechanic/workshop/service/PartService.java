package com.mechanic.workshop.service;

import com.mechanic.workshop.dto.PartRequestDto;
import com.mechanic.workshop.dto.PartResponseDto;
import com.mechanic.workshop.exception.BadRequestException;
import com.mechanic.workshop.model.Part;
import com.mechanic.workshop.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PartService {

    @Autowired
    private PartRepository partRepository;

    public Part createPart(PartRequestDto payload){
        System.out.println(payload);
        if(payload.partName().isBlank()){
            throw new BadRequestException("O campo nome nao pode estar vazio");
        }
        Part newPart = new Part(payload);

        this.partRepository.save(newPart);

        return newPart;
    }

    public PartResponseDto getPart(long id){
        Optional<Part> part = this.partRepository.findById(id);
        if(part.isPresent()){
            return new PartResponseDto(part.get().getId(), part.get().getPartName(), part.get().getVehicleBrand(),
                    part.get().getVehicleModel(), part.get().getVehicleYear(),part.get().getUnityPrice(),
                    part.get().getQuantity(), part.get().getCreatedAt(), part.get().getUpdatedAt());
        }
        throw new BadRequestException("Peça nao encontrada");
    }

    public List<PartResponseDto> getParts(){
        return this.partRepository.findAll().stream().map(part -> new PartResponseDto(part.getId(),
                part.getPartName(), part.getVehicleBrand(), part.getVehicleModel(), part.getVehicleYear(),
                part.getUnityPrice(), part.getQuantity(), part.getCreatedAt(), part.getUpdatedAt())).toList();
    }

    public long updatePart(long id, PartRequestDto payload){
        Optional<Part> part = this.partRepository.findById(id);
        if(part.isPresent()){
            Part rawPart = part.get();

            if(payload.partName() != null && !payload.partName().isBlank()){
                rawPart.setPartName(payload.partName());
            }
            if(payload.vehicleBrand() != null && !payload.vehicleBrand().isBlank()){
                rawPart.setVehicleBrand(payload.vehicleBrand());
            }
            if(payload.vehicleModel() != null && !payload.vehicleModel().isBlank()){
                rawPart.setVehicleModel(payload.vehicleModel());
            }
            if(payload.vehicleYear() <= 0){
                rawPart.setVehicleYear(payload.vehicleYear());
            }
            if(payload.unityPrice() < 0){
                rawPart.setUnityPrice(payload.unityPrice());
            }
            if(payload.quantity() < 0){
                rawPart.setQuantity(payload.quantity());
            }

            this.partRepository.save(rawPart);
            return id;
        }
        throw new BadRequestException("Peça nao encontrada");
    }

    public long deletePart(long id){
        Optional<Part> part = this.partRepository.findById(id);
        if(part.isPresent()){
            this.partRepository.delete(part.get());
            return id;
        }
        throw new BadRequestException("Peça nao encontrada");
    }
}
