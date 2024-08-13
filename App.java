package com.visiplus.pret_a_la_consommation;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.visiplus.pret_a_la_consommation.business.Client;
import com.visiplus.pret_a_la_consommation.business.Mensualite;
import com.visiplus.pret_a_la_consommation.business.Pret;

public class App {

	public static void main(String[] args) {

		
	
		List<Client> clients = new ArrayList<>();
		clients.add(new Client("Nom0", "Prenom0"));
		clients.add(new Client("Nom1", "Prenom1"));
		clients.add(new Client("Nom2", "Prenom2"));
		clients.add(new Client("Nom3", "Prenom3"));
		clients.add(new Client("Nom4", "Prenom4"));
		menu(clients);
		
	}

	public static void exit() {
		System.out.println("Au revoir");
	}
	
	public static void menu( List<Client> clients) {
		Scanner scanner=new Scanner(System.in);
		int menuSaisi;
		Long idClientConcerne;
		double montantDemande;
		double tauxAnnuel;
		int dureeEnMois;
		String dateEffet;
		LocalDateTime dateSouscription;
		System.out.println("Bienvenue sur prêt à la consommation\r\n");
		System.out.println("1. Voir tous les prêts triées par montant (du plus élevé au plus petit)\r\n");
		System.out.println("2. Voir tous les prêts triées par taux (du plus élevé au plus petit)\r\n"
				);
		System.out.println("3. Voir la liste des prêts qui débutent entre deux dates données\r\n");
		System.out.println("4. Ajouter un prêt\r\n");
		System.out.println("5. Quitter\r\n");
		System.out.println("Faîtes votre choix : ");
		menuSaisi=scanner.nextInt();
		
		switch (menuSaisi) {
		case 4:
			Client clientConcerne = null;
			for (Client client : clients) {
	            System.out.println(client.toString());
	        }
			System.out.println("Veuillez saisir l'id du client concerné : ");
			idClientConcerne=scanner.nextLong();
			for (Client client : clients) {
	            if (client.getId().equals(idClientConcerne)) {
	                clientConcerne = client;
	                break;
	            }
	        }
			if(clientConcerne!=null) {
				System.out.println("Veuillez saisir le montant demandé : ");
				montantDemande=scanner.nextDouble();
				System.out.println("Veuillez saisir le taux annuel : ");
				tauxAnnuel=scanner.nextDouble()/100;
				System.out.println("Veuillez saisir la durée en mois : ");
				dureeEnMois=scanner.nextInt();
				System.out.println("Veuillez saisir la date d'effet au format MM/yyyy : ");
				dateEffet=scanner.next();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
				if (dateEffet.isEmpty()) {
		            System.out.println("Aucune date saisie.");
		            dateEffet="01/1999";
				} 
				LocalDate localDateEffet=null;
				try {
					YearMonth yearMonth = YearMonth.parse(dateEffet, formatter);
					localDateEffet = yearMonth.atDay(1);
				} catch (DateTimeParseException  e) {
					System.out.println("Veuillez vérifier la date rentré");
				}
				

				dateSouscription=LocalDateTime.now();
				Pret pret=new Pret(clientConcerne,montantDemande,tauxAnnuel,dureeEnMois,dateSouscription ,localDateEffet);
				System.out.println(pret.toString());
				System.out.println("Date        Capital remboursé        Part des intérêts");
				for(Mensualite mensualite : pret.getMensualites()) {
					System.out.println(mensualite.toString());
				}
				
				menu(clients);
				
			}
			break;
			

		default:
			exit();
			break;
		}

		scanner.close();
	}
}
