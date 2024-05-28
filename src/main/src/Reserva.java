package main.src;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private LocalDate data;
    private LocalTime hora;
    private int numeroDePessoas;
    private StatusReserva status;

    // Enum para os status da reserva
    public enum StatusReserva {
        ATIVA,
        CANCELADA,
        CONCLUIDA
    }

    // Construtor
    public Reserva(LocalDate data, LocalTime hora, int numeroDePessoas, StatusReserva status) {
        this.data = data;
        this.hora = hora;
        this.numeroDePessoas = numeroDePessoas;
        this.status = status;
    }

    public Reserva(Reserva outraReserva) {
        this.data = outraReserva.data;
        this.hora = outraReserva.hora;
        this.numeroDePessoas = outraReserva.numeroDePessoas;
        this.status = outraReserva.status;
    }

    // Método de cópia
    public Reserva copy() {
        return new Reserva(this);
    }

    // Getters e Setters
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data == null)
            throw new IllegalArgumentException("Data não pode ser nula");
        if (data.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Data não pode ser no passado");
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        if (hora == null)
            throw new IllegalArgumentException("Hora não pode ser nula");
        if (hora.isBefore(LocalTime.of(6, 0)) || hora.isAfter(LocalTime.of(23, 0)))
            throw new IllegalArgumentException("Hora deve estar entre 06:00 e 23:00");
        this.hora = hora;
    }

    public int getNumeroDePessoas() {
        return numeroDePessoas;
    }

    public void setNumeroDePessoas(int numeroDePessoas) {
        if (numeroDePessoas < 0 || numeroDePessoas > 40)
            throw new IllegalArgumentException("Número de pessoas deve ser entre 1 e 40");
        this.numeroDePessoas = numeroDePessoas;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        if (status == null)
            throw new IllegalArgumentException("Status não pode ser nulo");
        this.status = status;
    }


    // Método para exibir informações da reserva
    @Override
    public String toString() {
        return "Reserva{" +
                "data=" + data +
                ", hora=" + hora +
                ", numeroDePessoas=" + numeroDePessoas +
                ", status=" + status +
                '}';
    }

  }