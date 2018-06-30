package cn.njnode.beans.item;

import java.util.Date;

public class ItemCategory {
    /**
     * <pre>
     * 类目ID
     * 表字段 : t_item_category.id
     * </pre>
     */
    private Long id;

    /**
     * <pre>
     * 父类目ID=0时，代表的是一级的类目
     * 表字段 : t_item_category.parent_id
     * </pre>
     */
    private Long parentId;

    /**
     * <pre>
     * 类目名称
     * 表字段 : t_item_category.name
     * </pre>
     */
    private String name;

    /**
     * <pre>
     * 状态。可选值:1(正常),2(删除)
     * 表字段 : t_item_category.status
     * </pre>
     */
    private Integer status;

    /**
     * <pre>
     * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     * 表字段 : t_item_category.sort_order
     * </pre>
     */
    private Integer sortOrder;

    /**
     * <pre>
     * 该类目是否为父类目，1为true，0为false
     * 表字段 : t_item_category.is_parent
     * </pre>
     */
    private Boolean isParent;

    /**
     * <pre>
     * 创建时间
     * 表字段 : t_item_category.created
     * </pre>
     */
    private Date created;

    /**
     * <pre>
     * 创建时间
     * 表字段 : t_item_category.updated
     * </pre>
     */
    private Date updated;

    /**
     * <pre>
     * 获取：类目ID
     * 表字段：t_item_category.id
     * </pre>
     *
     * @return t_item_category.id：类目ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：类目ID
     * 表字段：t_item_category.id
     * </pre>
     *
     * @param id
     *            t_item_category.id：类目ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：父类目ID=0时，代表的是一级的类目
     * 表字段：t_item_category.parent_id
     * </pre>
     *
     * @return t_item_category.parent_id：父类目ID=0时，代表的是一级的类目
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * <pre>
     * 设置：父类目ID=0时，代表的是一级的类目
     * 表字段：t_item_category.parent_id
     * </pre>
     *
     * @param parentId
     *            t_item_category.parent_id：父类目ID=0时，代表的是一级的类目
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * <pre>
     * 获取：类目名称
     * 表字段：t_item_category.name
     * </pre>
     *
     * @return t_item_category.name：类目名称
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 设置：类目名称
     * 表字段：t_item_category.name
     * </pre>
     *
     * @param name
     *            t_item_category.name：类目名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * <pre>
     * 获取：状态。可选值:1(正常),2(删除)
     * 表字段：t_item_category.status
     * </pre>
     *
     * @return t_item_category.status：状态。可选值:1(正常),2(删除)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态。可选值:1(正常),2(删除)
     * 表字段：t_item_category.status
     * </pre>
     *
     * @param status
     *            t_item_category.status：状态。可选值:1(正常),2(删除)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * <pre>
     * 获取：排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     * 表字段：t_item_category.sort_order
     * </pre>
     *
     * @return t_item_category.sort_order：排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * <pre>
     * 设置：排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     * 表字段：t_item_category.sort_order
     * </pre>
     *
     * @param sortOrder
     *            t_item_category.sort_order：排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * <pre>
     * 获取：该类目是否为父类目，1为true，0为false
     * 表字段：t_item_category.is_parent
     * </pre>
     *
     * @return t_item_category.is_parent：该类目是否为父类目，1为true，0为false
     */
    public Boolean getIsParent() {
        return isParent;
    }

    /**
     * <pre>
     * 设置：该类目是否为父类目，1为true，0为false
     * 表字段：t_item_category.is_parent
     * </pre>
     *
     * @param isParent
     *            t_item_category.is_parent：该类目是否为父类目，1为true，0为false
     */
    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：t_item_category.created
     * </pre>
     *
     * @return t_item_category.created：创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：t_item_category.created
     * </pre>
     *
     * @param created
     *            t_item_category.created：创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：t_item_category.updated
     * </pre>
     *
     * @return t_item_category.updated：创建时间
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：t_item_category.updated
     * </pre>
     *
     * @param updated
     *            t_item_category.updated：创建时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}