package com.hundsun.operation.manager.controller;

import com.hundsun.operation.manager.model.DataSourceReq;
import com.hundsun.operation.manager.model.DataSourceRes;
import com.hundsun.operation.manager.service.DataSourceParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Ryan
 * @date 2018-12-29.
 */
@Controller
public class DataSourceParseController {

    @Autowired
    DataSourceParseService dataSourceParseService;
    @RequestMapping(method = RequestMethod.POST)
    public List<DataSourceRes> generateDataSource(List<DataSourceReq> req){
        return dataSourceParseService.generateDataSource(req);

    }
}
