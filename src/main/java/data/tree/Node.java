package data.tree;

import data.otherStructures.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a node in the trace tree
 *
 * @author Robert
 */
class Node {
    /**
     * contains details about a function called in the trace tree
     */
    final Function function;
    /**
     * contains details about this node's children
     */
    final List <Node> children = new ArrayList<>();

    /**
     * Constructor
     * @param function details about a function called in the trace tree
     */
    public Node(Function function) {
        this.function = function;
    }
}
