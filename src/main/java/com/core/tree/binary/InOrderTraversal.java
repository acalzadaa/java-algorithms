package com.core.tree.binary;

import com.core.tree.binary.BinaryTree.Node;

public class InOrderTraversal {
	static BinaryTree root;

	public static void main(String[] args) {

		inOrderTraversal(createNodeTree());

	}

	private static void inOrderTraversal(BinaryTree binaryTree) {
		if (binaryTree != null) {
			inOrderTraversal(binaryTree.getLeftSubtree());
			System.out.println(binaryTree.getRoot().getData());
			inOrderTraversal(binaryTree.getRightSubTree());
		}
	}

	private static BinaryTree createNodeTree() {
		BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(new Node<Integer>(5));
		binaryTree.getRoot().left = new Node<Integer>(10);
		binaryTree.root.right = new Node<Integer>(19);

		return binaryTree;
	}
}
