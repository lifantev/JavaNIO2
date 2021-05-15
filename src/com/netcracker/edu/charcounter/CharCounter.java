package com.netcracker.edu.charcounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Program which counts the number of entered character in the file.
 */
public class CharCounter {
    public static void main(String[] args) {
        if (args.length > 0) {
            char ch = args[0].charAt(0);
            try (BufferedReader br =
                         Files.newBufferedReader(Paths.get("src/com/netcracker/edu/docjava/doc.txt"),
                                 StandardCharsets.UTF_8)) {
                int chRead;
                int count = 0;
                do {
                    chRead = br.read();
                    if (chRead != -1) {
                        count += (ch == (char) chRead) ? 1 : 0;
                    }
                } while (chRead != -1);
                System.out.println("\nNumber of '" + ch + "' occurrence = " + count);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
