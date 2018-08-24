import data.otherStructures.Function;
import data.otherStructures.Parameter;
import logger.Logger;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static controller.Controller.*;
import static junit.framework.TestCase.assertEquals;

public class Test {
    private static void main() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter("args", "Argument"));
        startTrace(new Function("main", parameters));

        a();
        d();
    }

    private static void a() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter("string", "testString"));
        addFunction("main", "main", new Function("a", parameters));

        b();
    }

    private static void b() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter("int1", 3));
        parameters.add(new Parameter("int2", 4));
        addFunction("main", "a", new Function("b", parameters));
    }

    private static void d() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter("a", "unu"));
        parameters.add(new Parameter("b", "doi"));
        addFunction("main", "main", new Function("d", parameters));

        printAll("main");
    }

    @org.junit.Test
    public void test1() {
        try {
            Logger.initialize("testLogFile", false);
            main();
            String text = new String(Files.readAllBytes(Paths.get("testLogFile")), StandardCharsets.UTF_8);
            assertEquals(text, "main(args = Argument)\n" +
                    " a(string = testString)\n" +
                    "  b(int1 = 3,int2 = 4)\n" +
                    " d(a = unu,b = doi)\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
