public class Person {
    private String name;
    private double mass;
    private boolean male;


    private final Substance[] substances = new Substance[5];
    int index = 0;

    private static final double MALE_BODY_WATER_CONSTANT = 0.58;
    private static final double FEMALE_BODY_WATER_CONSTANT = 0.49;

    public static final double BODY_WATER_IN_BLOOD = 0.806;
    public static final double METABOLISM_CONSTANT = 0.017;

    public static final double OVERDOSE_PERCENT = 4.5;


    public Person(String name, double mass, boolean isMale) {
        this.name = name;
        this.mass = mass;
        this.male = isMale;
    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }
    public boolean isMale() {
        return male;
    }

    public double getBodyWaterConstant() {
        if (male) {
            return MALE_BODY_WATER_CONSTANT;
        } else {
            return FEMALE_BODY_WATER_CONSTANT;
        }
    }

    public String displaySubstances() {
        String text = "";
        for (int i = 0; i < index; i++) {
            text += substances[i];
            text += ", ";
        }

        return text.substring(0, text.length() - 2); // remove the trailing ", "
    }

    public void take(Substance substance) throws OverdoseException {
        if (index >= substances.length)
            throw new OverdoseException(this, substance);

        substances[index++] = substance;
    }

    public boolean getsDUI() throws OverdoseException {
        double percentDui = 0;
        double percentDuiOverdose = 0;
        for (int i = 0; i < index; i++) {
            Substance substance = substances[i];
            double currentPercent = substance.getPercentDUI(this);
            percentDui += currentPercent;
            if (substance.isOverdoseable()) {
                percentDuiOverdose += currentPercent;
            }
        }
        if (percentDuiOverdose > OVERDOSE_PERCENT) {
            throw new OverdoseException(this);
        }
        return !(percentDui < 1);
    }
}