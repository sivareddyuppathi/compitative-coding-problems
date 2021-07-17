package com.coding.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BinaryTreeUtil implements BinaryTree {
	TreeNode root;

	@Override
	public TreeNode lowestCommonAncestorReccu(TreeNode p, TreeNode q) {
		return lCAUtilReccu(root, p, q);
	}

	private TreeNode lCAUtilReccu(TreeNode rootCopy, TreeNode p, TreeNode q) {
		if (rootCopy == null || rootCopy == p || rootCopy == q)
			return rootCopy;
		TreeNode left = lCAUtilReccu(rootCopy.left, p, q);
		TreeNode right = lCAUtilReccu(rootCopy.right, p, q);
		return left == null ? right : right == null ? left : rootCopy;
	}

	@Override
	public TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
		return lCAUtilIttr(root, p, q);
	}

	private TreeNode lCAUtilIttr(TreeNode rootCopy, TreeNode p, TreeNode q) {

		Map<TreeNode, TreeNode> parent = new HashMap<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		parent.put(rootCopy, null);
		stack.push(rootCopy);

		while (!parent.containsKey(p) || !parent.containsKey(q)) {
			TreeNode node = stack.pop();
			if (node.left != null) {
				parent.put(node.left, node);
				stack.push(node.left);
			}
			if (node.right != null) {
				parent.put(node.right, node);
				stack.push(node.right);
			}
		}
		Set<TreeNode> ancestors = new HashSet<>();
		while (p != null) {
			ancestors.add(p);
			p = parent.get(p);
		}
		while (!ancestors.contains(q))
			q = parent.get(q);
		return q;
	}

}
