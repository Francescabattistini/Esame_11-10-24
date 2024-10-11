package francescaBattistini;

import dao.CatalogoDao;
import dao.PrestitoDao;
import dao.UtenteDao;
import entities.*;
import enums.PeriodicitàType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Application {
private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");

public static void main(String[] args) {
    EntityManager em = emf.createEntityManager();
    //System.out.println("hello a mammeta"); l'ho lasciato come cameo hahaha era una prova all'inizio perchè
    // non mi funzionava il persistence(mi ero dimenticata il meta-inf XD)
    System.out.println("vari DAO");
    CatalogoDao catalogoDao = new CatalogoDao(em);
    UtenteDao utenteDao = new UtenteDao(em);
    PrestitoDao prestitoDao = new PrestitoDao(em);
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


    System.out.println("1.elimino tramitte codice isbn");
    //catalogoDao.delete(3557);

    System.out.println("2.Ricerca tramite codice isbn");
    //Catalogo IdLibro1 = catalogoDao.TrovaId(2300);
 /*   System.out.println("3.ricerca anno pubicazione");
    List<Catalogo> libriTrovatiPerAnno = catalogoDao.trovaAnno(1992);
    libriTrovatiPerAnno.forEach(System.out::println);
    System.out.println("4. ricerca autore");
    List<Catalogo> libriTrovatiPerAutore = catalogoDao.trovaAutore("Andrzej Sapkowski");
    libriTrovatiPerAutore.forEach(System.out::println);
     System.out.println("5.ricerca per titolo o una parte di esso");
    List<Catalogo> libriTrovatiPerTitolo = catalogoDao.trovaTitolo("dest");
    libriTrovatiPerTitolo.forEach(System.out::println);*/
    System.out.println("6.ricerca degli elemente attualmente in prestito dato un numero di tessera utente");
    System.out.println("Creazione utenti");

    Utente Silvia = new Utente("Silvia", "Marelli", LocalDate.of(1980, 12, 31));
    Utente Chiara = new Utente("Chiara", "Di Luca", LocalDate.of(1987, 11, 24));

    //utenteDao.save(Silvia);
    //utenteDao.save(Chiara);
    System.out.println("Creazione Prestiti");
    Prestito prestitoLibro = new Prestito(Silvia, thewitcher3, LocalDate.now(), null);
    Prestito prestitoLibro2 = new Prestito(Chiara,thewitcher, LocalDate.now(), null);
    Prestito prestitoLibro3 = new Prestito(Silvia, thewitcher2, LocalDate.now().minusDays(30), LocalDate.now());
   Prestito prestitoRivista = new Prestito(Chiara, RollingStones2, LocalDate.now().minusDays(10), null);
   //prestitoDao.save( prestitoLibro);
   // prestitoDao.save(prestitoLibro2);
    //prestitoDao.save(prestitoLibro3);
    //prestitoDao.save(prestitoRivista);

    //7.ricerca di tutti i prestiti scaduti e non ancora restituiti
    List<Prestito> trovaElementodallaTessera = prestitoDao.trovaTessera(253);
    trovaElementodallaTessera.forEach(System.out::println);

}
}
