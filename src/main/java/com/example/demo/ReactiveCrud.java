package com.example.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveCrud<T> {
    Flux<T> all();

    Mono<T> byId(long var1);

    Mono<T> save(T var1);

    Mono<T> update(T var1);

    Mono<Void> delete(long var1);
}