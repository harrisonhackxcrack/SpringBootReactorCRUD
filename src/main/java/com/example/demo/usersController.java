package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class usersController 
{
     private UserService repositorio;

     @Autowired
	 public usersController(UserService repositorio,UsersAdapterRepositoryImp oImple)
	 {
		 this.repositorio=repositorio;
	 }
	 
	 @GetMapping("/listar")
	 public Flux<Users> getAllUsers()
	 {
		 return repositorio.Listar();
	 }

	 @GetMapping("/listp")
	 public Flux<Users> getQueryPersonalizate()
     {
         return  repositorio.ListarPersonalizado();
     }

	@GetMapping("/monolistar")
	public Flux<Users> getAllUsersA()
	{
		return repositorio.OperacionMono();
	}

	@GetMapping("/guardar")
	public Mono<Users> guardar()
	{
		return repositorio.Guardar();
	}
}
