public class Alcohol extends Substance {
    private double drinkingPeriod;
    private int standardDrinkCount;

    private static final double LEGAL_LIMIT = 0.08;

    public Alcohol(int standardDrinkCount, double drinkingPeriod) {
        super("Alcohol", true);
        this.standardDrinkCount = standardDrinkCount;
        this.drinkingPeriod = drinkingPeriod;

    }


    @Override
    public double getPercentDUI(Person person) {
        return ((Person.BODY_WATER_IN_BLOOD * standardDrinkCount * 1.2)/(person.getBodyWaterConstant() * person.getMass()) - Person.METABOLISM_CONSTANT * drinkingPeriod)/ LEGAL_LIMIT;
    }

    @Override
    public String toString() {
        return standardDrinkCount + " drinks of alcohol for " + drinkingPeriod;
    }
}
