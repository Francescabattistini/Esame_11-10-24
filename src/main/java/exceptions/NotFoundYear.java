package exceptions;

public class NotFoundYear extends RuntimeException {
    public NotFoundYear(Long year) {
        super("Non ho trovato riviste o libri con l' "+year+ " mi dispiace");
    }
}
