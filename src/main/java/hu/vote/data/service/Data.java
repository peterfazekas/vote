package hu.vote.data.service;

import hu.vote.data.parse.DataParser;
import hu.vote.data.read.DataRead;
import hu.vote.data.read.FileDataReader;
import hu.vote.model.Vote;
import hu.vote.service.VoteService;

import java.util.List;


/**
 * @author Peter_Fazekas on 2017.04.17..
 */
public class Data {

    public VoteService createNewInstance(final String fileName, final int population) {
        return new VoteService(getData(fileName), population);
    }

    private List<Vote> getData(final String fileName) {
        DataRead file = new FileDataReader();
        DataParser data = new DataParser();
        return data.parse(file.read(fileName));
    }
}
