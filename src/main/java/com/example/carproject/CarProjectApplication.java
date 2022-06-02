package com.example.carproject;


import com.example.carproject.entity.Car;

import com.example.carproject.service.CarService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@SpringBootApplication
@EnableSwagger2
public class CarProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CarService carService){
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Car>> typeReference = new TypeReference<>() {};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/cars.json");
            try {
                List<Car> cars = mapper.readValue(inputStream,typeReference);
                carService.save(cars);
                System.out.println("Car added");
            } catch (IOException e){
                System.out.println("Unable add car: " + e.getMessage());
            }
        };
    }
//    @Bean
//
//        public Docket api() {
//            return new Docket(DocumentationType.SWAGGER_2)
//                    .select()
//                    .apis(RequestHandlerSelectors.any())
//                    .paths(PathSelectors.any())
//                    .build();
//        }


}
