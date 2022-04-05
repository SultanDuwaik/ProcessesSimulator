package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        String path1 = "test1.csv"; // I saved these test cases locations in the project, but I didn't show in the video.
        String path2 = "test2.csv";
        String path3 = "test3.csv";
        String path4 = "test4.csv";
        String path5 = "test5.csv";

        System.out.println("\n\nTest Case 1\n\n");
        Simulator simulator1 = new Simulator();
        simulator1.simulate(path1);
        System.out.println("\n\nTest Case 2\n\n");
        Simulator simulator2 = new Simulator();
        simulator2.simulate(path2);
        System.out.println("\n\nTest Case 3\n\n");
        Simulator simulator3 = new Simulator();
        simulator3.simulate(path3);
        System.out.println("\n\nTest Case 4\n\n");
        Simulator simulator4 = new Simulator();
        simulator4.simulate(path4);
        System.out.println("\n\nTest Case 5\n\n");
        Simulator simulator5 = new Simulator();
        simulator5.simulate(path5);

    }
}
