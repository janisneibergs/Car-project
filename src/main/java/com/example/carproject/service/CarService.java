package com.example.carproject.service;

import com.example.carproject.entity.Car;
import com.example.carproject.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepo carRepo;

    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public Iterable<Car> list() {
return carRepo.findAll();
    }

    public Car save(Car car){
        return carRepo.save(car);
    }


public Iterable<Car> save(List<Car> car){
        return carRepo.saveAll(car);
}
}
