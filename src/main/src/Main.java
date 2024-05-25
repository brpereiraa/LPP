package main.src;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {


        Reserva reserva = new Reserva(LocalDate.now(), LocalTime.now(), 4, Reserva.StatusReserva.ATIVA);
        System.out.println(reserva);






    }
}