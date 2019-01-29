package com.hundsun.operation.manager.service.biz;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * 文件比较结构工厂
 */
public class FileThreadFactory implements ThreadFactory {
    /**
     * 线程数目
     */
    private int counter;
    /**
     * 线程名称
     */
    private String name;
    /**
     * 线程对象统计数据
     */
    private List<String> stats;

    public FileThreadFactory(String name){
        counter = 0;
        this.name = name;
        stats = new ArrayList<>();
    }
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-Thread_" + counter);
        stats.add(String.format("created thread %d with name %s on %s \n", t.getId(), t.getName(), LocalDateTime.now()));
        return t;
    }

    public List<String> getStats() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> iterator = stats.iterator();
        while (iterator.hasNext()){
            stringBuffer.append(iterator.next());
            stringBuffer.append("\n");
        }
        return stats;
    }

}
