package com.reserva.projeto.domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reserva.projeto.domains.dtos.ReservaDTO;
import com.reserva.projeto.domains.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reserva")
    private Long idReserva;

    @NotNull
    @NotBlank
    private String nomeSala;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataReserva;

    @NotNull
    @NotBlank
    private String descricaoSala;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;


    public Reserva(){
        this.status = Status.PENDENTE;
    }

    public  Reserva(Long idReserva, String nomeSala, LocalDate dataReserva, String descricaoSala, Status status, Usuario usuario){
        this.idReserva = idReserva;
        this.nomeSala = nomeSala;
        this.dataReserva = dataReserva;
        this.descricaoSala = descricaoSala;
        this.status = status;
        this.usuario = usuario;
    }

    public Reserva(ReservaDTO dto){
        this.idReserva = dto.getIdReserva();
        this.nomeSala = dto.getNomeSala();
        this.dataReserva = dto.getDataReserva();
        this.descricaoSala = dto.getDescricaoSala();
        this.status = Status.toEnum(dto.getStatus());
        this.usuario = new Usuario();
        this.usuario.setIdUsuario(dto.getUsuario());
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public @NotNull @NotBlank String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(@NotNull @NotBlank String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public @NotNull LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(@NotNull LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public @NotNull @NotBlank String getDescricaoSala() {
        return descricaoSala;
    }

    public void setDescricaoSala(@NotNull @NotBlank String descricaoSala) {
        this.descricaoSala = descricaoSala;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(idReserva, reserva.idReserva) && Objects.equals(nomeSala, reserva.nomeSala) && Objects.equals(dataReserva, reserva.dataReserva) && Objects.equals(descricaoSala, reserva.descricaoSala) && status == reserva.status && Objects.equals(usuario, reserva.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReserva, nomeSala, dataReserva, descricaoSala, status, usuario);
    }
}
