package com.hundsun.operation.manager.service.impl;

import com.hundsun.operation.manager.service.FileCompareService;
import com.hundsun.operation.manager.service.biz.FileThreadFactory;
import com.hundsun.operation.manager.service.biz.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FileCompareServiceImpl implements FileCompareService {

    @Override
    public void createTask() {

        FileThreadFactory factory = new FileThreadFactory("fileCompareThread");
        //305 926 out 文件,根据文件个数创建线程。
        factory.newThread(new Task());
        //
    }

    @Override
    public void beginDeal() {

    }
}
