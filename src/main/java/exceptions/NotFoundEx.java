package exceptions;

public class NotFoundEx extends RuntimeException {
    public NotFoundEx(long id) {
        super("L'elemento " + id + " non è stato trovato");
    }

    public NotFoundEx(String stringa) {

        super("L'autore o titolo  " + stringa + " non è stato trovato");
    }

    public NotFoundEx() {
        super(" Bene, non abbiamo nessun prestito in attesa");
    }

}
