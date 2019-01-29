package com.hundsun.operation.manager.service;

import com.hundsun.platform.model.DataSourceReq;
import com.hundsun.platform.model.DataSourceRes;

import java.util.List;

/**
 * @author Ryan
 * @date 2018-12-29.
 */
public interface DataSourceParseService {
    List<DataSourceRes> generateDataSource(List<DataSourceReq> req);
}
