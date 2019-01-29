package com.hundsun.operation.manager.service.biz;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
