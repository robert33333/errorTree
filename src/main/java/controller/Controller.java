package controller;

import data.otherStructures.Function;
import data.tree.Tree;
import logger.Logger;

import static data.Data.traces;
import static data.Errors.*;
import static data.tree.Tree.getMotherFunction;

/**
 * contains the main logic of the app
 *
 * @author Robert
 */
public class Controller {
    /**
     * creates a new trace tree
     * @param function root node of the new tree
     */
    public static void startTrace(Function function) {
        try {
            traces.put(function.getName(), new Tree(function));
        }catch (Exception e) {
            System.out.println(START_TRACE_ERROR);
            e.printStackTrace();
        }
    }

    /**
     * adds a function in the trace tree
     * @param parentFunction parent node for current function; needs to be unique
     * @param function node that will be inserted
     * @throws Exception if node could not be inserted
     */
    public static void addFunction(String parentFunction, Function function) throws Exception {
        for (String treeKey : traces.keySet()) {
            if (traces.get(treeKey).addNode(parentFunction, function))
                return;
        }
        throw new Exception(ADD_NODE_ERROR);
    }

    /**
     * prints a whole trace tree
     * @param motherFunction root of the trace tree
     */
    @Deprecated
    public static void printAll(String motherFunction) {
        traces.get(motherFunction).printAll(true);
    }

    /**
     * prints a whole trace tree and an exception that occurred
     * @param parentFunction root of the trace tree
     * @param exception exception that occurred
     */
    public static void printException(String parentFunction, Exception exception) {
        try {
            traces.get(getMotherFunction(parentFunction)).printAll(false);
            Logger.printException(exception);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * terminates the trace for a particular starting function
     * @param motherFunction root node of  the trace tree
     * @param printAll if true it will print trace tree before deleting it
     */
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