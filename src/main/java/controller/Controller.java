package controller;

import data.otherStructures.Function;
import data.tree.Tree;
import logger.Logger;

import static data.Data.traces;
import static data.Errors.*;
import static data.tree.Tree.getMotherFunction;

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

    @Deprecated
    public static void printAll(String motherFunction) {
        traces.get(motherFunction).printAll(true);
    }

    public static void printException(String parentFunction, Exception exception) {
        try {
            traces.get(getMotherFunction(parentFunction)).printAll(false);
            Logger.printException(exception);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void endTrace(String motherFunction, boolean printAll) {
        try {
            if (printAll) {
                traces.get(motherFunction).printAll(false);
            }
        } catch (Exception e) {
            System.out.println(END_TRACE_ERROR);
        }
    }
}