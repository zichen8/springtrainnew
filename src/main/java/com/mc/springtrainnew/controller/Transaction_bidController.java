package com.mc.springtrainnew.controller;


import com.mc.springtrainnew.common.utils.IdGenerator;
import com.mc.springtrainnew.common.utils.ResultUtil;
import com.mc.springtrainnew.common.vo.Result;
import com.mc.springtrainnew.entity.InsertModel;
import com.mc.springtrainnew.service.impl.Transaction_bidServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Eason+
 * @since 2020-07-14
 */
@RestController
@RequestMapping("/insertTran/")
public class Transaction_bidController {
    @Resource
    private Transaction_bidServiceImpl transactionBidService;


    public Result<Object> insertTransaction(@RequestHeader("Authorization") String auth, @RequestBody InsertModel insertModel) {
        try {
            int cnt = transactionBidService.insertTran(insertModel.getTradeID(), insertModel.getSecuritycode(), insertModel.getQuantity(), insertModel.getIuc(),
                    insertModel.getBuyorsell(), Long.valueOf(auth));
            return cnt > 0 ? ResultUtil.success() : ResultUtil.error("提交失败");
        } catch (Exception e) {
            return ResultUtil.error("网络错误");
        }
    }
}



