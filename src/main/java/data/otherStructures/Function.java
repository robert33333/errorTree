package data.otherStructures;

import java.util.ArrayList;

/**
 * represents a functioned called in the trace tree
 *
 * @author Robert
 */
public class Function {
    /**
     * function name
     */
    private final String name;
    /**
     * collection of parameters of the function
     */
    private final ArrayList<Parameter> parameterList;

    /**
     * Constructor
     * @param name function name
     * @param parameterList collection of parameters of the function
     */
    public Function(String name, ArrayList<Parameter> parameterList) {
        this.name = name;
        this.parameterList = parameterList;
    }

    /**
     * function name getter
     *
     * @return function name
     */
    public String getName() {
        return name;
    }

    /**
     * parameters getter
     * @return collection of parameters of the function
     */
    public ArrayList<Parameter> getParameterList() {
        return parameterList;
    }
}
