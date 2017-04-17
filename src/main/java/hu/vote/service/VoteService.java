package hu.vote.service;

import hu.vote.model.Party;
import hu.vote.model.Vote;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author Peter_Fazekas on 2017.04.17..
 */
public class VoteService {


    private final List<Vote> votes;
    private final int population;

    public VoteService(final List<Vote> votes, final int population) {
        this.votes = votes;
        this.population = population;
    }

    /**
     * 2. feladat: Hány képviselőjelölt indult a helyhatósági választáson?
     *
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
     *
     * @param name - A jelölt neve
     * @return - A megfelelő válasz
     */
    public String getNumberOfVotesByCandidateName(final String name) {
        Optional<Integer> numberOfVotes = NumberOfVotesByCandidateName(name);
        return numberOfVotes.map(integer -> "   " + name + " jelölt " + integer + " szavazatot kapott!")
                .orElse("   Ilyen nevű képviselőjelölt nem szerepel a nyilvántartásban!");
    }

    private Optional<Integer> NumberOfVotesByCandidateName(final String name) {
        return votes.stream()
                .filter(i -> i.getName().equals(name))
                .map(Vote::getNumberOfVotes)
                .findFirst();
    }

    /**
     * 4. feladat: Határozza meg, hányan adták le szavazatukat, és mennyi volt a részvételi arány!
     * (A részvételi arány azt adja meg, hogy a jogosultak hány százaléka vett részt a szavazáson.)
     * A részvételi arányt két tizedesjegy pontossággal, százalékos formában írja ki a képernyőre!
     *
     * @return - A megfelelő válasz. pl.: A választáson 5001 állampolgár, a jogosultak 40,51%-a vett részt.
     */
    public String getTotalNumberOfVoters() {
        int numberOfVoters = totalNumberOfVoters();
        double percent = numberOfVoters * 100.0 / population;
        return String.format("A választáson %d állampolgár, a jogosultak %4.2f%%-a vett részt.", numberOfVoters, percent);
    }

    private int totalNumberOfVoters() {
        return votes.stream()
                .mapToInt(Vote::getNumberOfVotes)
                .sum();
    }

    /**
     * 5. feladat: Határozza meg és írassa ki a képernyőre az egyes pártokra leadott szavazatok arányát
     * az összes leadott szavazathoz képest két tizedesjegy pontossággal! A független jelölteket együtt,
     * „Független jelöltek” néven szerepeltesse!
     *
     * @return - A megfelelő válasz. pl.: Zöldségevők Pártja= 12,34%
     */
    public String getPartyStatistic() {
        StringBuilder sb = new StringBuilder();
        createPartyStatistic().entrySet()
                .stream()
                .map(this::printPartyStatistic)
                .forEach(sb::append);
        return sb.toString();
    }

    private Map<Party, Integer> createPartyStatistic() {
        Map<Party, Integer> partyMap = new TreeMap<>();
        votes.forEach(i -> {
            Party key = i.getParty();
            int value = partyMap.getOrDefault(key, 0);
            partyMap.put(key, value + i.getNumberOfVotes());
        });
        return partyMap;
    }

    private String printPartyStatistic(final Map.Entry<Party, Integer> partyData) {
        String partyName = partyData.getKey().getPartyName();
        double percent = partyData.getValue() * 100.0 / totalNumberOfVoters();
        return String.format("%n   - %s= %4.2f%%", partyName, percent);
    }

    /**
     * 6. feladat: Melyik jelölt kapta a legtöbb szavazatot? Jelenítse meg a képernyőn a képviselő vezeték és
     * utónevét, valamint az őt támogató párt rövidítését, vagy azt, hogy független! Ha több ilyen képviselő
     * is van, akkor mindegyik adatai jelenjenek meg!
     *
     * @return - A megfelelő válasz.
     */
    public String getMostPopularCandidates() {
        StringBuilder sb = new StringBuilder();
        getMostPopularCandidateList().stream()
                .map(this::printMostPopularCandidateList)
                .forEach(sb::append);
        return sb.toString();
    }

    private String printMostPopularCandidateList(final Vote vote) {
        return String.format("%n   - %s - %s", vote.getName(), vote.getParty().getShortName());
    }

    private List<Vote> getMostPopularCandidateList() {
        return votes.stream()
                .filter(i -> i.getNumberOfVotes() == getMaximumNumberOfVotes())
                .collect(Collectors.toList());
    }

    private int getMaximumNumberOfVotes() {
        return votes.stream()
                .mapToInt(Vote::getNumberOfVotes)
                .max()
                .getAsInt();
    }

    /**
     * 7. feladat: Határozza meg, hogy az egyes választókerületekben kik lettek a képviselők! Írja ki
     * a választókerület sorszámát, a győztes vezeték- és utónevét, valamint az őt támogató párt rövidítését,
     * vagy azt, hogy független egy-egy szóközzel elválasztva a kepviselok.txt nevű szöveges fájlba!
     * Az adatok a választókerületek száma szerinti sorrendben jelenjenek meg!
     * Minden sorba egy képviselő adatai kerüljenek!
     *
     * @return - A megfelelő válasz.
     */
    public String getRepresentatives() {
        StringBuilder sb = new StringBuilder();
        Representatives().entrySet()
                .stream()
                .map(this::printRepresentative)
                .forEach(sb::append);
        return sb.toString();
    }

    private String printRepresentative(final Map.Entry<Integer, Vote> representativeData) {
        Vote representative = representativeData.getValue();
        return String.format("%d %s %s%n", representative.getConstituency(), representative.getName(),
                representative.getParty().getShortName());
    }

    private Map<Integer, Vote> Representatives() {
        Map<Integer, Vote> winnerMap = new TreeMap<>();
        int max = getMaximumNumberOfConstituency();
        for (int i = 1; i <= max; i++) {
            winnerMap.put(i, getRepresentativeByConstituency(i));
        }
        return winnerMap;
    }

    private Vote getRepresentativeByConstituency(int constituency) {
        return votes.stream()
                .filter(i -> i.getConstituency() == constituency)
                .sorted((v1, v2) -> Long.compare(v2.getNumberOfVotes(), v1.getNumberOfVotes()))
                .findFirst()
                .get();
    }

    private int getMaximumNumberOfConstituency() {
        return votes.stream()
                .mapToInt(Vote::getConstituency)
                .max()
                .getAsInt();
    }

}
