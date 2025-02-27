package com.reserva.projeto.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.reserva.projeto.domains.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;


public class UsuarioDTO {

    private Integer idUsuario;

    @NotNull(message = "O campo nomeUsuario não pode ser nulo")
    @NotBlank(message = "O campo nomeUsuario não pode ser vazio")
    private String nomeUsuario;

    @NotNull(message = "O campo emailUsuario não pode ser nulo")
    @NotBlank(message = "O campo emailUsuario não pode ser vazio")
    private String emailUsuario;

    @NotNull(message = "O campo dataN não pode ser nulo")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull(message = "O campo cpfUsuario não pode ser nulo")
    @NotBlank(message = "O campo cpfUsuario não pode ser vazio")
    private String cpfUsuario;

    private UsuarioDTO(){

    }

    public UsuarioDTO(Usuario usuario){
        this.idUsuario = usuario.getIdUsuario();
        this.nomeUsuario = usuario.getNomeUsuario();
        this.emailUsuario = usuario.getEmailUsuario();
        this.dataNascimento = usuario.getDataNascimento();
        this.cpfUsuario = usuario.getCpfUsuario();
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public @NotNull(message = "O campo nomeUsuario não pode ser nulo") @NotBlank(message = "O campo nomeUsuario não pode ser vazio") String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(@NotNull(message = "O campo nomeUsuario não pode ser nulo") @NotBlank(message = "O campo nomeUsuario não pode ser vazio") String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public @NotNull(message = "O campo emailUsuario não pode ser nulo") @NotBlank(message = "O campo emailUsuario não pode ser vazio") String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(@NotNull(message = "O campo emailUsuario não pode ser nulo") @NotBlank(message = "O campo emailUsuario não pode ser vazio") String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public @NotNull(message = "O campo dataN não pode ser nulo") LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotNull(message = "O campo dataN não pode ser nulo") LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotNull(message = "O campo cpfUsuario não pode ser nulo") @NotBlank(message = "O campo cpfUsuario não pode ser vazio") String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(@NotNull(message = "O campo cpfUsuario não pode ser nulo") @NotBlank(message = "O campo cpfUsuario não pode ser vazio") String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }
}
