package com.molina.luis;

import com.molina.luis.blockchain.Candidate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("candidates")
public class CandidateAPI {

    ArrayList<Candidate> candidatesList;

    public CandidateAPI() {
        candidatesList = new ArrayList<>();
        candidatesList.add(new Candidate(0, "Candidate", "A", "President"));
        candidatesList.add(new Candidate(1, "Candidate", "B", "President"));
        candidatesList.add(new Candidate(2, "Candidate", "C", "President"));
        candidatesList.add(new Candidate(3, "Candidate", "D", "President"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Candidate> getCandidates() {
        return candidatesList;
    }

    @GET @Path("/{candidateID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Candidate getCandidate(@PathParam("candidateID") int candidateId) {
        Candidate candidate = candidatesList.get(candidateId);
        return candidate;
    }

}
