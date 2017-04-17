package hu.vote.service;

import java.util.Scanner;

/**
 * @author Peter_Fazekas on 2017.04.17..
 */
public class Console {

    private final Scanner sc;

    public Console() {
        sc = new Scanner(System.in);
    }

    public String readName() {
        return sc.nextLine();
    }
}
