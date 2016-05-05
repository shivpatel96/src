
public class InstantDUISubstance extends Substance {
    public InstantDUISubstance(String substance, boolean overdoseable) {
        super(substance, overdoseable);
    }

    @Override
    public double getPercentDUI(Person person) {
        return 1;
    }
}
