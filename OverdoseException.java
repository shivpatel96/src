
public class OverdoseException extends Exception {
    public OverdoseException(Person person, Substance finalStraw) {
        super(person.getName() + " overdosed on " + person.displaySubstances() +
                " and " + finalStraw.toString());
    }

    public OverdoseException(Person person) {
        super(person.getName() + " overdosed on " + person.displaySubstances());
    }
}
