package com.netcracker.edu.docjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Program which reads file with java documentation from doc.txt
 * until the word 'java' (ignoring case) occurs three times.
 */
public class DocJava {
    public static void main(String[] args) {
        try (BufferedReader br =
                     Files.newBufferedReader(Paths.get("src/com/netcracker/edu/docjava/doc.txt"),
                             StandardCharsets.UTF_8)) {
            StreamTokenizer st = new StreamTokenizer(br);

            int tokenType;
            int count = 0;
            String word = null;
            while (count != 3 && (tokenType = st.nextToken()) != StreamTokenizer.TT_EOF) {
                if (tokenType == StreamTokenizer.TT_WORD) {
                    word = st.sval;
                    if ("java".equalsIgnoreCase(word)) {
                        count++;
                    }
                }
                System.out.println(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
