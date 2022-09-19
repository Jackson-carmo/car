package br.com.jackson.Car.controllers;

import br.com.jackson.Car.models.Car;
import br.com.jackson.Car.models.ResponseModel;
import br.com.jackson.Car.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class CarController {

    @Autowired
    private CarService service;

    @GetMapping("/listar")
    public List<Car> listar(){
        return service.listar();
    }

    @GetMapping("listar/{id}")
    public ResponseEntity<Object> getOneCar(@PathVariable(value = "id") Long id){
        Optional<Car> carOptional = service.findById(id);
        if (!carOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro nao encontrado!.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(carOptional.get());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Car car){
        return service.cadastrarAlterar(car, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Car car){
        return service.cadastrarAlterar(car, "alterar");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<ResponseModel> remover(@PathVariable Long id) {
        return service.remover(id);
    }
}
