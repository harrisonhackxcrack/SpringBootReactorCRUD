package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class UsersAdapterRepositoryImp extends ReactiveAdapter<Users> implements UsersAdapterRepository {
    private UsersRepository oPorcentajeCoincidenciaNombresAdapterRepository;

    @Autowired
    public UsersAdapterRepositoryImp(UsersRepository oPorcentajeCoincidenciaNombresAdapterRepository) {
        super(oPorcentajeCoincidenciaNombresAdapterRepository);
        this.oPorcentajeCoincidenciaNombresAdapterRepository = oPorcentajeCoincidenciaNombresAdapterRepository;
    }

    @Override
    public Mono<Users> Guardar(Users oTgrcPorcentajeCoincidenciaNombres) {
        return Mono.fromCallable(() ->
                oPorcentajeCoincidenciaNombresAdapterRepository.save(oTgrcPorcentajeCoincidenciaNombres)
        );
    }

    @Override
    public Flux<Users> Listar() {
        return Flux.fromIterable(oPorcentajeCoincidenciaNombresAdapterRepository.findAll());
    }

    @Override
    public Flux<Users> ListaPrueba() {
        return Flux.fromIterable(oPorcentajeCoincidenciaNombresAdapterRepository.findAll());
    }

    @Override
    public Flux<Users> ListarById(String nombre)
    {
        return  Flux.fromIterable(oPorcentajeCoincidenciaNombresAdapterRepository.listarEmpleadosPersonalizado(nombre));
    }
}
