package com.example.carproject.controller;

import com.example.carproject.entity.Car;

import com.example.carproject.repository.CarRepo;
import com.example.carproject.service.CarService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    CarRepo carRepo;

    @RequestMapping(value = "/car/custom", method = RequestMethod.POST)
    public String custom() {
        return "custom";
    }

    @GetMapping(value = "/car/listjson")
    public Iterable<Car> list(){
        return carService.list();
    }

    @GetMapping(value = "/car/{carId}")
    public ResponseEntity<Car> getCar(@PathVariable Long carId){
        Optional<Car> car = carRepo.findById(carId);

        if (car.isPresent()) {
            return new ResponseEntity<>(car.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/car")
    public ResponseEntity<Car> saveCar(@RequestBody Car car){
        try {
            return new ResponseEntity<>(carRepo.save(car), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/car")
    public ResponseEntity<Car> updateCar(@RequestBody Car car){
        try {
            return new ResponseEntity<>(carRepo.save(car), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("car/{carId}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable Long carId){
        try {
            Optional<Car> customer = carRepo.findById(carId);
            if (customer.isPresent()) {
                carRepo.delete(customer.get());
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    }

