package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long>
{
    @Query("SELECT u.nombres as Nombres,u.apellidos as Apellidos,c.nombres as Ciudad" +
            " FROM Users u " +
            "JOIN Ciudad c " +
            "on u.idciudad=c.id " +
            "WHERE u.nombres =:nombres")
    public List<Users> listarEmpleadosPersonalizado(@Param("nombres") String nombres);

}
