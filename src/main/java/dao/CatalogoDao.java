package dao;

import entities.Catalogo;
import exceptions.NotFoundEx;
import exceptions.NotFoundYear;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

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
    public Catalogo findByID(long id) {
        Catalogo found = em.find(Catalogo.class, id);
        if (found == null) throw new NotFoundEx(id);
        return found;
    }
    public void delete(long id) {
        Catalogo found = this.findByID(id);
        if (found == null) throw new NotFoundEx(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
    }
    public List<Catalogo> trovaAnno (long year) {
        TypedQuery<Catalogo> query = em.createQuery(
                "SELECT b FROM Book b WHERE b.annoPubblicazione=:year",
                Catalogo.class);
        query.setParameter("year", year);
        if (query.getResultList().isEmpty()) {
            throw new NotFoundYear(year);
        }
        return query.getResultList();
    }

    public List<Catalogo> trovaTitolo(String title) {
        TypedQuery<Catalogo> query = em.createQuery(
                "SELECT b FROM Book b WHERE b.titolo LIKE :title",
                Catalogo.class);
        query.setParameter("title", "%" + title + "%");
        if (query.getResultList().isEmpty()) {
            throw new NotFoundEx(title);
        }
        return query.getResultList();
    }

    public List<Catalogo> trovaAutore(String autore) {
        TypedQuery<Catalogo> query = em.createQuery(
                "SELECT b FROM Book b WHERE b.autore=:autore",
                Catalogo.class);
        query.setParameter("autore", autore);
        if (query.getResultList().isEmpty()) {
            throw new NotFoundEx(autore);
        }
        return query.getResultList();
    }

}
