package data.tree;

import data.otherStructures.Function;
import data.otherStructures.Parameter;

import static data.Data.traces;
import static data.Errors.*;
import static logger.Logger.log;

public class Tree {
    private final Node root;

    public Tree(Function function) {
        root = new Node(function);
    }

    public static String getMotherFunction(String childFunction) {
        for (String treeKey : traces.keySet()) {
            Tree tree = traces.get(treeKey);
            if (tree.getNode(tree.root, childFunction) != null)
                return tree.root.function.getName();
        }
        return NODE_NOT_FOUND_ERROR;
    }

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

    public void printAll(boolean removeTree) {
        printRecursive(root,0);
        if (removeTree) {
            removeTree();
        }
    }

    private void printRecursive(Node node, int level) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<level; ++i) {
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

    private void removeTree() {
        traces.remove(root.function.getName());
    }
}
