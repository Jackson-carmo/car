package br.com.jackson.Car.services;

import br.com.jackson.Car.models.Car;
import br.com.jackson.Car.models.ResponseModel;
import br.com.jackson.Car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    @Autowired
    private ResponseModel responseModel;

    public List<Car> listar() {
        return repository.findAll();
    }
    public Optional<Car> findById(Long id) {
        return repository.findById(id);
    }
    public ResponseEntity<?> cadastrarAlterar(Car car, String acao) {
            if (car.getNome().equals("")) {
                responseModel.setMensagem("o Nome é brigatorio!");
                return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
            } else if (car.getMarca().equals("")) {
                responseModel.setMensagem("o Nome da Marca é obrigatorio!");
                return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
            }
            else {
                if (acao.equals("cadastrar")){
                    return new ResponseEntity<Car>(repository.save(car), HttpStatus.CREATED);
                }else {
                    return new ResponseEntity<Car>(repository.save(car), HttpStatus.OK);
                }
            }
    }

    public ResponseEntity<ResponseModel> remover(Long id){
            repository.deleteById(id);
            responseModel.setMensagem("O carro foi removido com sucesso!");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
    }
}
