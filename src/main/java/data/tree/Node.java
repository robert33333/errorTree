package data.tree;

import data.otherStructures.Function;

import java.util.ArrayList;
import java.util.List;

class Node {
    final Function function;
    final List <Node> children = new ArrayList<>();

    public Node(Function function) {
        this.function = function;
    }
}
