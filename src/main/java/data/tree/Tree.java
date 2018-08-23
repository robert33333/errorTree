package data.tree;

import data.otherStructures.Function;
import data.otherStructures.Parameter;

import static data.Data.traces;
import static data.Errors.ADD_NODE_ERROR;
import static data.Errors.PARENT_NOT_FOUND;
import static logger.Logger.log;

public class Tree {
    private final Node root;

    public Tree(Function function) {
        root = new Node(function);
    }

    public void addNode(String parent, Function function) {
        try {
            Node node = getNode(root, parent);
            if (node != null) {
                node.children.add(new Node(function));
            }
        }catch (Exception e) {
            System.out.println(ADD_NODE_ERROR);
            e.printStackTrace();
        }
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
            stringBuilder.append(' ');
        }
        stringBuilder.append(node.function.getName());
        if (!node.function.getParameterList().isEmpty()) {
            stringBuilder.append('(');
            for (Parameter parameter : node.function.getParameterList()) {
                stringBuilder.append(parameter.getName()).append(" = ").append(parameter.getValue()).append(",");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.append(')');
        }
        log(stringBuilder.toString());

        for (Node node1 : node.children) {
            printRecursive(node1,level+1);
        }
    }

    private void removeTree() {
        traces.remove(root.function.getName());
    }
}
