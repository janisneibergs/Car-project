package com.example.carproject;

import com.example.carproject.configuration.CarJpaConfig;
import com.example.carproject.entity.Car;
import com.example.carproject.repository.CarRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { CarJpaConfig.class },
        loader = AnnotationConfigContextLoader.class)

@Transactional
public class InMemoryDBTest {

    @Resource
    private CarRepo carRepo;

    @Test
    public void givenCar_whenSave_thenGetOk() {
        Car car = new Car(1L, "Audi", "A5", "2007", "hjasdgyu6dshj", "Gr564" );
        carRepo.save(car);

        Car car2 = carRepo.getReferenceById(1L);
        assertEquals("Audi", car2.getMake());
    }
}
