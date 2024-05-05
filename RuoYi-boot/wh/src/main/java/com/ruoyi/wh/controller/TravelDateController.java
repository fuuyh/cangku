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
import com.ruoyi.wh.domain.TravelDate;
import com.ruoyi.wh.service.ITravelDateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出行日期Controller
 * 
 * @author fyh
 * @date 2024-05-01
 */
@RestController
@RequestMapping("/wh/date")
public class TravelDateController extends BaseController
{
    @Autowired
    private ITravelDateService travelDateService;

    /**
     * 查询出行日期列表
     */
    @PreAuthorize("@ss.hasPermi('wh:date:list')")
    @GetMapping("/list")
    public TableDataInfo list(TravelDate travelDate)
    {
        startPage();
        List<TravelDate> list = travelDateService.selectTravelDateList(travelDate);
        return getDataTable(list);
    }

    /**
     * 导出出行日期列表
     */
    @PreAuthorize("@ss.hasPermi('wh:date:export')")
    @Log(title = "出行日期", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TravelDate travelDate)
    {
        List<TravelDate> list = travelDateService.selectTravelDateList(travelDate);
        ExcelUtil<TravelDate> util = new ExcelUtil<TravelDate>(TravelDate.class);
        util.exportExcel(response, list, "出行日期数据");
    }

    /**
     * 获取出行日期详细信息
     */
    @PreAuthorize("@ss.hasPermi('wh:date:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(travelDateService.selectTravelDateById(id));
    }

    /**
     * 新增出行日期
     */
    @PreAuthorize("@ss.hasPermi('wh:date:add')")
    @Log(title = "出行日期", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TravelDate travelDate)
    {
        return toAjax(travelDateService.insertTravelDate(travelDate));
    }

    /**
     * 修改出行日期
     */
    @PreAuthorize("@ss.hasPermi('wh:date:edit')")
    @Log(title = "出行日期", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TravelDate travelDate)
    {
        return toAjax(travelDateService.updateTravelDate(travelDate));
    }

    /**
     * 删除出行日期
     */
    @PreAuthorize("@ss.hasPermi('wh:date:remove')")
    @Log(title = "出行日期", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(travelDateService.deleteTravelDateByIds(ids));
    }
}
