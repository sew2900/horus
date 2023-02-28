package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure, CompositeBlock{
    private List<Block> blocks;
    private List<CompositeBlock> compositeBlocksInDetails;
    private String color;
    private String material;
    private Block brownConcrete;
    private Block woodenPlank;

    private Block glass;
    private Block woodenLog;
    private CompositeBlock ceramicComp;
    private CompositeBlock carbonFiberComp;

    public Wall(){
        blocks = new ArrayList<>();
        compositeBlocksInDetails = new ArrayList<>();

        brownConcrete = new Wall("brown", "concrete");
        glass = new Wall("transparent","glass");
        woodenPlank = new Wall("brown","wood");
        woodenLog = new Wall("brown","wood");
        blocks.add(brownConcrete);
        blocks.add(glass);
        blocks.add(woodenPlank);
        blocks.add(woodenLog);


        ceramicComp = new Wall(List.of(
                new Wall("white", "ceramic"),
                new Wall("gray", "clay")),
                "gray", "ceramic composite");

        carbonFiberComp = new Wall(List.of(
                new Wall("black", "carbon fiber"),
                new Wall("semi-transparent", "epoxy")),
                "gray", "carbon fiber composite");



        blocks.add(ceramicComp);
        blocks.add(carbonFiberComp);

        compositeBlocksInDetails.add(ceramicComp);
        compositeBlocksInDetails.add(carbonFiberComp);
    }

    // FOR ONE MATERIAL BLOCKS
    public Wall(String color, String material) {


        this.color = color;
        this.material = material;
    }

    // FOR COMPOSITE BLOCKS
    public Wall(List<Block> blocks,String color, String material){
        this.blocks = blocks;
        this.color = color;
        this.material = material;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Wall)) {
            return false;
        }

        Wall other = (Wall) obj;
        return Objects.equals(color, other.color) && Objects.equals(material, other.material);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getMaterial() {
        return this.material;
    }

    @Override
    public List<Block> getBlocks() {
        return this.blocks;
    }


    @Override
    public Optional<Block> findBlockByColor(String color) {


        Optional<Block> searchingResult = blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findFirst()
                .map(Optional::of)
                .orElse(Optional.empty());

        return searchingResult;
    }


    @Override
    public List<Block> findBlocksByMaterial(String material) {
            return blocks.stream()
                    .filter(block -> block.getMaterial().equals(material))
                    .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }


}