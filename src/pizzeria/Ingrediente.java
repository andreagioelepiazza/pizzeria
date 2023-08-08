package pizzeria;

public class Ingrediente {
	
	// attributi
	private String nome;
	private boolean congelato;
	private double prezzo;
	
	
	// costruttori
	public Ingrediente() {
		
	}
	
	public Ingrediente (String nome, boolean congelato, double prezo) {
		
		this.nome = nome;
		this.congelato = congelato;
		this.prezzo = prezo;
	}
	
	
	// metodi
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	
	public void setCognelato (boolean congelato) {
		this.congelato = congelato;
	}
	
	
	public void setPrezzo (double prezzo) {
		this.prezzo = prezzo;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	public boolean getCongelato() {
		return congelato;
	}
	
	
	public double getPrezzo() {
		return prezzo;
	}

	
	@Override
	public String toString() {
		return "Ingrediente: " + nome + ", prezzo: " + prezzo + ".";
	}
	
	
}
