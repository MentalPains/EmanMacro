/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.eg;
import java.io.PrintStream;

public final class et {
    public static void a(PrintStream printStream, String string, double[][] dArray) {
        printStream.println(string);
        et.a(1024, dArray.length);
        printStream.println("    { ");
        int n = 0;
        double[][] dArray2 = dArray;
        int n2 = dArray.length;
        for (int i = 0; i < n2; ++i) {
            double[] dArray3 = dArray2[i];
            printStream.print("        {");
            for (double d : dArray3) {
                printStream.printf("%-25.25s", et.a(d));
            }
            printStream.println("}, // " + n++);
        }
        printStream.println("    };");
    }

    public static void a(PrintStream printStream, String object, int n, double[] dArray) {
        printStream.println((String)object + "=");
        et.a(n, dArray.length);
        printStream.println("    {");
        object = dArray;
        n = dArray.length;
        for (int i = 0; i < n; ++i) {
            Object object2 = object[i];
            printStream.printf("        %s%n", et.a((double)object2));
        }
        printStream.println("    };");
    }

    private static String a(double d) {
        double d2 = d;
        if (d2 != d2) {
            return "Double.NaN,";
        }
        return (d >= 0.0 ? "+" : "") + Double.toString(d) + "d,";
    }

    private static void a(int n, int n2) {
        if (n != n2) {
            throw new eg(n2, n);
        }
    }

    static {
        double[][] dArrayArray = new double[][]{{2.0, 0.0}, {0.6666666269302368, 3.9736429850260626E-8}, {0.3999999761581421, 2.3841857910019882E-8}, {0.2857142686843872, 1.7029898543501842E-8}, {0.2222222089767456, 1.3245471311735498E-8}, {0.1818181574344635, 2.4384203044354907E-8}, {0.1538461446762085, 9.140260083262505E-9}, {0.13333332538604736, 9.220590270857665E-9}, {0.11764700710773468, 1.2393345855018391E-8}, {0.10526403784751892, 8.251545029714408E-9}, {0.0952233225107193, 1.2675934823758863E-8}, {0.08713622391223907, 1.1430250008909141E-8}, {0.07842259109020233, 2.404307984052299E-9}, {0.08371849358081818, 1.176342548272881E-8}, {0.03058958f, 1.2958646899018938E-9}, {0.14982303977012634, 1.225743062930824E-8}};
    }
}
