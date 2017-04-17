package hu.vote.model;

/**
 * @author Peter_Fazekas on 2017.04.17..
 */
public class Vote {

    private final int constituency;
    private final int numberOfVotes;
    private final String name;
    private final Party party;

    public Vote(final int constituency, final int numberOfVotes, final String name, final String party) {
        this.constituency = constituency;
        this.numberOfVotes = numberOfVotes;
        this.name = name;
        this.party = Party.fromString(party);
    }

    public int getConstituency() {
        return constituency;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public String getName() {
        return name;
    }

    public String getPartyName() {
        return party.getPartyName();
    }

    public String getShortName() {
        return party.getShortName();
    }

}
