package com.core.tree.binary;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class BinaryTree<E> implements Serializable {

	protected Node<E> root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(Node<E> root) {
		this.root = root;
	}

	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		this.root = new Node<E>(data);
		this.root.left = leftTree != null ? leftTree.getRoot() : null;
		this.root.right = rightTree != null ? rightTree.getRoot() : null;
	}

	@Data
	public static class Node<E> implements Serializable {
		protected Node<E> left;
		protected Node<E> right;
		protected E data;

		public Node(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public BinaryTree<E> getLeftSubtree() {

		return root != null && root.left != null ? new BinaryTree<>(root.left) : null;

	}

	public BinaryTree<E> getRightSubTree() {
		return root != null && root.left != null ? new BinaryTree<>(root.right) : null;
	}

	public boolean isLeaf() {
		return (root.left == null && root.right == null);
	}

}
