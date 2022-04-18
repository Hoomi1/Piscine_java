package day00.ex04;

import java.util.Scanner;

public class Program {
    public static final int MAX_SIZE_CHAR = 65535;
    public static final int TOP_COL_CHAR = 10;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        char[] str_c;
        short[] i_c = new short[MAX_SIZE_CHAR];
        char[] top_arr = new char[TOP_COL_CHAR];
        char[] stat = new char[TOP_COL_CHAR];
        if (!scanner.hasNextLine())
        {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
        String str = scanner.nextLine();
        if (str.length() > 999)
        {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        str_c = str.toCharArray();
        for (int i = 0; i < str_c.length; i++) {
            i_c[str_c[i]]++;
        }
        for (int i = 0; i < i_c.length; i++) {
            short num = i_c[i];
            if (num != 0)
            {
                for (int j = 0; j < top_arr.length; j++) {
                    if (num > i_c[top_arr[j]])
                    {
                        int index = j;
                        for (int k = 0; k < index; k++) {
                            stat[k] = top_arr[k];
                        }
                        stat[index] = (char) i;
                        for (int k = index + 1; k < top_arr.length; k++) {
                            stat[k] = top_arr[k - 1];
                        }
                        top_arr = stat;
                        break;
                    }

                }
            }
        }
        for (int j = 0; j < top_arr.length; j++)
        {
            System.out.println(top_arr[j]);
        }
        printGraph(top_arr, i_c);
    }

    private static void printGraph(char[] topTenChars, short[] charCount) {
        short max = charCount[topTenChars[0]];
        byte maxHeight = (byte) (max <= 10 ? max : 10);
        byte totalLines = (byte) (2 + maxHeight);
        byte[] graphs = new byte[TOP_COL_CHAR];

        for (int i = 0; i < TOP_COL_CHAR; i++) {
            if (max <= 10) {
                graphs[i] = (byte) charCount[topTenChars[i]];
            } else {
                graphs[i] = (byte) (charCount[topTenChars[i]] * 10 / max);
            }
        }
        System.out.println();
        for (int i = 0; i < totalLines; i++) {
            for (int j = 0; j < TOP_COL_CHAR; j++) {
                if (topTenChars[j] != 0) {
                    if (i + graphs[j] + 2 == totalLines) {
                        System.out.printf("%3d", charCount[topTenChars[j]]);
                    } else if (i == totalLines - 1) {
                        System.out.printf("%3c", topTenChars[j]);
                    } else if (i + graphs[j] >= maxHeight) {
                        System.out.printf("%3c", '#');
                    }
                    if (j != TOP_COL_CHAR - 1 && topTenChars[j + 1] != 0 && i + graphs[j + 1] >= maxHeight) {
                        System.out.printf("%c", ' ');
                    }
                }
            }
            System.out.println();
        }
    }
}
