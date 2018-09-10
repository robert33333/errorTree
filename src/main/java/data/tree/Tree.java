package data.tree;

import data.otherStructures.Function;
import data.otherStructures.Parameter;

import static data.Data.traces;
import static data.Errors.*;
import static logger.Logger.log;

/**
 * Represents a tree like data structure
 *
 * @author Robert
 */
public class Tree {
    /**
     * root of the tree
     * represents the starting function in the trace tree
     */
    private final Node root;

    /**
     * Constructor
     * @param function root node; represents the starting function in the trace tree
     */
    public Tree(Function function) {
        root = new Node(function);
    }

    /**
     * gets the the name of the function in the root node of the tree
     * @param childFunction name of a function that represents a child of the tree
     * @return name of the function in the root of the tree if find or an error
     */
    public static String getMotherFunction(String childFunction) {
        for (String treeKey : traces.keySet()) {
            Tree tree = traces.get(treeKey);
            if (tree.getNode(tree.root, childFunction) != null)
                return tree.root.function.getName();
        }
        return NODE_NOT_FOUND_ERROR;
    }

    /**
     * adds a node to a trace tree
     * @param parent the node who will become the parent of the new node
     * @param function details about a function called in the trace tree
     * @return true if the node was added successfully, false otherwise
     */
    public boolean addNode(String parent, Function function) {
        try {
            Node node = getNode(root, parent);
            if (node != null) {
                node.children.add(new Node(function));
                return true;
            }
        }catch (Exception e) {
            System.out.println(ADD_NODE_ERROR);
            e.printStackTrace();
        }
        return false;
    }

    /**
     * searches for a node recursively until find one with a function that matches the required function name
     * @param node the node that is currently being processed
     * @param parent the node that is being searched for
     * @return node object or null if node was  not find
     */
    @org.jetbrains.annotations.Nullable
    private Node getNode(Node node, String parent) {
        try {
            if (node.function.getName().equals(parent))
                return node;
            for (Node node1 : node.children) {
                Node result = getNode(node1, parent);
                if (result != null) {
                    return result;
                }
            }
        }catch (Exception e) {
            System.out.println(PARENT_NOT_FOUND);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * prints the whole trace tree
     * @param removeTree if true, the trace tree will be removed upon printing
     */
    public void printAll(boolean removeTree) {
        printRecursive(root,0);
        if (removeTree) {
            removeTree();
        }
    }

    /**
     * prints the whole trace tree recursively
     * @param node the node that is currently being processed
     * @param level how deep the recursion has went down the tree
     */
    private void printRecursive(Node node, int level) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<level; ++i) {
            stringBuilder.append("    ");
        }
        stringBuilder.append("|-> ");
        stringBuilder.append(node.function.getName());
        if (!node.function.getParameterList().isEmpty()) {
            stringBuilder.append("( ");
            for (Parameter parameter : node.function.getParameterList()) {
                stringBuilder.append(parameter.getName()).append(" = ").append(getStringRepresentation(parameter.getValue())).append(", ");
            }
            int length = stringBuilder.length();
            stringBuilder.delete(length - 2, length - 1);
            stringBuilder.append(')');
        }
        log(stringBuilder.append('\n').toString());

        for (Node node1 : node.children) {
            printRecursive(node1,level+1);
        }
    }

    /**
     * specifies how a particular object will be printed in the log file
     * @param o object processed
     * @return string representation of the object
     */
    private String getStringRepresentation(Object o) {
        if (o == null)
            o = "NULL";
        switch (o.getClass().getName()) {
            case "java.lang.String":
                return '\"' + o.toString() + '\"';
            default:
                return o.toString();
        }
    }

    /**
     * removes trace tree from the list of trace trees
     */
    private void removeTree() {
        traces.remove(root.function.getName());
    }
}
