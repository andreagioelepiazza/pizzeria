package pizzeria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Pizzeria {

	// attributi
	private String nome;
	private int numeroTavoli;
	private List<Pizza> menu;
	private Map< Integer, Ordine> ordiniSaldati;
	private Map<Integer, Ordine> tavoli;
	private List<Integer> tavoliOccupati;

	
	

	// costruttori
	public Pizzeria(String nome, int numeroTavoli, List<Pizza> menu, Map<Integer, Ordine> tavoli, List<Integer> tavoliOccupati, Map<Integer, Ordine> ordiniSaldati) {
		this.nome = nome;
		this.numeroTavoli = numeroTavoli;
		this.menu = menu;
		this.tavoli = tavoli;
		this.tavoliOccupati = tavoliOccupati;
		this.ordiniSaldati = ordiniSaldati;
	}
	
	public Pizzeria() {

	}

	
	// metodi
	public Map<Integer, Ordine> getOrdiniSaldati() {
		return ordiniSaldati;
	}

	public void setOrdiniSaldati(Map<Integer, Ordine> ordiniSaldati) {
		this.ordiniSaldati = ordiniSaldati;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroTavoli() {
		return numeroTavoli;
	}

	public void setNumeroTavoli(int numeroTavoli) {
		this.numeroTavoli = numeroTavoli;
	}

	public List<Pizza> getMenu() {
		return menu;
	}

	public void setMenu(List<Pizza> menu) {
		this.menu = menu;
	}

	public Map<Integer, Ordine> getTavoli() {
		return tavoli;
	}

	public void setOrdini(Map<Integer, Ordine> tavoli) {
		this.tavoli = tavoli;
	}

	public List<Integer> getTavoliOccupati() {
		return tavoliOccupati;
	}

	public void setTavoliOccupati(List<Integer> tavoliOccupati) {
		this.tavoliOccupati = tavoliOccupati;
	}

	public void setTavoli(Map<Integer, Ordine> tavoli) {
		this.tavoli = tavoli;
	}
	
	public double calcolaTotaleGiornata( Map<Integer, Ordine> map ) {
		double totale = 0;
	    for (Map.Entry<Integer, Ordine> entry : map.entrySet()) {
	    	totale = totale + entry.getValue().getTotale();
	    }
	    return totale;
	}
	
	public void getNumeriTavoli( Map<Integer, Ordine> map ) {
		
	    for (Map.Entry<Integer, Ordine> entry : map.entrySet()) {
	    	 System.out.print("Tavolo numero: " + entry.getKey()+ " ,");
	    }
	    System.out.println(".");
	}

}
