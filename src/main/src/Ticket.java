package main.src;

import java.time.LocalDate;

public class Ticket {
    private int numTickets;
    private LocalDate emissionDate;
    private Reservation details;

    public Ticket(int numTickets, LocalDate emissionDate, Reservation details) {
        setnumTickets(numTickets);
        setemissionDate(emissionDate);
        setdetails(details);
    }

    public Ticket(Ticket outroTicket) { this(outroTicket.numTickets, outroTicket.emissionDate, new Reservation(outroTicket.details)); }

    public Ticket copy() { return new Ticket(this); }

    public Reservation getDetails() { return new Reservation(details); }
    public int getNumTickets() { return numTickets;}
    public LocalDate getEmission() { return emissionDate; }

    public void setnumTickets(int numTickets) { this.numTickets = numTickets;}
    public void setemissionDate(LocalDate emissionDate) { this.emissionDate = emissionDate;}
    public void setdetails(Reservation details) { this.details = new Reservation(details); }

    @Override
    public String toString() {
        return "Number of tickets: " + numTickets + " | Date of emission: " + emissionDate + " | Details: " + details;
    }
}
