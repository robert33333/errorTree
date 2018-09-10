package data.otherStructures;

/**
 * represents a parameter of a function
 *
 * @author Robert
 */
public class Parameter {
    /**
     * parameter name
     */
    private final String name;
    /**
     * parameter value
     */
    private final Object value;

    /**
     * Constructor
     *
     * @param name  parameter name
     * @param value parameter value
     */
    public Parameter(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    /**
     * parameter name getter
     * @return parameter name
     */
    public String getName() {
        return name;
    }

    /**
     * parameter value getter
     * @return parameter value
     */
    public Object getValue() {
        return value;
    }
}
