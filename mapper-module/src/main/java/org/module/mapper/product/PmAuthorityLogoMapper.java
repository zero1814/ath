package org.module.mapper.product;

import org.module.model.product.PmAuthorityLogo;

public interface PmAuthorityLogoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_authority_logo
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_authority_logo
     *
     * @mbggenerated
     */
    int insert(PmAuthorityLogo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_authority_logo
     *
     * @mbggenerated
     */
    int insertSelective(PmAuthorityLogo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_authority_logo
     *
     * @mbggenerated
     */
    PmAuthorityLogo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_authority_logo
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PmAuthorityLogo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_authority_logo
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PmAuthorityLogo record);
}