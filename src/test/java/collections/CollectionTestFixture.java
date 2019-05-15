package collections;


import com.collections.CollectionSample;
import com.collections.SetSample;
import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(JUnitParamsRunner.class)
@SpringBootTest
public class CollectionTestFixture {

    private CollectionSample collectionSample;

    private SetSample setSample;

    @Before
    public void before() {
        collectionSample = new CollectionSample();
        setSample = new SetSample();
    }

    @Test
    public void TestSample() {
        // Arrange

        // Act
       collectionSample.sample();

        // Assert
    }

    @Test
    public void TestSample2(){
        // Arrange

        // Act
        setSample.sampele();

        // Assert
    }
}
