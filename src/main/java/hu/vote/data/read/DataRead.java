package hu.vote.data.read;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.04.17..
 */
public interface DataRead {

    List<String> read(final String fileName);

}
