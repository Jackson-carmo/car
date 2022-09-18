package br.com.jackson.Car.services;

import br.com.jackson.Car.models.Car;
import br.com.jackson.Car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    public List<Car> listar() {
        return repository.findAll();
    }
}
