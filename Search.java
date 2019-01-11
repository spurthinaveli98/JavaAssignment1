import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {

    public static void main(String[] args) {



        File[] files = new File("/home/").listFiles();    //storing the files in home directory in files
        Search s=new Search();
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter the regex to match files");
            String reg = sc.next();
            s.printFiles(files,reg);             //calling printFiles with files and pattern as parameters
        }

    }

    void printFiles(File[] files,String reg){
        for (File file : files) {
            if (file.isFile()) {    //checking if it is a file
                Pattern pattern = Pattern.compile(reg);        //converting the string into pattern
                Matcher m = pattern.matcher(file.getName());
                if(m.find())                   //checking if file name matches with pattern
                    System.out.println(file.getPath());
            }
            else if(file.isDirectory()){
                File[] subfiles = new File(file.getPath()).listFiles();     //if it is a directory, call the printFiles method with new directory
                printFiles(subfiles,reg);
            }
        }

    }
}
