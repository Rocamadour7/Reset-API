package com.molina.luis;

import com.molina.luis.blockchain.Block;
import com.molina.luis.blockchain.Blockchain;
import com.molina.luis.blockchain.Vote;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("blockchain")
public class BlockchainAPI {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Blockchain getBlockchain() {
        return VoteHandler.blockchain;
    }

    @GET @Path("/{blockIndex}")
    @Produces(MediaType.APPLICATION_JSON)
    public Block getBlock(@PathParam("blockIndex") int blockIndex) {
        return VoteHandler.blockchain.getChain().get(blockIndex);
    }

    @GET @Path("last")
    @Produces(MediaType.APPLICATION_JSON)
    public Block getLastBlock() {
        return VoteHandler.blockchain.getChain().get(VoteHandler.blockchain.getChain().size() - 1);
    }

}
