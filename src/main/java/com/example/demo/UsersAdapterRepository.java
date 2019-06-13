package com.example.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsersAdapterRepository {
    Mono<Users> Guardar(Users oTgrcPorcentajeCoincidenciaNombres);
    Flux<Users> Listar();
    Flux<Users> ListaPrueba();
    Flux<Users> ListarById(String nombre);
}
