package org.module.mapper.commons.db;

import org.module.model.commons.db.CmColumnType;

public interface CmColumnTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_column_type
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_column_type
     *
     * @mbggenerated
     */
    int insert(CmColumnType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_column_type
     *
     * @mbggenerated
     */
    int insertSelective(CmColumnType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_column_type
     *
     * @mbggenerated
     */
    CmColumnType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_column_type
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CmColumnType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_column_type
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CmColumnType record);
}