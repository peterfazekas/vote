package hu.vote.model;

/**
 * @author Peter_Fazekas on 2017.04.17..
 */
public enum Party {

    GYEP("Gyümölcsevők Pártja", "GYEP", "GYEP"),
    HEP("Húsevők Pártja", "HEP", "HEP"),
    TISZ("Tejivók Szövetsége", "TISZ", "TISZ"),
    ZEP("Zöldségevők Pártja", "ZEP", "ZEP"),
    FJ("Független jelöltek", "-", "független");

    private final String partyName;
    private final String inputName;
    private final String shortName;

    Party(final String partyName, final String inputName, final String shortName) {
        this.partyName = partyName;
        this.inputName = inputName;
        this.shortName = shortName;
    }

    public static Party fromString(final String name) {
        Party thisParty = null;
        for (Party party : Party.values()) {
            if (name.equals(party.inputName)) {
                thisParty = party;
            }
        }
        return thisParty;
    }

    public String getPartyName() {
        return partyName;
    }

    public String getShortName() {
        return shortName;
    }
}
