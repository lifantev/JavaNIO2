import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Program which prints its own code.
 */
public class OwnCode {
    public static void main(String[] args) {
        // gets current directory
        Path currentDir = Paths.get("").toAbsolutePath();
        try {
            // gets Path to src directory
            Path src = Files.newDirectoryStream(currentDir, "src").iterator().next();

            // gets Path to first *.java file, it is considered that there is only one .java file
            // in this directory, so it will be the file to print
            Path javaFile = Files.newDirectoryStream(src, "*.java").iterator().next();
            try (FileChannel fileChan = (FileChannel)
                    Files.newByteChannel(javaFile,
                    StandardOpenOption.READ)) {
                // copies file to buffer
                MappedByteBuffer mappedBuff =
                        fileChan.map(FileChannel.MapMode.READ_ONLY, 0, fileChan.size());
                // prints it to System.out
                for (int i = 0; i < fileChan.size(); ++i) {
                    System.out.write(mappedBuff.get());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

