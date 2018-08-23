package data.otherStructures;

import java.util.List;

public class Function {
    private final String name;
    private final List<Parameter> parameterList;

    public String getName() {
        return name;
    }

    public List<Parameter> getParameterList() {
        return parameterList;
    }

    public Function(String name, List<Parameter> parameterList) {
        this.name = name;
        this.parameterList = parameterList;
    }
}
