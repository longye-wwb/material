package com.crledu.auto.util.tree;

import java.util.List;

/**
 ************************************************************
 * @Description: 树形结构的节点形态。
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/6/30 17:00
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class TreeNode {

    /**
     * 树节点主键
     */
    private Long id;

    /**
     * 父节点的主键
     */
    private Long parent;

    /**
     * 是否是根节点
     */
    private Boolean isRoot = false;

    /**
     * 子节点列表
     */
    private List<TreeNode> children;

}
