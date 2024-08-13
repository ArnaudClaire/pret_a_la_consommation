package com.visiplus.pret_a_la_consommation.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
	
	private List<Pret> Prets=new ArrayList<>();
	private Long id; 
	private String nom;
	private String prenom;
	private static Long compt=0L; //autoboxing
	public Client(String nom, String prenom) {
		super();
		setId(++compt);
		this.nom = nom;
		this.prenom = prenom;
	}
	public List<Pret> getPrets() {
		return Prets;
	}
	public void setPrets(List<Pret> prets) {
		Prets = prets;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public static Long getCompt() {
		return compt;
	}
	public static void setCompt(Long compt) {
		Client.compt = compt;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Prets, id, nom, prenom);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(Prets, other.Prets) && Objects.equals(id, other.id) && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom);
	}
	@Override
	public String toString() {
		return id +". "+ nom +" "+ prenom;
	}
	
}
