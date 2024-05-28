package main.src;

public class Mesa {
    private int numeroDaMesa;
    private int capacidade;
    private Localizacao localizacao;

    // Enum para a localização da mesa
    public enum Localizacao {
        INTERNA,
        EXTERNA
    }

    // Construtor
    public Mesa(int numeroDaMesa, int capacidade, Localizacao localizacao) {
        setNumeroDaMesa(numeroDaMesa);
        setCapacidade(capacidade);
        setLocalizacao(localizacao);
    }

    // Construtor de cópia
    public Mesa(Mesa outraMesa) {
        this(outraMesa.numeroDaMesa, outraMesa.capacidade, outraMesa.localizacao);
    }

    // Método de cópia
    public Mesa copy() {
        return new Mesa(this);
    }

    // Getters e Setters com verificações de input
    public int getNumeroDaMesa() {
        return numeroDaMesa;
    }

    public void setNumeroDaMesa(int numeroDaMesa) {
        if (numeroDaMesa <= 0 || numeroDaMesa >= 40) {
            throw new IllegalArgumentException("Número da mesa deve ser positivo e menor que 40.");
        }
        this.numeroDaMesa = numeroDaMesa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        if (capacidade <= 0 || capacidade >= 100) {
            throw new IllegalArgumentException("Capacidade deve ser positiva e menor que 100.");
        }
        this.capacidade = capacidade;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        if (localizacao == null) {
            throw new IllegalArgumentException("Localização não pode ser nula.");
        }
        this.localizacao = localizacao;
    }

    // Método para exibir informações da mesa
    @Override
    public String toString() {
        return "Mesa{" +
                "numeroDaMesa=" + numeroDaMesa +
                ", capacidade=" + capacidade +
                ", localizacao=" + localizacao +
                '}';
    }
}