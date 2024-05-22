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
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getNumeroDePessoas() {
        return numeroDePessoas;
    }

    public void setNumeroDePessoas(int numeroDePessoas) {
        this.numeroDePessoas = numeroDePessoas;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
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