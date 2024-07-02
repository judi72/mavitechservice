package com.blockchain.ehealthservice.security;

import com.blockchain.ehealthservice.entity.Capteur;
import com.blockchain.ehealthservice.entity.Donnee;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Block {

    private int index;
    private String timestamp;
    private String hash;
    private String previousHash;
    private ArrayList<Donnee> listDonne = new ArrayList<>();

    private int nonce;

    public Block() {
    }

    public Block(int index, String timestamp, String previousHash, ArrayList<Donnee> listDonne) {
        this.index = index;
        this.timestamp = timestamp;
        this.previousHash = previousHash;
        this.listDonne = listDonne;
        nonce = 0;
        hash = Block.calculateHash(this);
    }

    public int getIndex() {
        return index;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public ArrayList<Donnee> getListDonne() {
        return listDonne;
    }

    public void setListDonne(ArrayList<Donnee> listDonne) {
        this.listDonne = listDonne;
    }

    public String str() {
        return index + timestamp + previousHash + nonce;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        try {
            builder.append("Block #").append(index).append(" [previousHash : ").append(previousHash).append(", ").
                    append("timestamp : ").append(timestamp).append(", ").append("listdonnee : ").append(getSHA(String.valueOf(listDonne))).append(", ").
                    append("hash : ").append(hash).append("]");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return builder.toString();
    }

    public static String calculateHash(Block block){
        if(block != null) {
            MessageDigest digest = null;
            try {
                digest = MessageDigest.getInstance("SHA-256");
            }catch (NoSuchAlgorithmException e)  {
                return null;
            }

            String txt = block.str();
            final byte bytes[] = digest.digest(txt.getBytes());
            final StringBuilder builder = new StringBuilder();

            for(final byte b : bytes) {
                String hex = Integer.toHexString(0xff & b);

                if(hex.length() == 1) {
                    builder.append("0");
                }
                builder.append(hex);
            }

            return builder.toString();
        }

        return null;
    }

    public byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    public void mineBlock(int difficulty){
        nonce = 0;

        while (!getHash().substring(0, difficulty).equals(Utils.zeros(difficulty))) {
            nonce++;
            hash = Block.calculateHash(this);
        }
    }

}
