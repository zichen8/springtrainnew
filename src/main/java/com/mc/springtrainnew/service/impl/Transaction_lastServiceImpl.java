package com.mc.springtrainnew.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mc.springtrainnew.entity.Transaction_last;
import com.mc.springtrainnew.mapper.Transaction_lastMapper;
import com.mc.springtrainnew.service.ITransaction_lastService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Eason+
 * @since 2020-07-14
 */
@Service
public class Transaction_lastServiceImpl extends ServiceImpl<Transaction_lastMapper, Transaction_last> implements ITransaction_lastService {
    @Resource
    private Transaction_lastMapper transaction_lastMapper;

    public List<Transaction_last> getAll() {
        return transaction_lastMapper.selectList(new QueryWrapper<Transaction_last>().gt("tradeid", 0));
    }
}
