package com.mc.springtrainnew;

import com.mc.springtrainnew.common.vo.buyorsellEnum;
import com.mc.springtrainnew.common.vo.iucEnum;
import com.mc.springtrainnew.common.vo.securityCodeEnum;
import com.mc.springtrainnew.common.vo.tradeEnum;
import com.mc.springtrainnew.entity.Transaction_last;
import com.mc.springtrainnew.service.impl.Transaction_bidServiceImpl;
import com.mc.springtrainnew.service.impl.Transaction_lastServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringtrainnewApplicationTests {

    @Resource
    private Transaction_bidServiceImpl transactionBidService;
    @Resource
    private Transaction_lastServiceImpl transactionLastService;

    @Test
    public void firstStep() {


        Long accountID = 331842893327106048L;
        transactionBidService.insertTran(tradeEnum.First.getTradeID(), securityCodeEnum.REL.getSecurityCode(),
                50, iucEnum.Insert.getIucCode(), buyorsellEnum.BUY.getBuyorsellCode(), accountID);

        transactionBidService.insertTran(tradeEnum.Second.getTradeID(), securityCodeEnum.ITC.getSecurityCode(),
                40, iucEnum.Insert.getIucCode(), buyorsellEnum.SELL.getBuyorsellCode(), accountID);

        transactionBidService.insertTran(tradeEnum.Third.getTradeID(), securityCodeEnum.INF.getSecurityCode(),
                70, iucEnum.Insert.getIucCode(), buyorsellEnum.BUY.getBuyorsellCode(), accountID);

        transactionBidService.insertTran(tradeEnum.First.getTradeID(), securityCodeEnum.REL.getSecurityCode(),
                60, iucEnum.Update.getIucCode(), buyorsellEnum.BUY.getBuyorsellCode(), accountID);

        transactionBidService.insertTran(tradeEnum.Second.getTradeID(), securityCodeEnum.ITC.getSecurityCode(),
                30, iucEnum.Cancel.getIucCode(), buyorsellEnum.BUY.getBuyorsellCode(), accountID);

        transactionBidService.insertTran(tradeEnum.Fouth.getTradeID(), securityCodeEnum.INF.getSecurityCode(),
                20, iucEnum.Insert.getIucCode(), buyorsellEnum.SELL.getBuyorsellCode(), accountID);
    }

    @Test
    public void lastPrint() {
        List<Transaction_last> lastList = transactionLastService.getAll();
        for (Transaction_last i : lastList) {
            System.out.println(i.getSecuritycode() + " | " + i.getQuantity());
        }
    }

}
