package com.reserva.projeto.services;

import com.reserva.projeto.domains.Usuario;
import com.reserva.projeto.domains.dtos.UsuarioDTO;
import com.reserva.projeto.repositories.UsuarioRepository;
import com.reserva.projeto.services.exceptions.DataIntegrityViolationException;
import com.reserva.projeto.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> findAll(){
        return  usuarioRepository.findAll().stream().map(obj -> new UsuarioDTO(obj)). collect(Collectors.toUnmodifiableList());
    }

    public Usuario findbyId(int id){
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado Id :" + id));
    }

    public Usuario findbyCpfUsuario(String cpfUsuario){
        Optional<Usuario> obj = usuarioRepository.findByCpfUsuario(cpfUsuario);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cpf do Usuário não encontrado :" + cpfUsuario));
    }

    public Usuario create(UsuarioDTO dto){
        dto.setIdUsuario(null);
        validaUsuario(dto);

        Usuario obj = new Usuario(dto);
        return  usuarioRepository.save(obj);
    }

    private  void validaUsuario(UsuarioDTO dto){
        Optional<Usuario> obj = usuarioRepository.findByCpfUsuario(dto.getCpfUsuario());
        if (obj.isPresent() && obj.get().getIdUsuario() != dto.getIdUsuario()){
            throw new DataIntegrityViolationException(" CPF ja cadastrado");
        }
    }

    public Usuario update(Integer id, UsuarioDTO objDto){
        objDto.setIdUsuario(id);
        Usuario oldObj = findbyId(id);
        oldObj = new Usuario(objDto);
        validaUsuario(objDto);
        return  usuarioRepository.save(oldObj);
    }

    public  void  delete(Integer id){
        Usuario obj = findbyId(id);
        usuarioRepository.deleteById(id);
    }




}
