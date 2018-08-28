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
            "java.lang.NullPointerException \n" +
            "cause: null\n" +
            "message: Something went wrong!\n" +
            "\n";
}
