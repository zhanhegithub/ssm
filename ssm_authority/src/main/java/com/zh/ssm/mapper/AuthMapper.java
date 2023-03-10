package com.zh.ssm.mapper;

import com.zh.ssm.pojo.Auth;
import com.zh.ssm.pojo.AuthExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthMapper {

    List<Auth> findPathByUid(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Sat Oct 15 15:57:34 CST 2022
     */
    int countByExample(AuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Sat Oct 15 15:57:34 CST 2022
     */
    int deleteByExample(AuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Sat Oct 15 15:57:34 CST 2022
     */
    int deleteByPrimaryKey(Integer aid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Sat Oct 15 15:57:34 CST 2022
     */
    int insert(Auth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Sat Oct 15 15:57:34 CST 2022
     */
    int insertSelective(Auth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Sat Oct 15 15:57:34 CST 2022
     */
    List<Auth> selectByExample(AuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Sat Oct 15 15:57:34 CST 2022
     */
    Auth selectByPrimaryKey(Integer aid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Sat Oct 15 15:57:34 CST 2022
     */
    int updateByExampleSelective(@Param("record") Auth record, @Param("example") AuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Sat Oct 15 15:57:34 CST 2022
     */
    int updateByExample(@Param("record") Auth record, @Param("example") AuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Sat Oct 15 15:57:34 CST 2022
     */
    int updateByPrimaryKeySelective(Auth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Sat Oct 15 15:57:34 CST 2022
     */
    int updateByPrimaryKey(Auth record);
}