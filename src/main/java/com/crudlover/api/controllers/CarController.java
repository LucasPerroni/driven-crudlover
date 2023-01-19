package com.crudlover.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlover.api.DTO.CarDTO;
import com.crudlover.api.models.Car;
import com.crudlover.api.repository.CarRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarRepository repository;

    @PostMapping
    public void createCar(@RequestBody @Valid CarDTO req) {
        repository.save(new Car(req));
    }

    @GetMapping
    public List<Car> getAllCars() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody @Valid CarDTO req) {
        repository.findById(id).map(car -> {
            car.setAnoModelo(req.anoModelo());
            car.setDataFabricacao(req.dataFabricacao());
            car.setFabricante(req.fabricante());
            car.setModelo(req.modelo());
            car.setValor(req.valor());
            return repository.save(car);
        });
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
