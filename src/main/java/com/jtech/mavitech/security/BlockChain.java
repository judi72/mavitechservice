package com.blockchain.ehealthservice.security;

import com.blockchain.ehealthservice.entity.Capteur;
import com.blockchain.ehealthservice.entity.Donnee;
import com.blockchain.ehealthservice.entity.DonneeCapteur;
import lombok.SneakyThrows;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BlockChain {

    private int difficulty;

    private List<Block> blocks;

    public DonneeCapteur capteurNew;

    public DonneeCapteur getCapteurNew() {
        return capteurNew;
    }

    public void setCapteurNew(DonneeCapteur capteurNew) {
        this.capteurNew = capteurNew;
    }

    public BlockChain(int difficulty) {
        this.difficulty = difficulty;
        blocks = new ArrayList<>();

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String dateString = formatter.format(ts);

        // Creation de la premiere block
        Block b = new Block(0, dateString, "", null);
        b.mineBlock(difficulty);
        blocks.add(b);
    }

    public Block currentblock(){
        return blocks.get(blocks.size()-1);
    }

    public int getDifficulty(){
        return difficulty;
    }

    public Block latestBlock(){
        return blocks.get(blocks.size() - 1);
    }


    /*public Block newBlock(Capteur capteur, String humidite, String tempambiant, String tempcorporelle, String frequencecardiaque) throws ParseException {
        Block latestBlock = latestBlock();

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String dateString = formatter.format(ts);

        return new Block(latestBlock.getIndex() + 1, dateString,
                latestBlock.getHash(), capteur, humidite, tempambiant, tempcorporelle, frequencecardiaque);
    }*/

    public Block newBlock(ArrayList<Donnee> list) throws ParseException {
        Block latestBlock = latestBlock();

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String dateString = formatter.format(ts);

        return new Block( latestBlock.getIndex() + 1, dateString,
                latestBlock.getHash(), list);
    }

    public Block addDataInBlock(ArrayList<Donnee> list) throws ParseException {
        Block latestBlock = latestBlock();

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String dateString = formatter.format(ts);

        return new Block(latestBlock.getIndex(), dateString,
                latestBlock.getHash(), list);
    }

    public void addBlock(Block b) {
        if(b != null) {
            b.mineBlock(difficulty);
            blocks.add(b);
        }
    }

    public boolean isFirstBlockValid() {
        Block firstBlock = blocks.get(0);

        if(firstBlock.getIndex() != 0) {
            return false;
        }

        if(firstBlock.getPreviousHash() != null) {
            return false;
        }

        if(firstBlock.getHash() == null ||
                !Block.calculateHash(firstBlock).equals(firstBlock.getHash())){
            return false;
        }

        return true;
    }

    public boolean isValidNewBlock(Block newBlock, Block previousBlock) {
        if(newBlock != null && previousBlock != null) {
            if(previousBlock.getIndex() + 1 != newBlock.getIndex()){
                return false;
            }

            if(newBlock.getPreviousHash() == null ||  !newBlock.getPreviousHash().equals(previousBlock.getHash())){
                return false;
            }

            if(newBlock.getHash() == null || !Block.calculateHash(newBlock).equals(newBlock.getHash())){
                return false;
            }

            return true;
        }

        return false;

    }

    public boolean isBlockChainValid(){
        if(!isFirstBlockValid()) {
            return false;
        }

        for (int i = 1; i < blocks.size(); i++){
            Block currentBlock = blocks.get(i);
            Block previousBlock = blocks.get(i - 1);

            if(!isValidNewBlock(currentBlock, previousBlock)){
                return false;
            }
        }

        return true;

    }


    @SneakyThrows
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        Block blockHash = new Block();

        DonneeCapteur donneeCapteur = new DonneeCapteur();

        for(Block block : blocks) {

            donneeCapteur.setTimestamp(String.valueOf(block.getTimestamp()));
            donneeCapteur.setHash(block.getHash());
            donneeCapteur.setPreviousHash(block.getPreviousHash());
            donneeCapteur.setDonnees(block.getListDonne());

            this.setCapteurNew(donneeCapteur);

            builder.append(block).append("\n");

        }

        return builder.toString();
    }


}
