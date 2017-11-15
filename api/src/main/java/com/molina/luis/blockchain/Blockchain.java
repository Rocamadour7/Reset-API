package com.molina.luis.blockchain;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

public class Blockchain {

    private static Blockchain ourInstance = new Blockchain();

    private ArrayList<Block> chain;
    private PublicKey publicKey;
    private PrivateKey privateKey;

    public static Blockchain getInstance() {
        return ourInstance;
    }

    private Blockchain() {
        chain = new ArrayList<>();
        chain.add(generateGenesisBlock());
    }

    private Block generateGenesisBlock() {
        Block genesis = new Block(0, null);
        genesis.setPreviousHash("0");
        return genesis;
    }

    private Block getLastestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addBlock(Block block) {
        String previousHash = getLastestBlock().getHash();
        block.setPreviousHash(previousHash);
        chain.add(block);
    }

    public ArrayList<Block> getChain() {
        return chain;
    }
}
