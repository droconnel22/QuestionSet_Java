package com.ap.questionset_java.QuestionSix;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionSixTestFixture {


    /**
     * Output file is found in /target/test-classOutput
     */

    @Test
    public void Run_Scenario() throws Exception {

        // Arrange
        String sourceDirectory = "Input\\";
        String outputDirectory = "Output\\output.txt";
        FileAggregator fileAggregator = new FileAggregator();

        // Act
        fileAggregator.Process(sourceDirectory, outputDirectory);

        // Assert
        // no exception is successful run.
    }
}
