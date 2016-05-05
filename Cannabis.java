public class Cannabis extends Substance {
    private double thcContent;

    public Cannabis(double thcContent) {
        super("Cannabis", false);
        this.thcContent = thcContent;
    }
    // Colorado's legal limit
    private static final double LEGAL_LIMIT = 5;
    @Override
    public double getPercentDUI(Person person) {
        return thcContent/LEGAL_LIMIT;
    }

    @Override
    public String toString() {
        return thcContent + " ng/mL of THC in the blood";
    }
}
