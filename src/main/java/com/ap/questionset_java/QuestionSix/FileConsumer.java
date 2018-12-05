package com.ap.questionset_java.QuestionSix;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.BlockingQueue;

public class FileConsumer implements  Runnable {
    protected BlockingQueue<String> queue;

    protected String outputFile;

    FileConsumer(BlockingQueue<String> theQueue, String outputFile) {
        this.queue = theQueue;
        this.outputFile = outputFile;
    }

    @Override
    public void run() {
        while(true) {
            if(queue.isEmpty())    {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    String fileData =  queue.take();
                    File file = new File(outputFile);
                    FileUtils.writeStringToFile(file,fileData, StandardCharsets.UTF_8,true);
                    queue.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
