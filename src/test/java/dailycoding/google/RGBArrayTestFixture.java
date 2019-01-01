package dailycoding.google;


import com.dailycoding.google.RGBArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertArrayEquals;

@RunWith(SpringRunner.class)
public class RGBArrayTestFixture {

    private RGBArray rgbArray;

    @Test
    public void Case() {
        // Arrange
        rgbArray = new RGBArray();
        char[] input = {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        char[] expected = {'R', 'R', 'R', 'G', 'G', 'B', 'B'};

        // Act
        char[] actual = rgbArray.QuickSort(input,0, input.length-1);

        // Assert
        assertArrayEquals(expected, actual);
    }

}
