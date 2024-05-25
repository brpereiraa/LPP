package main.src;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Cliente {

    private String nome;
    private String contato;
    private String email;
    private List<Reserva> historicoReservas;

    // Construtor
    public Cliente(String nome, String contato, String email, List<Reserva> historicoReservas) {
        this.nome = nome;
        this.contato = contato;
        this.email = email;
        this.historicoReservas = new ArrayList<>(historicoReservas);
    }

    // Construtor de cópia
    public Cliente(Cliente outroCliente) {
        this.nome = outroCliente.nome;
        this.contato = outroCliente.contato;
        this.email = outroCliente.email;
        this.historicoReservas = new ArrayList<>();
        for (Reserva reserva : outroCliente.historicoReservas) {
            this.historicoReservas.add(new Reserva(reserva));
        }
    }

    // Método de cópia
    public Cliente copy() {
        return new Cliente(this);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        if (contato == null || contato.trim().isEmpty()) {
            throw new IllegalArgumentException("Contato não pode ser nulo ou vazio.");
        }
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty() || !isValidEmail(email)) {
            throw new IllegalArgumentException("Email inválido.");
        }
        this.email = email;
    }

    public List<Reserva> getHistoricoReservas() {
        return new ArrayList<>(historicoReservas);
    }

    public void setHistoricoReservas(List<Reserva> historicoReservas) {
        this.historicoReservas = new ArrayList<>(historicoReservas);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }
    

    // Método para exibir informações do cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", contato='" + contato + '\'' +
                ", email='" + email + '\'' +
                ", historicoReservas=" + historicoReservas +
                '}';
    }

}
