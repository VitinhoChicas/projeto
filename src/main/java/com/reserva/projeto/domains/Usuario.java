package com.reserva.projeto.domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.reserva.projeto.domains.dtos.UsuarioDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private Integer idUsuario;

    @NotNull
    @NotBlank
    private String nomeUsuario;

    @NotNull
    @NotBlank
    private String emailUsuario;


    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull
    @NotBlank
    private String cpfUsuario;

    public Usuario(){

    }

    public Usuario(Integer idUsuario, String nomeUsuario, String emailUsuario, LocalDate dataNascimento, String cpfUsuario){
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.dataNascimento = dataNascimento;
        this.cpfUsuario = cpfUsuario;
    }

    public Usuario(UsuarioDTO dto){
        this.idUsuario = dto.getIdUsuario();
        this.nomeUsuario = dto.getNomeUsuario();
        this.emailUsuario = dto.getEmailUsuario();
        this.dataNascimento = dto.getDataNascimento();
        this.cpfUsuario = dto.getCpfUsuario();
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public @NotNull @NotBlank String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(@NotNull @NotBlank String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public @NotNull @NotBlank String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(@NotNull @NotBlank String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public @NotNull LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotNull LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotNull @NotBlank String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(@NotNull @NotBlank String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idUsuario, usuario.idUsuario) && Objects.equals(nomeUsuario, usuario.nomeUsuario) && Objects.equals(emailUsuario, usuario.emailUsuario) && Objects.equals(dataNascimento, usuario.dataNascimento) && Objects.equals(cpfUsuario, usuario.cpfUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nomeUsuario, emailUsuario, dataNascimento, cpfUsuario);
    }
}
