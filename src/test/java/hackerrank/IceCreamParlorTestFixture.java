package hackerrank;


import com.hackerrank.search.IceCreamParlor;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;


@RunWith(JUnitParamsRunner.class)
@SpringBootTest
public class IceCreamParlorTestFixture {

    private IceCreamParlor iceCreamParlor;

    @Before
    public void Setup() {
        iceCreamParlor = new IceCreamParlor();
    }

    @Test
    @Parameters(method ="scenarios")
    public void TripsToIceCreamParlor(ArrayList<Integer> cost, Integer allowance, Integer[] expected) {
        Integer[] actual = iceCreamParlor.Purchase(cost, allowance);
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual);

    }

    private Object[] scenarios() {
        return new Object[] {
                new Object[]{
                        new ArrayList<>(Arrays.asList(1,4,5,3,2)),
                        4,
                        new Integer[]{1,4}
                },
                new Object[]{
                        new ArrayList<>(Arrays.asList(2,2,4,3)),
                        4,
                        new Integer[]{1,2}
                }
        };
    }

}
