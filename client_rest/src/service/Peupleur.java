package service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modele.Action;
import modele.Role;
import modele.Utilisateur;

public class Peupleur {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("authentification");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Utilisateur user = new Utilisateur("dupont.pierre@gmail.com", "dupontp", "Dupont", "Pierre", new Date(), "Martin");
		Role role = new Role("magasin", "un magasin du réseau national", new Date(), "Martin");
		Action action = new Action("vendre", "vendre une guitare", new Date(), "Martin");
		
		role.ajoutAction(action);
		role.ajoutUtilisateur(user);
		
		em.persist(role);		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}
}