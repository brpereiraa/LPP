package main.src;

import java.time.LocalDate;

public class Bilhete {
    private int numeroDoBilhete;
    private LocalDate dataDeEmissao;
    private Reserva detalhesDaReserva;

    // Construtor
    public Bilhete(int numeroDoBilhete, LocalDate dataDeEmissao, Reserva detalhesDaReserva) {
        setNumeroDoBilhete(numeroDoBilhete);
        setDataDeEmissao(dataDeEmissao);
        setDetalhesDaReserva(detalhesDaReserva);
    }

    // Construtor de cópia
    public Bilhete(Bilhete outroBilhete) {
        this(outroBilhete.numeroDoBilhete, outroBilhete.dataDeEmissao, new Reserva(outroBilhete.detalhesDaReserva));
    }

    // Método de cópia
    public Bilhete copy() {
        return new Bilhete(this);
    }

    // Getters e Setters com verificações de input
    public int getNumeroDoBilhete() {
        return numeroDoBilhete;
    }

    public void setNumeroDoBilhete(int numeroDoBilhete) {
        if (numeroDoBilhete <= 0)
            throw new IllegalArgumentException("Número do bilhete deve ser positivo.");
        this.numeroDoBilhete = numeroDoBilhete;
    }

    public LocalDate getDataDeEmissao() {
        return dataDeEmissao;
    }

    public void setDataDeEmissao(LocalDate dataDeEmissao) {
        if (dataDeEmissao == null || dataDeEmissao.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de emissão não pode ser nula ou no futuro.");
        }
        this.dataDeEmissao = dataDeEmissao;
    }

    public Reserva getDetalhesDaReserva() {
        return new Reserva(detalhesDaReserva);
    }

    public void setDetalhesDaReserva(Reserva detalhesDaReserva) {
        if (detalhesDaReserva == null) {
            throw new IllegalArgumentException("Detalhes da reserva não podem ser nulos.");
        }
        this.detalhesDaReserva = new Reserva(detalhesDaReserva);
    }

    // Método para exibir informações do bilhete
    @Override
    public String toString() {
        return "Bilhete{" +
                "numeroDoBilhete=" + numeroDoBilhete +
                ", dataDeEmissao=" + dataDeEmissao +
                ", detalhesDaReserva=" + detalhesDaReserva +
                '}';
    }
}
