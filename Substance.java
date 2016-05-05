
public abstract class Substance {
    private String name;
    private boolean overdoseable;

    public Substance(String name, boolean overdoseable){
        this.name = name;
        this.overdoseable = overdoseable;
    }

    public String getName() {
        return name;
    }

    public abstract double getPercentDUI(Person person);
    @Override
    public String toString() {
        return name;
    }

    public boolean isOverdoseable() {
        return overdoseable;
    }
}
