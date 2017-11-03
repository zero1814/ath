var Tree = {
	id : "",
	nodeCheckedSilent : false,
	nodeUncheckedSilent : false,
	init:function(id,showCheckbox,data,onNodeSelected){
		Tree.id = id;
		$('#'+Tree.id).treeview({
			levels : 1,
			data : data,
			showCheckbox:showCheckbox,
			onNodeChecked:Tree.nodeChecked ,  
	        onNodeUnchecked:Tree.nodeUnchecked,
			onNodeSelected : onNodeSelected
		});
	},
	nodeChecked : function(event, node) {
		if (Tree.nodeCheckedSilent) {
			return;
		}
		Tree.nodeCheckedSilent = true;
		Tree.checkAllParent(node);
		Tree.checkAllChild(node);
		Tree.nodeCheckedSilent = false;
	},
	nodeUnchecked : function(event, node) {
		if (Tree.nodeUncheckedSilent)
			return;
		Tree.nodeUncheckedSilent = true;
		Tree.uncheckAllParent(node);
		Tree.uncheckAllChild(node);
		Tree.nodeUncheckedSilent = false;
	},
	/**
	 * 选中全部父节点
	 * 
	 * @param node
	 */
	checkAllParent : function(node) {
		$('#' + Tree.id).treeview('checkNode', node.nodeId, {
			silent : true
		});
		var parentNode = $('#' + Tree.id).treeview('getParent', node.nodeId);
		if (!("id" in parentNode)) {
			return;
		} else {
			Tree.checkAllParent(parentNode);
		}
	},
	/**
	 * 取消全部父节点
	 * 
	 * @param node
	 * @returns
	 */
	uncheckAllParent : function(node) {
		$('#' + Tree.id).treeview('uncheckNode', node.nodeId, {
			silent : true
		});
		var siblings = $('#' + Tree.id).treeview('getSiblings', node.nodeId);
		var parentNode = $('#' + Tree.id).treeview('getParent', node.nodeId);
		if (!("id" in parentNode)) {
			return;
		}
		var isAllUnchecked = true; // 是否全部没选中
		for ( var i in siblings) {
			if (siblings[i].state.checked) {
				isAllUnchecked = false;
				break;
			}
		}
		if (isAllUnchecked) {
			Tree.uncheckAllParent(parentNode);
		}
	},
	/**
	 * 级联选中所有子节点
	 * 
	 * @param node
	 */
	checkAllChild : function(node) {
		$('#' + Tree.id).treeview('checkNode', node.nodeId, {
			silent : true
		});
		if (node.nodes != null && node.nodes.length > 0) {
			for ( var i in node.nodes) {
				Tree.checkAllChild(node.nodes[i]);
			}
		}
	},
	/**
	 * 级联取消所有子节点
	 * 
	 * @param node
	 */
	uncheckAllChild : function(node) {
		$('#' + Tree.id).treeview('uncheckNode', node.nodeId, {
			silent : true
		});
		if (node.nodes != null && node.nodes.length > 0) {
			for ( var i in node.nodes) {
				Tree.uncheckAllChild(node.nodes[i]);
			}
		}
	}
};