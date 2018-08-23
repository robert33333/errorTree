package data.otherStructures;

public class Parameter {
    private final String name;
    private final Object value;

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public Parameter(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
