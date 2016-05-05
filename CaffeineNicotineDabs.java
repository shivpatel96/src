import java.util.Random;


public class CaffeineNicotineDabs extends Substance {
    // no fields because the amount isn't relevant  to determining impairment
    private static Random random = new Random();
    public CaffeineNicotineDabs() {
        super("Caffeine Nicotine Dabs", false);
    }

    @Override
    public double getPercentDUI(Person person) {
        // simulate randomness of Drug Recognition Experts who decide DUIs w. This does not affect overdose calcs because
        // this cannot be overdosed on
        return Math.round(random.nextDouble());


    }
}
