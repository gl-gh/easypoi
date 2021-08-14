package cn.gl.easypoi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.gl.easypoi.entity.Payment;
import cn.gl.easypoi.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * (Payment)表控制层
 *
 * @author makejava
 * @since 2021-08-14 01:51:06
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {
    @Autowired
    private IPaymentService paymentService;

    @GetMapping("/exportPayments")
    public void exportPayments(HttpServletResponse response) throws IOException {
        log.warn("paymentList: " + paymentService);
        List<Payment> payments = paymentService.selectList(null);
        log.info("paymentList: " + payments.toString());
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("payment", "payment"), Payment.class, payments);
        response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode("payments.xls", "utf-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }

    @GetMapping("/get")
    public List<Payment> get() {
        List<Payment> payments = paymentService.selectList(null);
        log.warn("paymentList: " + payments);
        return payments;
    }
}
