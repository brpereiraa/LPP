package main.src;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    private LocalDate data;
    private LocalTime hour;
    private int numPeople;
    private Reservation.StatusReservation status;
    private Restaurant restaurant;

    public enum StatusReservation {
        ACTIVE,
        CANCELED,
        FINISHED
    }

    public Reservation(LocalDate data, LocalTime hora, int numPeople, Reservation.StatusReservation status, Restaurant restaurant) {
        this.data = data;
        this.hour = hora;
        this.numPeople = numPeople;
        this.status = status;
        this.restaurant = restaurant;
    }

    public Reservation(Reservation reservation) {
        this.data = reservation.data;
        this.hour = reservation.hour;
        this.numPeople = reservation.numPeople;
        this.status = reservation.status;
        this.restaurant = reservation.restaurant;
    }

    public Reservation copy() {
        return new Reservation(this);
    }

    public LocalTime getHora() { return hour; }
    public LocalDate getData() { return data; }

    public void setHour(LocalTime hora) { this.hour = hora; }

    public void setNumPeople(int numPeople) { this.numPeople = numPeople; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
    public void setStatus(Reservation.StatusReservation status) { this.status = status; }

    public int getNumPeople() { return this.numPeople; }
    public void setData(LocalDate data) { this.data = data; }
    public Reservation.StatusReservation getStatus() { return status; }
    public Restaurant getRestaurant() { return this.restaurant; }

    @Override
    public String toString() {
        return ("Schedule: " + data + " | Hour: " + hour + " | Number of people: " + numPeople +
                    " | Status: " + status + " | Restaurant: " + restaurant.getName());
    }
}
