package com.reserva.projeto.repositories;

import com.reserva.projeto.domains.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    Optional<Reserva>  findByNomeSala(String nomeSala);

}
