package test;

import data.otherStructures.Function;
import data.otherStructures.Parameter;

import java.util.ArrayList;

import static controller.Controller.addFunction;
import static controller.Controller.printAll;
import static controller.Controller.startTrace;

public class Main {
    public static void main(String[] args) {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter("args",args.toString()));
        startTrace(new Function("main",parameters));

        a("testString");
    }

    public static void a(String string) {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter("string",string));
        addFunction("main","main",new Function("a",parameters));

        b(3,4);
    }

    public static void b(int int1, int int2) {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter("int1",int1));
        parameters.add(new Parameter("int2",int2));
        addFunction("main","a",new Function("b",parameters));

        printAll("main");
    }
}
