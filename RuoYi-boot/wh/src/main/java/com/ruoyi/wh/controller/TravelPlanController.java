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
import com.ruoyi.wh.domain.TravelPlan;
import com.ruoyi.wh.service.ITravelPlanService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出行计划概览Controller
 * 
 * @author fyh
 * @date 2024-05-01
 */
@RestController
@RequestMapping("/wh/plan")
public class TravelPlanController extends BaseController
{
    @Autowired
    private ITravelPlanService travelPlanService;

    /**
     * 查询出行计划概览列表
     */
    @PreAuthorize("@ss.hasPermi('wh:plan:list')")
    @GetMapping("/list")
    public TableDataInfo list(TravelPlan travelPlan)
    {
        startPage();
        List<TravelPlan> list = travelPlanService.selectTravelPlanList(travelPlan);
        return getDataTable(list);
    }

    /**
     * 导出出行计划概览列表
     */
    @PreAuthorize("@ss.hasPermi('wh:plan:export')")
    @Log(title = "出行计划概览", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TravelPlan travelPlan)
    {
        List<TravelPlan> list = travelPlanService.selectTravelPlanList(travelPlan);
        ExcelUtil<TravelPlan> util = new ExcelUtil<TravelPlan>(TravelPlan.class);
        util.exportExcel(response, list, "出行计划概览数据");
    }

    /**
     * 获取出行计划概览详细信息
     */
    @PreAuthorize("@ss.hasPermi('wh:plan:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(travelPlanService.selectTravelPlanById(id));
    }

    /**
     * 新增出行计划概览
     */
    @PreAuthorize("@ss.hasPermi('wh:plan:add')")
    @Log(title = "出行计划概览", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TravelPlan travelPlan)
    {
        return toAjax(travelPlanService.insertTravelPlan(travelPlan));
    }

    /**
     * 修改出行计划概览
     */
    @PreAuthorize("@ss.hasPermi('wh:plan:edit')")
    @Log(title = "出行计划概览", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TravelPlan travelPlan)
    {
        return toAjax(travelPlanService.updateTravelPlan(travelPlan));
    }

    /**
     * 删除出行计划概览
     */
    @PreAuthorize("@ss.hasPermi('wh:plan:remove')")
    @Log(title = "出行计划概览", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(travelPlanService.deleteTravelPlanByIds(ids));
    }
}
