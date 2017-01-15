/**
 * Created by GL on 2016/12/19.
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EffectiveLines {

    /**
     * @param args
     */
    static int cntCode=0, cntNode=0, cntSpace=0;
    static boolean flagNode = false;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("E:\\workplace\\IDEA\\first\\src\\EffectiveLines\\TestFile.java"));
            String line=null;
            while((line = br.readLine()) != null)
                pattern(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("注释行： " + cntNode);
        System.out.println("空行： " + cntSpace);
        System.out.println("代码行： " + cntCode);
        System.out.println("总行： " + (cntNode+cntSpace+cntCode));

    }

    private static void pattern(String line) {
        // TODO Auto-generated method stub
        String regxNodeBegin = "\\s*/\\*.*";
        String regxNodeEnd = ".*\\*/\\s*";
        String regx = "//.*";
        String regxSpace = "\\s*";
        if(line.matches(regxNodeBegin) && line.matches(regxNodeEnd)){
            ++cntNode;
            return ;
        }
        if(line.matches(regxNodeBegin)){
            ++cntNode;
            flagNode = true;
        } else if(line.matches(regxNodeEnd)){
            ++cntNode;
            flagNode = false;
        } else if(line.matches(regxSpace))
            ++cntSpace;
        else if(line.matches(regx))
            ++cntNode;
        else if(flagNode)
            ++cntNode;
        else ++cntCode;
    }

}
