package com.man1s.designmodel;


import org.apache.commons.io.input.ReaderInputStream;

import java.io.*;

public class Decorator {
    public static void main(String[] args) {
        try {

            InputStream is = new BufferedInputStream(new FileInputStream(""));
            new ReaderInputStream(new FileReader(""));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //
    }
}
