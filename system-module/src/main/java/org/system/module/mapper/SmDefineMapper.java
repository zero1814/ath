package org.system.module.mapper;

import org.system.module.model.SmDefine;

public interface SmDefineMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_define
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_define
     *
     * @mbggenerated
     */
    int insert(SmDefine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_define
     *
     * @mbggenerated
     */
    int insertSelective(SmDefine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_define
     *
     * @mbggenerated
     */
    SmDefine selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_define
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SmDefine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_define
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SmDefine record);
}