package com.example.demo;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class UserService
{
    private  Users users;
    public abstract   Mono<Users> Guardar();
    public abstract Flux<Users> Listar();
    public abstract  Flux<Users> OperacionMono();
    public abstract  Flux<Users> ListarPersonalizado();

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

