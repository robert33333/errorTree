class TestResults {
    static final String result1 = "|-> main( args = \"Argument\" )\n" +
            "\n" +
            "    |-> a( string = \"testString\" )\n" +
            "\n" +
            "        |-> b( int1 = 3, int2 = 4 )\n" +
            "\n" +
            "    |-> d( a = \"unu\", b = \"doi\" )\n" +
            "\n";

    static final String result2 = "|-> main( args = \"Argument\" )\n" +
            "\n" +
            "    |-> a( string = \"testString\" )\n" +
            "\n" +
            "        |-> b( int1 = 3, int2 = 4 )\n" +
            "\n" +
            "java.lang.NullPointerException: Something went wrong!\n" +
            "\tat Test.b(Test.java:40)\n" +
            "\tat Test.a(Test.java:31)\n" +
            "\tat Test.main(Test.java:20)\n" +
            "\tat Test.test2(Test.java:68)\n" +
            "\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n" +
            "\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n" +
            "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
            "\tat java.lang.reflect.Method.invoke(Method.java:498)\n" +
            "\tat org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)\n" +
            "\tat org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)\n" +
            "\tat org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)\n" +
            "\tat org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)\n" +
            "\tat org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)\n" +
            "\tat org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)\n" +
            "\tat org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)\n" +
            "\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n" +
            "\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n" +
            "\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n" +
            "\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n" +
            "\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n" +
            "\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n" +
            "\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\n" +
            "\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\n" +
            "\tat com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)\n" +
            "\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)\n" +
            "\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)\n";
}
