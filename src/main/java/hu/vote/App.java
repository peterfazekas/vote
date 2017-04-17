package hu.vote;

import hu.vote.data.log.DataLogger;
import hu.vote.data.log.FileDataLogger;
import hu.vote.data.service.Data;
import hu.vote.service.Console;
import hu.vote.service.VoteService;

/**
 * @author Peter_Fazekas on 2017.04.17..
 */
public class App {

    private static final String INPUT = "szavazatok.txt";
    public static final String OUTPUT = "kepviselok.txt";

    private final VoteService vote;
    private final Console console;
    private final DataLogger log;

    public App() {
        console = new Console();
        Data data = new Data();
        vote = data.createNewInstance(INPUT);
        log = new FileDataLogger(OUTPUT);
    }

    public static void main(String[] args) {
        App app = new App();
        app.println();
    }

    private void println() {
        System.out.println(String.format("2. feladat: A helyhatósági választáson %d képviselőjelölt indult.",
                vote.getNumberOfCandidates()));
        System.out.print("3. feladat: Kérem adjon meg egy jelölt nevet: ");
        System.out.println(vote.getNumberOfVotesByCandidateName(console.readName()));
        System.out.println("4. feladat: " + vote.getTotalNumberOfVoters());
        System.out.println("5. feladat: A pártokra leadott szavazatok aránya:" + vote.getPartyStatistic());
        System.out.println("6. feladat: A legtöbb szavazatot kapó jelölt(ek):" + vote.getMostPopularCandidates());
        log.println(vote.getRepresentatives());
    }
}
