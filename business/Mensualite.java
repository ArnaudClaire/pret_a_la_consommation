package com.visiplus.pret_a_la_consommation.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mensualite {
	Pret pret;
	private Long id;
	private LocalDate datePrelevement;
	private double partInteretsRembourses;
	private double partCapitalRembourses;
	private static Long compt=0L;
	public Mensualite(Pret pret, LocalDate datePrelevement, double partInteretsRembourses,
			double partCapitalRembourses) {
		super();
		this.pret = pret;
		setId(++compt);
		this.datePrelevement = datePrelevement;
		this.partInteretsRembourses = partInteretsRembourses;
		this.partCapitalRembourses = partCapitalRembourses;
	}
	public Pret getPret() {
		return pret;
	}
	public void setPret(Pret pret) {
		this.pret = pret;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDatePrelevement() {
		return datePrelevement;
	}
	public void setDatePrelevement(LocalDate datePrelevement) {
		this.datePrelevement = datePrelevement;
	}
	public double getPartInteretsRembourses() {
		return partInteretsRembourses;
	}
	public void setPartInteretsRembourses(double partInteretsRembourses) {
		this.partInteretsRembourses = partInteretsRembourses;
	}
	public double getPartCapitalRembourses() {
		return partCapitalRembourses;
	}
	public void setPartCapitalRembourses(double partCapitalRembourses) {
		this.partCapitalRembourses = partCapitalRembourses;
	}
	public static Long getCompt() {
		return compt;
	}
	public static void setCompt(Long compt) {
		Mensualite.compt = compt;
	}
	@Override
	public int hashCode() {
		return Objects.hash(datePrelevement, id, partCapitalRembourses, partInteretsRembourses, pret);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensualite other = (Mensualite) obj;
		return Objects.equals(datePrelevement, other.datePrelevement) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(partCapitalRembourses) == Double
						.doubleToLongBits(other.partCapitalRembourses)
				&& Double.doubleToLongBits(partInteretsRembourses) == Double
						.doubleToLongBits(other.partInteretsRembourses)
				&& Objects.equals(pret, other.pret);
	}
	@Override
	public String toString() {
		return datePrelevement.toString() + "   "+ partCapitalRembourses+"   "+partInteretsRembourses;
	}
	
	
}
