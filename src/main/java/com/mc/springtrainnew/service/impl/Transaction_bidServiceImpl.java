package com.mc.springtrainnew.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mc.springtrainnew.common.vo.buyorsellEnum;
import com.mc.springtrainnew.common.vo.iucEnum;
import com.mc.springtrainnew.entity.Transaction_bid;
import com.mc.springtrainnew.entity.Transaction_last;
import com.mc.springtrainnew.mapper.Transaction_bidMapper;
import com.mc.springtrainnew.mapper.Transaction_lastMapper;
import com.mc.springtrainnew.service.ITransaction_bidService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Eason+
 * @since 2020-07-14
 */
@Service
public class Transaction_bidServiceImpl extends ServiceImpl<Transaction_bidMapper, Transaction_bid> implements ITransaction_bidService {

    @Resource
    private Transaction_bidMapper transactionBidMapper;

    @Resource
    private Transaction_lastMapper transaction_lastMapper;

    public int insertTran(Integer tardeId, String securityCode, Integer quantity, Integer iuc, Boolean buyorsell, Long accountId) {
        int cnt = transactionBidMapper.insert(new Transaction_bid().setTradeid(tardeId).setSecuritycode(securityCode).setQuantity(quantity).setInsertorupdateorcancel(iuc).
                setAccountid(accountId).setBuyorsell(buyorsell));

        Integer offset = 0;
        if (buyorsell == buyorsellEnum.BUY.getBuyorsellCode())
            offset += quantity;
        else
            offset -= quantity;

        if (cnt > 0) {
            Transaction_last transactionLast = transaction_lastMapper.selectTranByTradeID(tardeId);
            if (transactionLast == null) {
                Transaction_last transactionLastSecurityCode = transaction_lastMapper.selectTranBySecurityCode(securityCode);
                if (transactionLastSecurityCode == null)
                    return transaction_lastMapper.insert(new Transaction_last().setTradeid(tardeId).setSecuritycode(securityCode)
                            .setQuantity(offset).setAccountid(accountId));
                else {
                    //此时肯定是update或cancel的情况
                    if (CalculateLast(tardeId, securityCode, offset, iuc, buyorsell, accountId, transactionLastSecurityCode))
                        return transaction_lastMapper.update(transactionLastSecurityCode, new QueryWrapper<Transaction_last>().eq("securityCode", securityCode));
                }
            } else {
                //此时肯定是update或cancel的情况
                if (CalculateLast(tardeId, securityCode, offset, iuc, buyorsell, accountId, transactionLast))
                    return transaction_lastMapper.update(transactionLast, new QueryWrapper<Transaction_last>().eq("tradeid", tardeId));

            }
        } else {
            return 0;
        }
        return 0;
    }

    private boolean CalculateLast(Integer tardeId, String securityCode, Integer offset, Integer iuc, Boolean buyorsell, Long accountId, Transaction_last transactionLast) {
        if (iuc != iucEnum.Cancel.getIucCode()) {

            if (buyorsell == buyorsellEnum.BUY.getBuyorsellCode()) {
                if (transactionLast.getQuantity() > 0) {
                    transactionLast.setQuantity(offset);
                } else {
                    transactionLast.setQuantity(offset + transactionLast.getQuantity());
                }
            } else {
                if (transactionLast.getQuantity() > 0) {
                    transactionLast.setQuantity(offset + transactionLast.getQuantity());

                } else {
                    transactionLast.setQuantity(offset);
                }
            }
            transactionLast.setSecuritycode(securityCode).setAccountid(accountId);
            return true;
        } else if (iuc == iucEnum.Cancel.getIucCode()) {
            transactionLast.setQuantity(0);
            return true;
        }
        return false;
    }
}
