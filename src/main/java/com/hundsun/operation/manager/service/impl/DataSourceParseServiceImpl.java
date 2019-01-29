package com.hundsun.operation.manager.service.impl;

import com.hundsun.operation.manager.config.CommonConfig;
import com.hundsun.operation.manager.constant.Constants;
import com.hundsun.operation.manager.model.DataSourceReq;
import com.hundsun.operation.manager.model.DataSourceRes;
import com.hundsun.operation.manager.service.DataSourceParseService;
import com.hundsun.operation.manager.utils.DeEnUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2018-12-30.
 */
@Service
public class DataSourceParseServiceImpl implements DataSourceParseService {
    @Autowired
    CommonConfig commonConfig;
    @Override
    public List<DataSourceRes> generateDataSource(List<DataSourceReq> reqs) {
        List<DataSourceRes> resList = new ArrayList<>();
        for (DataSourceReq req: reqs) {
            String pwd = DeEnUtils.doDEScrypt(req.getPwd(),commonConfig.getEncodeSalt());
            DataSourceRes res = new DataSourceRes();
            res.setFullUrl(req.getUrl().concat(Constants.NUMBER_SIGN).concat(req.getUserName()).concat(Constants.NUMBER_SIGN).concat(pwd));
            resList.add(res);
        }

        return resList;
    }
}
