import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateaurTest {

    @Test
    void getxSize() {
        Plateaur plateaur = new Plateaur(5, 5);
        int xSize;
        int expected = 5;

        xSize = plateaur.getxSize();

        Assert.assertEquals(expected, xSize);
    }

    @Test
    void getySize() {
        Plateaur plateaur = new Plateaur(5, 5);
        int ySize;
        int expected = 5;

        ySize = plateaur.getySize();

        Assert.assertEquals(expected, ySize);
    }

    @Test
    void ifConstructorGetsXSizeLowerThanOneXSizeValueIsZero(){
        Plateaur plateaur = new Plateaur(-1, 5);
        int xSize;
        int expected = 0;

        xSize = plateaur.getxSize();

        Assert.assertEquals(expected, xSize);
    }

    @Test
    void ifConstructorGetsYSizeLowerThanOneYSizeValueIsZero(){
        Plateaur plateaur = new Plateaur(5, -1);
        int ySize;
        int expected = 0;

        ySize = plateaur.getySize();

        Assert.assertEquals(expected, ySize);
    }
}