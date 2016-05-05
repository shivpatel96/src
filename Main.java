import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String title = "DUI Simulator";
        System.out.println(title);
        for (int i = 0; i < title.length(); ++i) {
            System.out.print('=');
        }
        System.out.println(); System.out.println();

        System.out.print("Name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.print("Mass: ");
        double mass = scanner.nextInt();

        System.out.print("Gender (m/f): ");
        String gender = scanner.next();
        Person person = new Person(name, mass, gender.equalsIgnoreCase("m"));

        System.out.println();
        System.out.print("Did " + (person.isMale() ? "he" : "she") + " drink anything? (true/false): ");
        try {
            if (scanner.nextBoolean()) {
                System.out.print("Number of standard drinks: ");
                int number = scanner.nextInt();
                System.out.print("Hours of drinking: ");
                double hours = scanner.nextDouble();
                person.take(new Alcohol(number, hours));
            }

            String menu = "More drugs\n1) Cannabis\n2)Caffeine Nicotine Dabs\n3) Other\n0) That's it";

            boolean thereIsMore = true;
            while (thereIsMore) {
                System.out.println();
                System.out.println(menu);
                switch (scanner.nextInt()) {
                    case 0:
                        thereIsMore = false;
                        break;
                    case 1:
                        System.out.println();
                        System.out.print("THC blood content (units: ng/mL): ");
                        person.take(new Cannabis(scanner.nextDouble()));
                        break;
                    case 2:
                        person.take(new CaffeineNicotineDabs());
                        break;
                    case 3:
                        System.out.println();
                        System.out.print("Drug name: ");
                        String drugName = scanner.nextLine();
                        System.out.print("Overdosable (true/false): ");
                        person.take(new InstantDUISubstance(name, scanner.nextBoolean()));
                        break;
                }
                System.out.println();
            }
            System.out.println(person.getName() + " is on " + person.displaySubstances());
            System.out.println(person.getName() + (person.getsDUI() ? " gets " : " does not get ") + "a DUI.");
        } catch (OverdoseException overdose) {
            System.out.println(overdose.getMessage());
        }

    }
}
