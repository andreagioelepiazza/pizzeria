package pizzeria;

import java.util.ArrayList;
import java.util.List;

public class Ordine {
	
	// attributo
	private List <Pizza> elencoPizze;
	private double totale;
	
	
	// costruttori
	public Ordine () {
		this.elencoPizze = new ArrayList();

	}
	
	
	public Ordine (List <Pizza> elencoPizze) {
		this.elencoPizze = elencoPizze;
	}

	
	// metodi
	public List<Pizza> getElencoPizze() {
		return elencoPizze;
	}
	

	public void setElencoPizze(List<Pizza> elencoPizze) {
		this.elencoPizze = elencoPizze;
	}
	
	
	public void addPizza(Pizza p) {
		elencoPizze.add(p);
	}
	
	
	public double getTotale() {
		totale = 0;
		for (int i = 0; i < elencoPizze.size(); i++) {
			totale = totale + elencoPizze.get(i).getPrezzoPizza();
		}
		return totale;
	}
	
	
	@Override
	public String toString() {
		return "Ordine per il tavolo: " + ", elenco Pizze: " + elencoPizze + ".";
	}
	
	
	

}
