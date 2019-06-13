package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple6;

@Service
public class UserServiceImpl extends UserService {

	private UsersAdapterRepository usersRepository;

	@Autowired
	public UserServiceImpl(UsersAdapterRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public Mono<Users> Guardar() {

		Users ss = new Users();
		ss.setApellidos("sdsd");
		ss.setNombres("dsdsdds");
        this.setUsers(ss);
		return   usersRepository.Guardar(ss)
				.map(this::extractConsultaPortalEmpleadorDTOSA);

	}

	@Override
	public Flux<Users> Listar() {
		Flux<Users> f=	usersRepository.Listar().map(this::extractConsultaPortalEmpleadorDTOSA);
		return  f;
	}

	private  Users extractConsultaPortalEmpleadorDTOSA( Users tuple ) {
		/*Extraer dos valores*/
		return tuple;
	}

	@Override
	public Flux<Users> OperacionMono() {
		return usersRepository.ListaPrueba().flatMap(rt->
                usersRepository.ListaPrueba()
                .distinct(dis-> Flux.just(eventDistintos(dis)))
				.concatMap(con -> Flux.just(eventosConcatMap(con)))
				.take(2)
				.concatMap(iit-> Flux.just(EventConcatMap(iit,2)))
				.onErrorResume(it-> Flux.just(eventError(null,it))));
	}

    @Override
    public Flux<Users> ListarPersonalizado() {
        return  usersRepository.ListarById("si");
    }

    public  void RunTupla()
    {
        RespondDTO oDto=new RespondDTO();

    }

    private RespondDTO validateTuple(Tuple6<RespondDTO, RespondDTO, RespondDTO, RespondDTO, RespondDTO, RespondDTO> t) {

        RespondDTO respondDTO = new RespondDTO();
        if (t.getT1().isError())
            respondDTO = t.getT1();
        else if (t.getT2().isError())
            respondDTO = t.getT2();
        else if (t.getT3().isError())
            respondDTO = t.getT3();
        else if (t.getT4().isError())
            respondDTO = t.getT4();
        else if (t.getT5().isError())
            respondDTO = t.getT5();
        else if (t.getT6().isError())
            respondDTO = t.getT6();

        return respondDTO;
    }
	private Users EventConcatMap(Users usuarios,int count)
	{
        System.out.println("nombres"+usuarios.getNombres()+count);
		return  usuarios;
	}

	private Users eventSuccess(Users solicitud)
	{
		System.out.println("nombres"+solicitud.getNombres());
		System.out.println("apellidos"+solicitud.getApellidos());
		return  solicitud;
	}

	private Users eventDistintos(Users solicitud)
	{	System.out.println("nombres"+solicitud.getNombres());
		System.out.println("apellidos"+solicitud.getApellidos());
		return  solicitud;
	}

	private Users eventosConcatMap(Users solicitud)
	{	System.out.println("nombres"+solicitud.getNombres());
		System.out.println("apellidos"+solicitud.getApellidos());
		return  solicitud;
	}

	private Users eventError(Users solicitud, Throwable... t)
	{	System.out.println("nombres"+solicitud.getNombres());
		System.out.println("apellidos"+solicitud.getApellidos());
		return  solicitud;
	}
}
