package com.core.tree.binary;

import com.core.tree.binary.BinaryTree.Node;

public class PreOrderTraversal {

	static BinaryTree root;

	public static void main(String[] args) {

		preOrderTraversal(createNodeTree());

	}

	private static void preOrderTraversal(BinaryTree binaryTree) {
		if (binaryTree != null) {
			System.out.println(binaryTree.getRoot().getData());
			preOrderTraversal(binaryTree.getLeftSubtree());
			preOrderTraversal(binaryTree.getRightSubTree());
		}
	}

	private static BinaryTree createNodeTree() {
		BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(new Node<Integer>(5));
		binaryTree.getRoot().left = new Node<Integer>(10);
		binaryTree.root.right = new Node<Integer>(19);

		return binaryTree;
	}

}
