package data.otherStructures;

import java.util.ArrayList;

public class Function {
    private final String name;
    private final ArrayList<Parameter> parameterList;

    public String getName() {
        return name;
    }

    public Function(String name, ArrayList<Parameter> parameterList) {
        this.name = name;
        this.parameterList = parameterList;
    }

    public ArrayList<Parameter> getParameterList() {
        return parameterList;
    }
}
