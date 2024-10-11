package dao;

import entities.Utente;
import exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDao {
    private final EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("L'utente " + utente.getNome() + " " + utente.getCognome() + " è stato salvato correttamente");
    }

    public void delete(long id) {
        Utente found = this.TrovaId(id);
        if (found == null) throw new NotFoundEx(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'utente " + found.getNome() + " " + found.getCognome() + " è stato eliminato");
    }


    public Utente TrovaId(long id) {
        Utente found = em.find(Utente.class, id);
        if (found == null) throw new NotFoundEx(id);
        return found;
    }

}
