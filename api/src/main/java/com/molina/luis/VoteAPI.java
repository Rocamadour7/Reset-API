package com.molina.luis;

import com.molina.luis.blockchain.Block;
import com.molina.luis.blockchain.Blockchain;
import com.molina.luis.blockchain.Vote;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("votes")
public class VoteAPI {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Vote> getVotes() {
        return VoteHandler.votesList;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postVote(Vote vote) {
        VoteHandler.votesList.add(vote);
        Block block = new Block(vote.getVoteId(), vote);
        VoteHandler.blockchain.addBlock(block);

        String response = "Vote ID: " + vote.getVoteId() + "\nBlock created: " + block.getHash();
        return Response.status(201).entity(response).build();
    }

    @GET @Path("/{voteID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vote getVote(@PathParam("voteID") int voteID) {
        return VoteHandler.votesList.get(voteID);
    }
}
