package com.ruoyi.wh.service;

import java.util.List;
import com.ruoyi.wh.domain.MemberSignUp;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 会员报名Service接口
 * 
 * @author fyh
 * @date 2024-05-01
 */
public interface IMemberSignUpService extends IService<MemberSignUp>
{
    /**
     * 查询会员报名
     * 
     * @param id 会员报名主键
     * @return 会员报名
     */
    public MemberSignUp selectMemberSignUpById(Long id);

    /**
     * 查询会员报名列表
     * 
     * @param memberSignUp 会员报名
     * @return 会员报名集合
     */
    public List<MemberSignUp> selectMemberSignUpList(MemberSignUp memberSignUp);

    /**
     * 新增会员报名
     * 
     * @param memberSignUp 会员报名
     * @return 结果
     */
    public int insertMemberSignUp(MemberSignUp memberSignUp);

    /**
     * 修改会员报名
     * 
     * @param memberSignUp 会员报名
     * @return 结果
     */
    public int updateMemberSignUp(MemberSignUp memberSignUp);

    /**
     * 批量删除会员报名
     * 
     * @param ids 需要删除的会员报名主键集合
     * @return 结果
     */
    public int deleteMemberSignUpByIds(Long[] ids);

    /**
     * 删除会员报名信息
     * 
     * @param id 会员报名主键
     * @return 结果
     */
    public int deleteMemberSignUpById(Long id);
}
