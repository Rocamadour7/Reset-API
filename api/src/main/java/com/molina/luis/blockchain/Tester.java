package com.molina.luis.blockchain;

public class Tester {
    public static void main(String[] args) {
        Blockchain chain = Blockchain.getInstance();
        Block block = chain.getChain().get(0);
        Block block1 = new Block(1, null);
        chain.addBlock(block1);
        System.out.println("com.molina.luis.blockchain.Block 0 hash: " + block.getHash());
        System.out.println("com.molina.luis.blockchain.Block 1 prevHash: " + block1.getPreviousHash());
        System.out.println("com.molina.luis.blockchain.Block 1 hash: " + block1.getHash());
    }
}
