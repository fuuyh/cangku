package com.ruoyi.wh.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.wh.domain.PlanBanner;
import com.ruoyi.wh.service.IPlanBannerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 计划轮播图Controller
 * 
 * @author fyh
 * @date 2024-05-01
 */
@RestController
@RequestMapping("/wh/banner")
public class PlanBannerController extends BaseController
{
    @Autowired
    private IPlanBannerService planBannerService;

    /**
     * 查询计划轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('wh:banner:list')")
    @GetMapping("/list")
    public TableDataInfo list(PlanBanner planBanner)
    {
        startPage();
        List<PlanBanner> list = planBannerService.selectPlanBannerList(planBanner);
        return getDataTable(list);
    }

    /**
     * 导出计划轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('wh:banner:export')")
    @Log(title = "计划轮播图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PlanBanner planBanner)
    {
        List<PlanBanner> list = planBannerService.selectPlanBannerList(planBanner);
        ExcelUtil<PlanBanner> util = new ExcelUtil<PlanBanner>(PlanBanner.class);
        util.exportExcel(response, list, "计划轮播图数据");
    }

    /**
     * 获取计划轮播图详细信息
     */
    @PreAuthorize("@ss.hasPermi('wh:banner:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(planBannerService.selectPlanBannerById(id));
    }

    /**
     * 新增计划轮播图
     */
    @PreAuthorize("@ss.hasPermi('wh:banner:add')")
    @Log(title = "计划轮播图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PlanBanner planBanner)
    {
        return toAjax(planBannerService.insertPlanBanner(planBanner));
    }

    /**
     * 修改计划轮播图
     */
    @PreAuthorize("@ss.hasPermi('wh:banner:edit')")
    @Log(title = "计划轮播图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PlanBanner planBanner)
    {
        return toAjax(planBannerService.updatePlanBanner(planBanner));
    }

    /**
     * 删除计划轮播图
     */
    @PreAuthorize("@ss.hasPermi('wh:banner:remove')")
    @Log(title = "计划轮播图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(planBannerService.deletePlanBannerByIds(ids));
    }
}
