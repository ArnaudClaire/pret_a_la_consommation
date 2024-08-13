package com.visiplus.pret_a_la_consommation.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pret {
	
	Client client;
	private List<Mensualite> Mensualites=new ArrayList<>();
	private Long id;
	private double montantDemande;
	private double montantMensualite;
	private LocalDateTime dateSouscription;
	private LocalDate dateEffet;
	private String observations;
	private static Long compt=0L;
	
	public Pret(Client client,double montantDemande,double tauxAnnuel, int dureeEnMois, LocalDateTime dateSouscription, LocalDate dateEffet) {
		super();
		this.client=client;
		setId(++compt);
		this.montantDemande = montantDemande;
		double tauxMensuel=tauxAnnuel*12/100;
		this.dateEffet=dateEffet;
		this.montantMensualite = (montantDemande * tauxMensuel) / (1 - Math.pow(1 + tauxMensuel, -dureeEnMois));
		this.dateSouscription = dateSouscription;
		double capitalRestant=montantDemande;
		for (int i = 0; i <= dureeEnMois; i++) {
			double interet = capitalRestant * tauxMensuel;
            double capitalARembourse = montantMensualite - interet;
            double capitalRembourse=capitalARembourse*i;
            capitalRestant -= capitalRembourse;
			LocalDate dateDuMois=dateEffet.plusMonths(i);
            this.Mensualites.add(new Mensualite(this, dateDuMois, interet,capitalRembourse));
		}
		
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Mensualite> getMensualites() {
		return Mensualites;
	}
	public void setMensualites(List<Mensualite> mensualites) {
		Mensualites = mensualites;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getMontantDemande() {
		return montantDemande;
	}
	public void setMontantDemande(double montantDemande) {
		this.montantDemande = montantDemande;
	}
	public double getMontantMensualite() {
		return montantMensualite;
	}
	public void setMontantMensualite(double montantMensualite) {
		this.montantMensualite = montantMensualite;
	}
	public LocalDateTime getDateSouscription() {
		return dateSouscription;
	}
	public void setDateSouscription(LocalDateTime dateSouscription) {
		this.dateSouscription = dateSouscription;
	}
	public LocalDate getDateEffet() {
		return dateEffet;
	}
	public void setDateEffet(LocalDate dateEffet) {
		this.dateEffet = dateEffet;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public static Long getCompt() {
		return compt;
	}
	public static void setCompt(Long compt) {
		Pret.compt = compt;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Mensualites, client, dateEffet, dateSouscription, id, montantDemande, montantMensualite,
				observations);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pret other = (Pret) obj;
		return Objects.equals(Mensualites, other.Mensualites) && Objects.equals(client, other.client)
				&& Objects.equals(dateEffet, other.dateEffet)
				&& Objects.equals(dateSouscription, other.dateSouscription) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(montantDemande) == Double.doubleToLongBits(other.montantDemande)
				&& Double.doubleToLongBits(montantMensualite) == Double.doubleToLongBits(other.montantMensualite)
				&& Objects.equals(observations, other.observations);
	}
	@Override
	public String toString() {
		return "Voici les détails du prêt : id : "+id+", client : "+client.getPrenom()+" "+client.getNom()+", montant emprunté : "+montantDemande
				+ ", mensualité : "+ montantMensualite;
	}
	
	
}
