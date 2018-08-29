import data.otherStructures.Function;
import data.otherStructures.Parameter;
import logger.Logger;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static controller.Controller.*;
import static data.Errors.GENERIC_ERROR;
import static junit.framework.TestCase.assertEquals;

public class Test {
    private static void main(boolean testException, boolean printAll) throws Exception {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter("args", "Argument"));
        startTrace(new Function("main", parameters));

        a(testException);
        d();

        endTrace("main", printAll);
    }

    private static void a(boolean testException) throws Exception {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter("string", "testString"));
        addFunction("main", new Function("a", parameters));

        b(testException);
    }

    private static void b(boolean testException) throws Exception {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter("int1", 3));
        parameters.add(new Parameter("int2", 4));
        addFunction("a", new Function("b", parameters));
        if (testException) {
            printException("b", new NullPointerException(GENERIC_ERROR));
        }
    }

    private static void d() throws Exception {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter("a", "unu"));
        parameters.add(new Parameter("b", "doi"));
        addFunction("main", new Function("d", parameters));
    }

    @org.junit.Test
    public void test1() {
        try {
            Logger.initialize("testLogFile", false);
            main(false, true);
            String text = new String(Files.readAllBytes(Paths.get("testLogFile")), StandardCharsets.UTF_8);
            assertEquals(text, TestResults.result1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@org.junit.Test
    public void test2() {
        try {
            Logger.initialize("testLogFile", false);
            main(true, false);
            String text = new String(Files.readAllBytes(Paths.get("testLogFile")), StandardCharsets.UTF_8);
            assertEquals(text, TestResults.result2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
