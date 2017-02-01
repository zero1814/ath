package org.module.mapper.commons.db;

import org.module.model.commons.db.CmTableConstraints;

public interface CmTableConstraintsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_table_constraints
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_table_constraints
     *
     * @mbggenerated
     */
    int insert(CmTableConstraints record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_table_constraints
     *
     * @mbggenerated
     */
    int insertSelective(CmTableConstraints record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_table_constraints
     *
     * @mbggenerated
     */
    CmTableConstraints selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_table_constraints
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CmTableConstraints record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_table_constraints
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CmTableConstraints record);
}