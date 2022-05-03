import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException{
        FileInputStream fileInputStream = null;
        String str = "";
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        FileOutputStream fileOutputStream = null;
        try {
            int c = -1;
            try {
                fileInputStream = new FileInputStream("signatures.txt");
            }
            catch (FileNotFoundException e)
            {
                System.out.println("File Not Found Exception");
                System.exit(0);
            }
            while ((c = fileInputStream.read()) != -1)
            {
                if ((char)c != '\n')
                {
                    str += (char)c;

                }
                else if ((char)c == '\n')
                {
                    String[] str1 = str.split(", ");
                    map.put(str1[1], str1[0]);
                    str = "";
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String path = "";
        while (!(path = scanner.nextLine()).equals("42"))
        {
            try {
                fileInputStream = new FileInputStream(path);
                int r;
                int i = 0;
                String hex = "";
                while ((r = fileInputStream.read()) != -1 && i < 10)
                {
                    hex += String.format("%02X ", r);
                    ++i;
                }
                fileOutputStream = new FileOutputStream(" result.txt", true);
                boolean proc = false;
                for (String key : map.keySet()) {
                    if (hex.startsWith(key)) {
                        String value = map.get(key);
                        fileOutputStream.write(value.getBytes());
                        fileOutputStream.write('\n');
                        System.out.println("PROCESSED");
                        proc = true;
                        break;
                    }
                }
                if (!proc)
                {
                    System.out.println("UNDEFINED");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (fileInputStream  != null)
            fileInputStream.close();
        if (fileOutputStream  != null)
        fileOutputStream.close();
    }

}
