import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSearch {

    public static void main(String[] args) {



        File[] files = new File("/home/").listFiles();    //storing all files of home directory in files.
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println("Enter the regex to match files");
            String reg = sc.next();
            printMatchedFiles(files,reg);
            System.out.println("Enter 'z' to exit");
            String exit = sc.next();
            if( exit.equals("Z") || exit.equals("z"))
            break;


        }

    }

    /*
    * printMatchedFiles method prints all the files that matches with the Regular Expression.
    *@param : files
    * Contains all files of home directory.
    *@param : reg
    * Contains the entered regular Expression.
     */
    static void printMatchedFiles(File[] files, String reg){
        for (File file : files) {
            if (file.isFile()) {    //checking if it is a file
                Pattern pattern = Pattern.compile(reg);        //converting the string into pattern
                Matcher m = pattern.matcher(file.getName());
                if(m.find())                   //checking if file name matches with pattern
                    System.out.println(file.getPath());
            }
            else if(file.isDirectory()){
                File[] subfiles = new File(file.getPath()).listFiles();     //if it is a directory, call the printMatchedFiles method with new directory
                printMatchedFiles(subfiles,reg);
            }
        }

    }
}
