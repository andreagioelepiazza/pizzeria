package pizzeria;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

	// attributi
	private String nome;
	private List<Ingrediente> ingredienti;
	private static double prezzoBase;
	private double prezzoPizza;

	// costruttori
	public Pizza(String nome, ArrayList<Ingrediente> ingredienti) {
		this.nome = nome;
		this.ingredienti = new ArrayList<>();
		this.prezzoBase = 3;
	}

	public Pizza(String nome) {
		this.nome = nome;
		this.ingredienti = new ArrayList<>();
		this.prezzoBase = 3;

	}

	public Pizza() {
		this.ingredienti = new ArrayList<>();
		this.prezzoBase = 3;
	}

	// metodi
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(ArrayList<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

	public static double getPrezzoBase() {
		return prezzoBase;
	}

	public static void setPrezzoBase(double prezzo) {
		prezzoBase = prezzo;
	}

	public void aggiungiIngrediente(Ingrediente ing) {
		ingredienti.add(ing);
	}

	@Override
	public String toString() {
		return "Pizza: " + nome + ", ingredienti: " + ingredienti + ", prezzo: " + getPrezzoPizza() + ".";
	}

	public double getPrezzoPizza() {
		double prezzo = 0 + Pizza.prezzoBase;
		for (int i = 0; i < ingredienti.size(); i++) {
			prezzo = prezzo + ingredienti.get(i).getPrezzo();
		}
		return prezzo;
	}

}
