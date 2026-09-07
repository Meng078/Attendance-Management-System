package org.jeecg.modules.demo.edu.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.edu.entity.EduQingjiadan;
import org.jeecg.modules.demo.edu.service.IEduQingjiadanService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
 /**
 * @Description: 请假单
 * @Author: jeecg-boot
 * @Date:   2026-09-07
 * @Version: V1.0
 */
@Tag(name="请假单")
@RestController
@RequestMapping("/edu/eduQingjiadan")
@Slf4j
public class EduQingjiadanController extends JeecgController<EduQingjiadan, IEduQingjiadanService> {
	@Autowired
	private IEduQingjiadanService eduQingjiadanService;
	
	/**
	 * 分页列表查询
	 *
	 * @param eduQingjiadan
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "请假单-分页列表查询")
	@Operation(summary="请假单-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<EduQingjiadan>> queryPageList(EduQingjiadan eduQingjiadan,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {


        QueryWrapper<EduQingjiadan> queryWrapper = QueryGenerator.initQueryWrapper(eduQingjiadan, req.getParameterMap());
		Page<EduQingjiadan> page = new Page<EduQingjiadan>(pageNo, pageSize);
		IPage<EduQingjiadan> pageList = eduQingjiadanService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param eduQingjiadan
	 * @return
	 */
	@AutoLog(value = "请假单-添加")
	@Operation(summary="请假单-添加")
	@RequiresPermissions("edu:edu_qingjiadan:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody EduQingjiadan eduQingjiadan) {
		eduQingjiadanService.save(eduQingjiadan);

		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param eduQingjiadan
	 * @return
	 */
	@AutoLog(value = "请假单-编辑")
	@Operation(summary="请假单-编辑")
	@RequiresPermissions("edu:edu_qingjiadan:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody EduQingjiadan eduQingjiadan) {
		eduQingjiadanService.updateById(eduQingjiadan);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "请假单-通过id删除")
	@Operation(summary="请假单-通过id删除")
	@RequiresPermissions("edu:edu_qingjiadan:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		eduQingjiadanService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "请假单-批量删除")
	@Operation(summary="请假单-批量删除")
	@RequiresPermissions("edu:edu_qingjiadan:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.eduQingjiadanService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "请假单-通过id查询")
	@Operation(summary="请假单-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<EduQingjiadan> queryById(@RequestParam(name="id",required=true) String id) {
		EduQingjiadan eduQingjiadan = eduQingjiadanService.getById(id);
		if(eduQingjiadan==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(eduQingjiadan);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param eduQingjiadan
    */
    @RequiresPermissions("edu:edu_qingjiadan:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, EduQingjiadan eduQingjiadan) {
        return super.exportXls(request, eduQingjiadan, EduQingjiadan.class, "请假单");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("edu:edu_qingjiadan:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, EduQingjiadan.class);
    }

}
