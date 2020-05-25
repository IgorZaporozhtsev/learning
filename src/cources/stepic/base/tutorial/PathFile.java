package cources.stepic.base.tutorial;

import java.io.File;
import java.io.IOException;

public class PathFile {

    public static void main(String[] args) throws IOException {


        File file1 = new File(".\\a\\b\\..\\b\\c\\.\\file.txt");
        File file2 = new File("a\\b\\c\\file.txt");

        File file3 = new File("a\\.\\b\\..\\c\\.\\file.txt");
        File file4 = new File("a\\b\\..\\file.txt");
        File file5 = new File("a\\..\\b\\c\\file.txt");

        System.out.println(file1.getCanonicalPath());
        System.out.println(file2.getCanonicalPath());
        System.out.println(file3.getCanonicalPath());
        System.out.println(file4.getCanonicalPath());
        System.out.println(file5.getCanonicalPath());
    }

}
