package org.example;






import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WallTest {

private Wall wall;

    @BeforeEach
    public void setUp() {
        this.wall = new Wall();
    }


    @Test
    public void getBlocksTest()
    {
        assertEquals(6,wall.getBlocks().size());
    }

    @Test
    public void countMethodTest() {
        assertEquals(6, wall.count());
    }

    @Test
    public void test()
    {
        Wall wall1 = new Wall("brown", "wood");
        Wall wall2 = new Wall("brown", "wood");
        assertTrue(wall1.equals(wall2));
    }

    @Test
    public void findBlockByColorMethodTest()
    {
        Optional<Block> actual = wall.findBlockByColor("brown");
        Optional<Block> expected = Optional.of(new Wall("brown","concrete"));

        assertTrue(actual.isPresent());
        assertTrue(expected.isPresent());

        assertEquals(expected.get(), actual.get());
    }


    @Test
    public void findBlocksByMaterialMethodTest()
    {
        List<Block> expectedBlocks = new ArrayList<>();
        expectedBlocks.add(new Wall("brown","wood"));
        expectedBlocks.add(new Wall("brown","wood"));

        List<Block> actualBlocks = wall.findBlocksByMaterial("wood");

        assertTrue(actualBlocks.equals(expectedBlocks));
        assertTrue(expectedBlocks.equals(actualBlocks));
    }

    @Test
    public void findCompBlocks()
    {
        List<Block> expectedBlocks = new ArrayList<>();
        expectedBlocks.add(new Wall(List.of(
                new Wall("black", "carbon fiber"),
                new Wall("semi-transparent", "epoxy")),
                "gray", "carbon fiber composite"));

        List<Block> actualBlocks = wall.findBlocksByMaterial("carbon fiber composite");

        assertEquals(expectedBlocks, actualBlocks);
    }

    @Test
    public void findCompBlocks2()
    {
        List<CompositeBlock> expectedBlocks = new ArrayList<>();
        expectedBlocks.add(new Wall(List.of(
                new Wall("black", "carbon fiber"),
                new Wall("semi-transparent", "epoxy")),
                "gray", "carbon fiber composite"));

        List<Block> actualBlocks = wall.findBlocksByMaterial("carbon fiber composite");

        assertTrue(actualBlocks.equals(expectedBlocks));
        assertTrue(expectedBlocks.equals(actualBlocks));
    }

}