package com.yupi.springbootinit.model.dto.chart;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 更新请求
 *
 * @author <a href="  https://github.com/tom336853">lzp</a>
 *
 */
@Data
public class ChartUpdateRequest implements Serializable {
    private Long id;
    /**
     * 分析目标
     */
    private String goal;

    /**
     * 名称
     */
    private String name;
    /**
     * 图表数据
     */
    private String chartData;

    /**
     * 图表类型
     */
    private String chartType;




    private static final long serialVersionUID = 1L;
}