package pizzeria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Start {

	Scanner sc = new Scanner(System.in);

	public void start() {

		Pizza margherita = new Pizza("Margherita");
		Pizza verdure = new Pizza("Verdure");
		Pizza mare = new Pizza("Mare");
		Pizza prosciutto = new Pizza("Prosciutto Crudo");

		Ingrediente mozzarella = new Ingrediente("Mozzarella", false, 1.00);
		Ingrediente pomodoro = new Ingrediente("Pomodoro", false, 0.50);
		Ingrediente pCrudo = new Ingrediente("Prosciutto Crudo", false, 1.50);
		Ingrediente gamberetti = new Ingrediente("Gamberetti", true, 2.00);
		Ingrediente zucchine = new Ingrediente("Zucchine", false, 1.00);
		Ingrediente carciofi = new Ingrediente("Carciofi", false, 2.00);
		Ingrediente olive = new Ingrediente("Olive", false, 1.00);

		margherita.aggiungiIngrediente(pomodoro);
		margherita.aggiungiIngrediente(mozzarella);

		verdure.aggiungiIngrediente(pomodoro);
		verdure.aggiungiIngrediente(zucchine);
		verdure.aggiungiIngrediente(carciofi);
		verdure.aggiungiIngrediente(olive);
		verdure.aggiungiIngrediente(mozzarella);

		mare.aggiungiIngrediente(pomodoro);
		mare.aggiungiIngrediente(mozzarella);
		mare.aggiungiIngrediente(gamberetti);

		prosciutto.aggiungiIngrediente(pomodoro);
		prosciutto.aggiungiIngrediente(mozzarella);
		prosciutto.aggiungiIngrediente(pCrudo);

		List<Ingrediente> ingredienti = new ArrayList<Ingrediente>();

		List<Pizza> menu = new ArrayList<Pizza>();

		Map<Integer, Ordine> tavoli = new HashMap<Integer, Ordine>();

		Map<Integer, Ordine> ordiniSaldati = new HashMap<Integer, Ordine>();

		List<Integer> tavoliOccupati = new ArrayList<Integer>();

		ingredienti.add(mozzarella);
		ingredienti.add(pomodoro);
		ingredienti.add(pCrudo);
		ingredienti.add(gamberetti);
		ingredienti.add(olive);
		ingredienti.add(zucchine);
		ingredienti.add(carciofi);

		menu.add(mare);
		menu.add(verdure);
		menu.add(margherita);
		menu.add(prosciutto);

		Pizzeria laBrace = new Pizzeria("La Brace", tavoli.size(), menu, tavoli, tavoliOccupati, ordiniSaldati);

		// Stringhe di testo usate nel metodo

		// inizio codice menù interattivo
		for (int counter = 0; counter < 2;) {

			System.out.println("Digita 1 per effettuare l'ordine\n" + "Digita 2 per avere il conto\n"
					+ "Digita 3 per saldare un conto\n"
					+ "Digita 4 per avere la lista dei conti saldati e il guadagno giornaliero\n"
					+ "Digita 5 per modificare un ordine\n" + "Digita 6 per avere la lista dei tavoli occupati\n"
					+ "Digita 7 per chiudere il programma.\n");
			String input = sc.nextLine();

			switch (input) {

			// Opzione per prendere l'ordine
			case "1":

				List<Pizza> pizzeScelte = new ArrayList<Pizza>();
				Ordine ordine = new Ordine();
				ordine.setElencoPizze(pizzeScelte);

				int numTav = 0;
				// ciclo aperto che serve a creare giro che può chiudersi solo quando richiesto
				for (int x = 0; x < 2;) {
					System.out.println("Inserisci il numero di tavolo");
					numTav = sc.nextInt();
					sc.nextLine();

					if (numTav > 20 || numTav < 1) {
						System.out.println("Tavolo non esistente");
					} else {

						if (laBrace.getTavoli().get(numTav) == null) {
							laBrace.getTavoli().put(numTav, ordine);
							laBrace.getTavoliOccupati().add(numTav);
							x = 3;
						} else {
							System.out.println("Esiste già un ordine per questo tavolo.");
						}
					}
				}

				System.out.println("Inserisci il numero dei coperti");
				int coperti = sc.nextInt();
				sc.nextLine();

				// ciclo che serve a stampare il menù
				for (int i = 0; i < coperti; i++) {

					// variabile che serve per poter accedere alla posizione nella List delle pizze
					// dell'ordine
					int contatore = 0;

					for (int stampaMenu = 0; stampaMenu < menu.size(); stampaMenu++) {
						System.out.println("Digita " + (stampaMenu + 1) + " per la pizza: "
								+ laBrace.getMenu().get(stampaMenu).getNome());
					}

					int scelta = sc.nextInt();
					sc.nextLine();

					laBrace.getTavoli().get(numTav).addPizza(laBrace.getMenu().get(scelta - 1));

					for (int y = 0; y < 2;) {
						System.out.println("Digita 1 per aggiungere un ingrediente o 2 per continuare.");

						String sceltaIng = sc.nextLine();

						switch (sceltaIng) {

						case "1":
							for (int stampaIngredienti = 0; stampaIngredienti < ingredienti
									.size(); stampaIngredienti++) {
								System.out.println("digita " + (stampaIngredienti + 1) + " per aggiungere: "
										+ ingredienti.get(stampaIngredienti).getNome());
							}

							int sceltaAggiunta = sc.nextInt();
							sc.nextLine();

							pizzeScelte.get(contatore).aggiungiIngrediente(ingredienti.get(sceltaAggiunta - 1));
							break;

						case "2":
							y = 3;
							contatore++;
							break;

						}

					}
				}
				break;

			// Opzione per avere il conto di uno specifico ordine
			case "2":

				if (laBrace.getTavoliOccupati().isEmpty() == true) {
					System.out.println("Nessun ordine presente.");
				} else {

					// ciclato l'ArrayList per sapere quali sono gli ordini aperti che si possono
					// richiamare
					for (int i = 0; i < laBrace.getTavoliOccupati().size(); i++) {
						System.out.println("Digita : " + (laBrace.getTavoliOccupati().get(i)) + " per il tavolo : "
								+ laBrace.getTavoliOccupati().get(i));
					}

					int numeroTav = sc.nextInt();
					sc.nextLine();

					if (tavoli.get(numeroTav) == null) {
						System.out.println("Nessun conto associato a questo tavolo.");
					} else {
						System.out
								.println("il conto è di: " + laBrace.getTavoli().get(numeroTav).getTotale() + " euro.");
					}
				}

				break;

			// Opzione per saldare il conto presente per un tavolo specifico
			case "3":

				// ciclato l'ArrayList per sapere quali sono gli ordini aperti che si possono
				// richiamare
				for (int i = 0; i < laBrace.getTavoliOccupati().size(); i++) {
					System.out.println("Digita : " + laBrace.getTavoliOccupati().get(i) + " per il tavolo : "
							+ laBrace.getTavoliOccupati().get(i));
				}
				Integer numeroTav2 = sc.nextInt();
				sc.nextLine();

				if (laBrace.getTavoli().get(numeroTav2) == null) {
					System.out.println("Nessun conto associato a questo tavolo.");
				} else {

					System.out.println("il conto del tavolo: " + numeroTav2 + " di euro: "
							+ laBrace.getTavoli().get(numeroTav2).getTotale() + " è stato saldato.");
					System.out.println(" ");

					laBrace.getOrdiniSaldati().put(numeroTav2, laBrace.getTavoli().get(numeroTav2));
					laBrace.getTavoli().remove(numeroTav2);

					for (int i = 0; i < laBrace.getTavoliOccupati().size(); i++) {
						if (laBrace.getTavoliOccupati().get(i) == numeroTav2) {
							laBrace.getTavoliOccupati().remove(i);
						}
					}
				}

				break;

			// Opzione per avere una lista degli ordini saldati e il guadagno totale degli
			// ordini saldati
			case "4":
				double totaleGiornata = laBrace.calcolaTotaleGiornata(laBrace.getOrdiniSaldati());

				System.out.println("lista ordini saldati: ");
				laBrace.getNumeriTavoli(laBrace.getOrdiniSaldati());
				System.out.println("per un totale di: " + totaleGiornata + " euro.");

				System.out.println(" ");

				break;

			// opzione per aggiungere o rimuovere gli oggetti Pizza presenti dentro
			// l'ArrayList di Pizza presente dentro l'oggetto Ordine
			case "5":

				for (int i = 0; i < laBrace.getTavoliOccupati().size(); i++) {
					System.out.println("Digita : " + laBrace.getTavoliOccupati().get(i) + " per il tavolo : "
							+ laBrace.getTavoliOccupati().get(i));
				}
				int ordineDaModificare = sc.nextInt();
				sc.nextLine();

				if (laBrace.getTavoli().get(ordineDaModificare) == null) {
					System.out.println("Nessun conto associato a questo tavolo.");
				} else {
					for (int x = 0; x < 2;) {
						System.out.println("Digita 1 per aggiungere una pizza all'ordine \n"
								+ "Digita 2 per rimuovere una pizza dall'ordine\n" + "Digita 3 per tornare al menù.");
						String modifica = sc.nextLine();

						switch (modifica) {

						case "1":

							for (int stampaMenu = 0; stampaMenu < menu.size(); stampaMenu++) {
								System.out.println("Digita " + (stampaMenu + 1) + " per la pizza: "
										+ laBrace.getMenu().get(stampaMenu).getNome());
							}
							int p = sc.nextInt();
							sc.nextLine();
							laBrace.getTavoli().get(ordineDaModificare).addPizza(laBrace.getMenu().get(p - 1));
							break;

						case "2":

							System.out.println("Ordini aperti: ");
							laBrace.getNumeriTavoli(laBrace.getTavoli());
							System.out.println("Digita il numero del tavolo la quale desideri modificare l'ordine. ");

							int ordineDaModificare2 = sc.nextInt();
							sc.nextLine();

							for (int i = 0; i < laBrace.getTavoli().get(ordineDaModificare2).getElencoPizze()
									.size(); i++) {
								System.out.println("digita :" + (i + 1) + " per rimuovere la pizza: "
										+ laBrace.getTavoli().get(ordineDaModificare2).getElencoPizze().get(i));
							}
							int elementoDaRimuovere = sc.nextInt();
							sc.nextLine();

							laBrace.getTavoli().get(ordineDaModificare2).getElencoPizze().remove(elementoDaRimuovere-1);

							break;

						case "3":
							x = 3;
							break;

						}
					}
				}

				break;

			// Opzione per vedere quali tavolo sono occupati
			case "6":

				System.out.println("I tavoli occupati sono: ");
				for (int i = 0; i < tavoliOccupati.size(); i++) {
					System.out.println("tavolo " + tavoliOccupati.get(i));
				}
				if (tavoliOccupati.isEmpty() == true) {
					System.out.println("Nessun tavolo occupato");
				}
				break;

			case "7":

				System.out.println("Programma chiuso.");
				counter = 3;
				break;

			default:
				System.out.println("digitazione errata");
				break;

			}
		}
	}
}
