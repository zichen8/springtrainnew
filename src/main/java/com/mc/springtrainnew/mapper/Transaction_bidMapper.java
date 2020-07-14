package com.mc.springtrainnew.mapper;

import com.mc.springtrainnew.entity.Transaction_bid;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Eason+
 * @since 2020-07-14
 */
public interface Transaction_bidMapper extends BaseMapper<Transaction_bid> {

    @Select(value="select count(1) from transaction_bid where securitycode=#{securitycode} and buyorsell=#{buyorsell}")
    int selectSingleTransaction(String securitycode,Boolean buyorsell);


}
