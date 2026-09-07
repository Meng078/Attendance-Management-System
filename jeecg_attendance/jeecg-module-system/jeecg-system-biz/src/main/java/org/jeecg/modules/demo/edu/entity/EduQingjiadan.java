package org.jeecg.modules.demo.edu.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 请假单
 * @Author: jeecg-boot
 * @Date:   2026-09-07
 * @Version: V1.0
 */
@Data
@TableName("edu_qingjiadan")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="请假单")
public class EduQingjiadan implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "主键")
    private java.lang.String id;
	/**请假人*/
	@Excel(name = "请假人", width = 15)
    @Schema(description = "请假人")
    private java.lang.String name;
	/**性别*/
	@Excel(name = "性别", width = 15)
    @Schema(description = "性别")
    private java.lang.String sex;
	/**年龄*/
	@Excel(name = "年龄", width = 15)
    @Schema(description = "年龄")
    private java.lang.String age;
	/**请假事由*/
	@Excel(name = "请假事由", width = 15)
    @Schema(description = "请假事由")
    private java.lang.String remark;
	/**开始时间*/
	@Excel(name = "开始时间", width = 15)
    @Schema(description = "开始时间")
    private java.lang.String beginDate;
	/**结束时间*/
	@Excel(name = "结束时间", width = 15)
    @Schema(description = "结束时间")
    private java.lang.String endDate;
	/**请假天数*/
	@Excel(name = "请假天数", width = 15)
    @Schema(description = "请假天数")
    private java.lang.String days;
	/**创建人*/
    @Schema(description = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @Schema(description = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @Schema(description = "所属部门")
    private java.lang.String sysOrgCode;
}
