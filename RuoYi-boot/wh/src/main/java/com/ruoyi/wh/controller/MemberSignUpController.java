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
import com.ruoyi.wh.domain.MemberSignUp;
import com.ruoyi.wh.service.IMemberSignUpService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员报名Controller
 * 
 * @author fyh
 * @date 2024-05-01
 */
@RestController
@RequestMapping("/wh/up")
public class MemberSignUpController extends BaseController
{
    @Autowired
    private IMemberSignUpService memberSignUpService;

    /**
     * 查询会员报名列表
     */
    @PreAuthorize("@ss.hasPermi('wh:up:list')")
    @GetMapping("/list")
    public TableDataInfo list(MemberSignUp memberSignUp)
    {
        startPage();
        List<MemberSignUp> list = memberSignUpService.selectMemberSignUpList(memberSignUp);
        return getDataTable(list);
    }

    /**
     * 导出会员报名列表
     */
    @PreAuthorize("@ss.hasPermi('wh:up:export')")
    @Log(title = "会员报名", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MemberSignUp memberSignUp)
    {
        List<MemberSignUp> list = memberSignUpService.selectMemberSignUpList(memberSignUp);
        ExcelUtil<MemberSignUp> util = new ExcelUtil<MemberSignUp>(MemberSignUp.class);
        util.exportExcel(response, list, "会员报名数据");
    }

    /**
     * 获取会员报名详细信息
     */
    @PreAuthorize("@ss.hasPermi('wh:up:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(memberSignUpService.selectMemberSignUpById(id));
    }

    /**
     * 新增会员报名
     */
    @PreAuthorize("@ss.hasPermi('wh:up:add')")
    @Log(title = "会员报名", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MemberSignUp memberSignUp)
    {
        return toAjax(memberSignUpService.insertMemberSignUp(memberSignUp));
    }

    /**
     * 修改会员报名
     */
    @PreAuthorize("@ss.hasPermi('wh:up:edit')")
    @Log(title = "会员报名", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MemberSignUp memberSignUp)
    {
        return toAjax(memberSignUpService.updateMemberSignUp(memberSignUp));
    }

    /**
     * 删除会员报名
     */
    @PreAuthorize("@ss.hasPermi('wh:up:remove')")
    @Log(title = "会员报名", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(memberSignUpService.deleteMemberSignUpByIds(ids));
    }
}
