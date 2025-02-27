package com.reserva.projeto.services;


import com.reserva.projeto.domains.Reserva;
import com.reserva.projeto.domains.Usuario;
import com.reserva.projeto.domains.dtos.ReservaDTO;
import com.reserva.projeto.repositories.ReservaRepository;
import com.reserva.projeto.repositories.UsuarioRepository;

import com.reserva.projeto.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private ReservaRepository reservaRepo;

    public List<ReservaDTO> findAll(){
        return reservaRepo.findAll().stream().map(obj -> new ReservaDTO(obj)).collect(Collectors.toList());
    }

    public Reserva findbyId(Long id){
        Optional<Reserva> obj = reservaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Reserva não encontrada Id:" + id));
    }

    public Reserva findbyNomeSala(String nomeSala){
        Optional<Reserva> obj = reservaRepo.findByNomeSala(nomeSala);
        return obj.orElseThrow(() -> new  ObjectNotFoundException("Reserva não encontrado nomeSala:" + nomeSala));
    }

    public Reserva create(ReservaDTO dto){
        dto.setIdReserva(null);
        validaReserva(dto);
        Reserva obj = new Reserva(dto);
        return reservaRepo.save(obj);
    }

    private void validaReserva(ReservaDTO dto) {
        Optional<Reserva> obj = reservaRepo.findByNomeSala(dto.getNomeSala());
        if (obj.isPresent() && obj.get().getIdReserva() != dto.getIdReserva()) {
            throw new DataIntegrityViolationException("Nome da Sala já cadastrado");
        }


        Optional<Usuario> usuario = usuarioRepo.findById(dto.getUsuario());
        if (!usuario.isPresent()) {
            throw new DataIntegrityViolationException("Usuario - " + dto.getUsuario() + "não esta cadastrado");
        }

    }
        public Reserva update(Long id, ReservaDTO objDto){
            objDto.setIdReserva(id);
            Reserva oldObj = findbyId(id);
            oldObj = new Reserva(objDto);
            validaReserva(objDto);
            return reservaRepo.save(oldObj);
        }

        public void delete(Long id){
            Reserva obj = findbyId(id);
            reservaRepo.deleteById(id);
        }

    }

