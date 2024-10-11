package dao;

import entities.Catalogo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CatalogoDao {
    private final EntityManager em;

    public CatalogoDao(EntityManager em) {
        this.em = em;
    }
    public void save(Catalogo book) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(book);
        transaction.commit();
        System.out.println("libro/rivista " + book.getTitolo() + " è stato salvato correttamente nel Catalogo");
    }
}
