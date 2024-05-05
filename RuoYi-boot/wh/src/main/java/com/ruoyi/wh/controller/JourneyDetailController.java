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
import com.ruoyi.wh.domain.JourneyDetail;
import com.ruoyi.wh.service.IJourneyDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 计划行程明细Controller
 * 
 * @author fyh
 * @date 2024-05-01
 */
@RestController
@RequestMapping("/wh/detail")
public class JourneyDetailController extends BaseController
{
    @Autowired
    private IJourneyDetailService journeyDetailService;

    /**
     * 查询计划行程明细列表
     */
    @PreAuthorize("@ss.hasPermi('wh:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(JourneyDetail journeyDetail)
    {
        startPage();
        List<JourneyDetail> list = journeyDetailService.selectJourneyDetailList(journeyDetail);
        return getDataTable(list);
    }

    /**
     * 导出计划行程明细列表
     */
    @PreAuthorize("@ss.hasPermi('wh:detail:export')")
    @Log(title = "计划行程明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JourneyDetail journeyDetail)
    {
        List<JourneyDetail> list = journeyDetailService.selectJourneyDetailList(journeyDetail);
        ExcelUtil<JourneyDetail> util = new ExcelUtil<JourneyDetail>(JourneyDetail.class);
        util.exportExcel(response, list, "计划行程明细数据");
    }

    /**
     * 获取计划行程明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('wh:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(journeyDetailService.selectJourneyDetailById(id));
    }

    /**
     * 新增计划行程明细
     */
    @PreAuthorize("@ss.hasPermi('wh:detail:add')")
    @Log(title = "计划行程明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JourneyDetail journeyDetail)
    {
        return toAjax(journeyDetailService.insertJourneyDetail(journeyDetail));
    }

    /**
     * 修改计划行程明细
     */
    @PreAuthorize("@ss.hasPermi('wh:detail:edit')")
    @Log(title = "计划行程明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JourneyDetail journeyDetail)
    {
        return toAjax(journeyDetailService.updateJourneyDetail(journeyDetail));
    }

    /**
     * 删除计划行程明细
     */
    @PreAuthorize("@ss.hasPermi('wh:detail:remove')")
    @Log(title = "计划行程明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(journeyDetailService.deleteJourneyDetailByIds(ids));
    }
}
