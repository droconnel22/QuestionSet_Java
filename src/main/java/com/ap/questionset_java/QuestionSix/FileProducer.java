package com.ap.questionset_java.QuestionSix;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.concurrent.BlockingQueue;

public class FileProducer implements  Runnable {
    protected BlockingQueue<String> queue;

    private File inputFile;

    public FileProducer(BlockingQueue<String> queue, File inputFile) {

        this.queue = queue;
        this.inputFile = inputFile;
    }

    @Override
    public void run() {
        try {

            byte[] encoding;
            if(inputFile.isFile() && inputFile.canRead()) {
                encoding = Files.readAllBytes(inputFile.toPath());
                String fileData = new String(encoding, Charset.defaultCharset());
                queue.add(fileData);
                queue.wait();
            }
        } catch (Exception ex) {
            // log exception
        }
    }
}