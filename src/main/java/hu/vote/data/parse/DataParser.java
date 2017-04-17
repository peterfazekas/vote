package hu.vote.data.parse;

import hu.vote.model.Vote;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Peter_Fazekas on 2017.04.17..
 */
public class DataParser {

    private static final String SEPARATOR = " ";

    public List<Vote> parse(final List<String> lines) {
        return lines.stream()
                .map(this::createVote)
                .collect(Collectors.toList());
    }

    private Vote createVote(final String line) {
        String[] items = line.split(SEPARATOR);
        int constituency = Integer.parseInt(items[0]);
        int numberOfVotes = Integer.parseInt(items[1]);
        String name = items[2] + " " + items[3];
        String party = items[4];
        return new Vote(constituency, numberOfVotes, name, party);
    }
}
