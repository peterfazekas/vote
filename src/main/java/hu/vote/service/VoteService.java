package hu.vote.service;

import hu.vote.model.Party;
import hu.vote.model.Vote;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * @author Peter_Fazekas on 2017.04.17..
 */
public class VoteService {

    private static final int POPULATION = 12345;
    private static final int NUMBER_OF_constituency = 12345;

    private final List<Vote> votes ;

    public VoteService(List<Vote> votes) {
        this.votes = votes;
    }

    /**
     * 2. feladat: Hány képviselőjelölt indult a helyhatósági választáson?
     * @return - A megfelelő válasz
     */
    public int getNumberOfCandidates() {
        return votes.size();
    }

    /**
     * 3. feladat: Kérje be egy képviselőjelölt vezetéknevét és utónevét, majd írja ki a képernyőre, hogy
     * az illető hány szavazatot kapott! Ha a beolvasott név nem szerepel a nyilvántartásban, úgy jelenjen
     * meg a képernyőn az „Ilyen nevű képviselőjelölt nem szerepel a nyilvántartásban!” figyelmeztetés!
     * A feladat megoldása során feltételezheti, hogy nem indult két azonos nevű képviselőjelölt a választáson.
     * @param name - A jelölt neve
     * @return - A megfelelő válasz
     */
    public String getNumberOfVotesByCandidateName(final String name) {
        Optional<Integer> numberOfVotes = NumberOfVotesByCandidateName(name);
        return numberOfVotes.isPresent()
                ? "   " + name + " jelölt " + numberOfVotes.get() + " szavazatot kapott!"
                : "   Ilyen nevű képviselőjelölt nem szerepel a nyilvántartásban!";
    }

    private Optional<Integer> NumberOfVotesByCandidateName(final String name) {
        return votes.stream()
                .filter(i -> i.getName().equals(name))
                .map(i -> i.getNumberOfVotes())
                .findFirst();
    }

    /**
     * 4. feladat: Határozza meg, hányan adták le szavazatukat, és mennyi volt a részvételi arány!
     * (A részvételi arány azt adja meg, hogy a jogosultak hány százaléka vett részt a szavazáson.)
     * A részvételi arányt két tizedesjegy pontossággal, százalékos formában írja ki a képernyőre!
     * @return - A megfelelő válasz. pl.: A választáson 5001 állampolgár, a jogosultak 40,51%-a vett részt.
     */
    public String getTotalNumberOfVoters() {
        int numberOfVoters = totalNumberOfVoters();
        double percent = numberOfVoters * 100.0 / POPULATION;
        return String.format("A választáson %d állampolgár, a jogosultak %4.2f%%-a vett részt.", numberOfVoters, percent);
    }

    private int totalNumberOfVoters() {
        return votes.stream().mapToInt(i -> i.getNumberOfVotes()).sum();
    }

    /**
     * 5. feladat: Határozza meg és írassa ki a képernyőre az egyes pártokra leadott szavazatok arányát
     * az összes leadott szavazathoz képest két tizedesjegy pontossággal! A független jelölteket együtt,
     * „Független jelöltek” néven szerepeltesse!
     * @return - A megfelelő válasz. pl.: Zöldségevők Pártja= 12,34%
     */
    public String getPartyStatistic() {
        Map<Party, Integer> partyMap = createPartyStatistic();
        StringBuilder sb = new StringBuilder();
        partyMap.entrySet()
                .stream()
                .map(this::printPartyStatistic)
                .forEach(sb::append);
        return sb.toString();
    }

    private Map<Party, Integer> createPartyStatistic() {
        Map<Party, Integer> partyMap = new TreeMap<>();
        votes.forEach(i -> {
            Party key = i.getParty();
            int value = partyMap.containsKey(key) ? partyMap.get(key) : 0;
            partyMap.put(key, value + i.getNumberOfVotes());
        });
        return partyMap;
    }

    private String printPartyStatistic(Map.Entry<Party, Integer> partyData) {
        String partyName = partyData.getKey().getPartyName();
        double percent = partyData.getValue() * 100.0 / totalNumberOfVoters() ;
        return String.format("%n   - %s: %4.2f%%", partyName, percent);
    }

}
