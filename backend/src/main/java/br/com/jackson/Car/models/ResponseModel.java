package br.com.jackson.Car.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ResponseModel {

    private String mensagem;
}
