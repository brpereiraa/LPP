package main.src;

public class Table {
    private int numeroDaTable;
    private int capacidade;
    private Localizacao localizacao;

    // Enum para a localização da Table
    public enum Localizacao {
        INTERN,
        EXTERN
    }

    // Construtor
    public Table(int numeroDaTable, int capacidade, Localizacao localizacao) {
        setNumeroDaTable(numeroDaTable);
        setCapacidade(capacidade);
        setLocalizacao(localizacao);
    }

    // Construtor de cópia
    public Table(Table outraTable) {
        this(outraTable.numeroDaTable, outraTable.capacidade, outraTable.localizacao);
    }

    // Método de cópia
    public Table copy() { return (new Table(this)); }

    // Getters e Setters com verificações de input
    public int getNumeroDaTable() {
        return numeroDaTable;
    }
    public int getCapacidade() { return capacidade; }
    public Localizacao getLocalizacao() { return localizacao; }

    public void setNumeroDaTable(int numeroDaTable) { this.numeroDaTable = numeroDaTable; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }
    public void setLocalizacao(Localizacao localizacao) { this.localizacao = localizacao; }

    // Método para exibir informações da Table
    @Override
    public String toString() {
        return "Table number: " + numeroDaTable + " | Capacity: " + capacidade + " | Location" + localizacao;
    }
}