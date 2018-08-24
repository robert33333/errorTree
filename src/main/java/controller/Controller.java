package controller;

import data.otherStructures.Function;
import data.tree.Tree;

import static data.Data.traces;
import static data.Errors.ADD_NODE_ERROR;
import static data.Errors.START_TRACE_ERROR;

public class Controller {
    public static void startTrace(Function function) {
        try {
            traces.put(function.getName(), new Tree(function));
        }catch (Exception e) {
            System.out.println(START_TRACE_ERROR);
            e.printStackTrace();
        }
    }

    //Parent function needs to be unique
    //Otherwise the application might assign the function to the wrong parent
    public static void addFunction(String parentFunction, Function function) throws Exception {
        for (String treeKey : traces.keySet()) {
            if (traces.get(treeKey).addNode(parentFunction, function))
                return;
        }
        throw new Exception(ADD_NODE_ERROR);
    }

    public static void printAll(String motherFunction) {
        traces.get(motherFunction).printAll(true);
    }

    public static void endTrace(String motherFunction, boolean printAll) {
        if (printAll) {
            traces.get(motherFunction).printAll(false);
        }
        traces.remove(motherFunction);
    }
}