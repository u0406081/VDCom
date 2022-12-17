package com.example.vdcom_testtask.secondTask;

import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class SecondTask {
    private static final Path PATH = Paths.get( "src/main/java/com/example/vdcom_testtask/secondTask/out.txt");
    private static final String OLD_VALUE = "Старое значение:";
    private static final String NEW_VALUE = "новое значение:";
    private static final String SPACE = " ";
    public static int  enteredNumber = 1000;

    public static void main(String[] args) throws IOException, URISyntaxException {
        Files.writeString(PATH, "0", StandardOpenOption.TRUNCATE_EXISTING);
        ExecutorService service = Executors.newFixedThreadPool(2);
        ReentrantLock locker = new ReentrantLock();

        Runnable runnable = () -> {
                while (true) {
                    locker.lock();
                    try {
                        String oldValueString = Files.readString(PATH);
                        int oldValue = Integer.parseInt(oldValueString);
                        if (oldValue == enteredNumber) {
                            break;
                        }
                        int newValue = oldValue + 1;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(OLD_VALUE);
                        stringBuilder.append(SPACE);
                        stringBuilder.append(oldValue);
                        stringBuilder.append(SPACE);
                        stringBuilder.append(NEW_VALUE);
                        stringBuilder.append(SPACE);
                        stringBuilder.append(newValue);
                        stringBuilder.append(SPACE);
                        stringBuilder.append(Thread.currentThread().getName());
                        System.out.println(stringBuilder);

                        Files.writeString(PATH, String.valueOf(newValue));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        locker.unlock();
                    }
                }
            };

            for (int i = 0; i < 2; i++) {
                service.submit(runnable);
            }
            service.shutdown();
        };
}