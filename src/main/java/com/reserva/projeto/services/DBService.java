package com.reserva.projeto.services;

import com.reserva.projeto.domains.Reserva;
import com.reserva.projeto.domains.Usuario;
import com.reserva.projeto.domains.enums.Status;
import com.reserva.projeto.repositories.ReservaRepository;
import com.reserva.projeto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public void initDB(){
        Usuario usuario1 = new Usuario(null, "Victor", "Victorchicas525@gmail.com", LocalDate.of(2025,2,20), "98965954821" );
        Reserva reserva1 = new Reserva(null, "Sala 1", LocalDate.now(), "A sala é bem grande", Status.PENDENTE, usuario1);



        usuarioRepository.save(usuario1);
        reservaRepository.save(reserva1);
    }



}
