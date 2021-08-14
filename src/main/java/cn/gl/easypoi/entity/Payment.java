package cn.gl.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author makejava
 * @since 2021-08-14 01:51:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget("payments")
public class Payment implements Serializable {
    private static final long serialVersionUID = -65113252500069023L;
    /**
     * ID
     */
    @Excel(name = "id")
    private Long id;
    @Excel(name = "serial")
    private String serial;

}
