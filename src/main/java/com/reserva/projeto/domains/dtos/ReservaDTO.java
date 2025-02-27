package com.reserva.projeto.domains.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.reserva.projeto.domains.Reserva;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ReservaDTO {

   private Long idReserva;

   @NotNull(message = "O campo nomeSala não pode ser nulo")
   @NotBlank(message = "O campo nomeSala não pode ser vazio")
   private String nomeSala;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataReserva;

    @NotNull(message = "O campo descricaoSala não pode ser nulo")
    @NotBlank(message = "O campo descricaoSala não pode ser vazio")
    private String descricaoSala;

    private int status;

    @NotNull(message =  "O campo idUsuario não pode ser nulo")
    private int Usuario;

    public ReservaDTO() {
    }


    public ReservaDTO(Reserva reserva) {
        this.idReserva = reserva.getIdReserva();
        this.nomeSala = reserva.getNomeSala();
        this.dataReserva = reserva.getDataReserva();
        this.descricaoSala = reserva.getDescricaoSala();
        this.status = reserva.getStatus().getId();
        Usuario = reserva.getUsuario().getIdUsuario();
        Usuario  = reserva.getUsuario().getIdUsuario();
    }


    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public @NotNull(message = "O campo nomeSala não pode ser nulo") @NotBlank(message = "O campo nomeSala não pode ser vazio") String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(@NotNull(message = "O campo nomeSala não pode ser nulo") @NotBlank(message = "O campo nomeSala não pode ser vazio") String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public @NotNull(message = "O campo descricaoSala não pode ser nulo") @NotBlank(message = "O campo descricaoSala não pode ser vazio") String getDescricaoSala() {
        return descricaoSala;
    }

    public void setDescricaoSala(@NotNull(message = "O campo descricaoSala não pode ser nulo") @NotBlank(message = "O campo descricaoSala não pode ser vazio") String descricaoSala) {
        this.descricaoSala = descricaoSala;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @NotNull(message = "O campo idUsuario não pode ser nulo")
    public int getUsuario() {
        return Usuario;
    }

    public void setUsuario(@NotNull(message = "O campo idUsuario não pode ser nulo") int usuario) {
        Usuario = usuario;
    }
}
