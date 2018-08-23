package controller;

import data.otherStructures.Function;
import data.tree.Tree;

import static data.Data.traces;
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

    public static void addFunction(String motherFunction, String parentFunction, Function function) {
        traces.get(motherFunction).addNode(parentFunction,function);
    }

    public static void printAll(String motherFunction) {
        traces.get(motherFunction).printAll(true);
    }
}