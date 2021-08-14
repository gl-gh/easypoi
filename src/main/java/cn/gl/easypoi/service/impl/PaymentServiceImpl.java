package cn.gl.easypoi.service.impl;

import cn.gl.easypoi.dao.PaymentMapper;
import cn.gl.easypoi.entity.Payment;
import cn.gl.easypoi.service.IPaymentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (Payment)表服务实现类
 *
 * @author makejava
 * @since 2021-08-14 01:51:06
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements IPaymentService {

}
