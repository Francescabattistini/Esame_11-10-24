package francescaBattistini;

import dao.CatalogoDao;
import entities.Catalogo;
import entities.Libro;
import entities.Rivista;
import enums.PeriodicitàType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");

public static void main(String[] args) {
    EntityManager em = emf.createEntityManager();
    //System.out.println("hello a mammeta"); l'ho lasciato come cameo hahaha era una prova all'inizio perchè
    // non mi funzionava il persistence(mi ero dimenticata il meta-inf XD)
    System.out.println("vari DAO");
    CatalogoDao catalogoDao = new CatalogoDao(em);
            //--------0 SAVE---------//
    System.out.println("Prima parte Save");
    Libro thewitcher = new Libro(2300,"il guardiano degli innocenti",1993,400,"Andrzej Sapkowski", "fantasy");
//catalogoDao.save(thewitcher);
    Libro thewitcher2 = new Libro(1230,"La spada del destino",1992,300,"Andrzej Sapkowski", "fantasy");
   //catalogoDao.save(thewitcher2);
    Libro thewitcher3 = new Libro(2400,"Il sangue degli elfi",1994,425,"Andrzej Sapkowski", "fantasy");
  //catalogoDao.save(thewitcher3);
    Rivista RollingStones = new Rivista(1435,"Sister of Mercy",1981,300,PeriodicitàType.MENSILE);
 //catalogoDao.save(RollingStones);
    Rivista RollingStones2 = new Rivista(3457,"Talking heads",1976,234,PeriodicitàType.MENSILE);
    //catalogoDao.save(RollingStones2);
    Rivista H_P_Lovecraft  = new Rivista(3557,"cthulhu",1929,300,PeriodicitàType.SETTIMANALE);
    //catalogoDao.save(H_P_Lovecraft);
 // --------ISBN----//
    System.out.println("seconda parte ISBN");

   //1. elimino tramitte codice isbn
    catalogoDao.delete(3557);
    //2.Ricerca tramite codice isbn
    Catalogo IdLibro1 = catalogoDao.TrovaId(2300);
    //3.ricerca anno pubicazione
    //4. ricerca autore
    //5.ricerca per titolo o una parte di esso
    //6.ricerca degli elemente attualmente in prestito dato un numero di tessera utente
    //7.ricerca di tutti i prestiti scaduti e non ancora restituiti
}
}
