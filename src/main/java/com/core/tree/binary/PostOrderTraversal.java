package com.core.tree.binary;

import com.core.tree.binary.BinaryTree.Node;

public class PostOrderTraversal {
	static BinaryTree root;

	public static void main(String[] args) {

		postOrderTraversal(createNodeTree());

	}

	private static void postOrderTraversal(BinaryTree binaryTree) {
		if (binaryTree != null) {
			postOrderTraversal(binaryTree.getLeftSubtree());
			postOrderTraversal(binaryTree.getRightSubTree());
			System.out.println(binaryTree.getRoot().getData());

		}
	}

	private static BinaryTree createNodeTree() {
		BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(new Node<Integer>(5));
		binaryTree.getRoot().left = new Node<Integer>(10);
		binaryTree.root.right = new Node<Integer>(19);

		return binaryTree;
	}
}
