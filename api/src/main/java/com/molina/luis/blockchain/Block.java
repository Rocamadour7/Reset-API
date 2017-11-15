package com.molina.luis.blockchain;

import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {

    private int index;
    private Vote vote;
    private long timestamp;
    private String hash;
    private String previousHash;

    public Block(int index, Vote vote) {
        this.index = index;
        this.vote = vote;
        setTimestamp();
        try {
            this.hash = calculateHash();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private String calculateHash() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.reset();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.vote);
        stringBuilder.append(this.index + this.timestamp);
        stringBuilder.append(this.previousHash);
        String input = stringBuilder.toString();
        byte[] buffer = input.getBytes("UTF-8");
        messageDigest.update(buffer);
        byte[] digest = messageDigest.digest();

        StringBuilder hexStr = new StringBuilder();
        for (byte aDigest : digest) {
            hexStr.append(Integer.toString((aDigest & 0xff) + 0x100, 16).substring(1));
        }
        return hexStr.toString();
    }

    private void mineBlock(int difficulty) {
        String checkString = CharBuffer.allocate(difficulty).toString().replace('\0', '0');
        while(!this.hash.substring(0, difficulty).equals(checkString)){
            // TODO check and create a nonce variable
        }
    }

    private void setTimestamp() {
        Date now = new Date();
        this.timestamp = now.getTime();
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }
}
