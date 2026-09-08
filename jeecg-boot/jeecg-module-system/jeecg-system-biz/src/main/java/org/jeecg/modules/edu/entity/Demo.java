package org.jeecg.modules.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description: 职务级别
 * @Author: jeecg-boot
 * @Date: 2026-09-03
 * @Version: V1.0
 */
@Data
@TableName("demo")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Schema(description="demo")
public class Demo {

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "id")
    private java.lang.String id;


    @Excel(name = "名称", width = 15)
    @Schema(description = "名称")
    private java.lang.String name;
    /**
     * 创建人
     */
    @Schema(description = "创建人")
    private java.lang.String createBy;
    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "创建时间")
    private java.util.Date createTime;
    /**
     * 修改人
     */
    @Schema(description = "修改人")
    private java.lang.String updateBy;
    /**
     * 修改时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "修改时间")
    private java.util.Date updateTime;
    /**
     * 组织机构编码
     */
    @Schema(description = "组织机构编码")
    private java.lang.String sysOrgCode;

    /**租户ID*/
    @Schema(description = "租户ID")
    private java.lang.Integer tenantId;
}
