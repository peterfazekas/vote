package hu.vote.data.read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Peter_Fazekas on 2017.04.17..
 */
public class FileDataReader implements DataRead {

    private static final String PATH = "src\\main\\resources\\";

    @Override
    public List<String> read(final String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH + fileName))) {
            return reader.lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
