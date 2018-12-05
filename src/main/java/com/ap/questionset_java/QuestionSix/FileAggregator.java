package com.ap.questionset_java.QuestionSix;

import org.springframework.core.io.ClassPathResource;
import java.io.File;
import java.time.chrono.ThaiBuddhistEra;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FileAggregator {

    public void Process(String sourceDirectory, String outputFile) throws Exception {

        BlockingQueue<String> myQueue = new LinkedBlockingQueue<>(10);

        // 1. Get list of input files and fire off producers
        File inputDirectory = new ClassPathResource(sourceDirectory).getFile();
        for(File file: inputDirectory.listFiles()) {
            new Thread(new FileProducer(myQueue, file)).start();
        }

        // 2. Fire off consumers.
        int consumerNumber =2;
        for (int i = 0; i < consumerNumber; i++){
            new Thread(new FileConsumer(myQueue, outputFile)).start();
        }
    }
}