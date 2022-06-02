package com.example.carproject.repository;

import com.example.carproject.entity.Car;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;




@Repository
public interface CarRepo extends JpaRepository<Car, Long> {


}
