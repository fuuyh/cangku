package com.ruoyi.wh.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wh.mapper.MemberSignUpMapper;
import com.ruoyi.wh.domain.MemberSignUp;
import com.ruoyi.wh.service.IMemberSignUpService;

/**
 * 会员报名Service业务层处理
 * 
 * @author fyh
 * @date 2024-05-01
 */
@Service
public class MemberSignUpServiceImpl extends ServiceImpl<MemberSignUpMapper,MemberSignUp> implements IMemberSignUpService
{
    @Autowired
    private MemberSignUpMapper memberSignUpMapper;

    /**
     * 查询会员报名
     * 
     * @param id 会员报名主键
     * @return 会员报名
     */
    @Override
    public MemberSignUp selectMemberSignUpById(Long id)
    {
        return memberSignUpMapper.selectMemberSignUpById(id);
    }

    /**
     * 查询会员报名列表
     * 
     * @param memberSignUp 会员报名
     * @return 会员报名
     */
    @Override
    public List<MemberSignUp> selectMemberSignUpList(MemberSignUp memberSignUp)
    {
        return memberSignUpMapper.selectMemberSignUpList(memberSignUp);
    }

    /**
     * 新增会员报名
     * 
     * @param memberSignUp 会员报名
     * @return 结果
     */
    @Override
    public int insertMemberSignUp(MemberSignUp memberSignUp)
    {
        memberSignUp.setCreateTime(DateUtils.getNowDate());
        return memberSignUpMapper.insertMemberSignUp(memberSignUp);
    }

    /**
     * 修改会员报名
     * 
     * @param memberSignUp 会员报名
     * @return 结果
     */
    @Override
    public int updateMemberSignUp(MemberSignUp memberSignUp)
    {
        return memberSignUpMapper.updateMemberSignUp(memberSignUp);
    }

    /**
     * 批量删除会员报名
     * 
     * @param ids 需要删除的会员报名主键
     * @return 结果
     */
    @Override
    public int deleteMemberSignUpByIds(Long[] ids)
    {
        return memberSignUpMapper.deleteMemberSignUpByIds(ids);
    }

    /**
     * 删除会员报名信息
     * 
     * @param id 会员报名主键
     * @return 结果
     */
    @Override
    public int deleteMemberSignUpById(Long id)
    {
        return memberSignUpMapper.deleteMemberSignUpById(id);
    }
}
