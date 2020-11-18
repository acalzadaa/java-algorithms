package com.core.tree.binary.avl;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class AVLTree {

	private Node root;

	@Data
	@RequiredArgsConstructor
	public static class Node {
		public Node(int key) {
			this.key = key;
		}

		int key;
		int height;
		Node left;
		Node right;
	}

	private int height(Node n) {
		return n == null ? -1 : n.height;
	}

	private int getBalance(Node n) {
		return (n == null) ? 0 : height(n.right) - height(n.left);
	}

	private void updateHeight(Node n) {
		n.height = 1 + Math.max(height(n.left), height(n.right));
	}

	private Node rotateLeft(Node root) {
		Node temp = root.right;
		root.right = temp.left;
		temp.left = root;
		updateHeight(temp);
		updateHeight(root);
		return temp;
	}

	private Node rotateRight(Node root) {
		Node temp = root.left;
		root.left = temp.right;
		temp.right = root;
		updateHeight(temp);
		updateHeight(root);
		return temp;
	}

	private Node rebalance(Node root) {
		updateHeight(root);
		int balance = getBalance(root);

		if (balance > 1) {
			if (height(root.right.right) > height(root.right.left)) {
				root = rotateLeft(root);
			} else {
				root.right = rotateRight(root.right);
				root = rotateLeft(root);
			}
		} else if (balance < -1) {
			if (height(root.left.left) > height(root.left.right)) {
				root = rotateRight(root);
			} else {
				root.left = rotateLeft(root.left);
				root = rotateRight(root);
			}
		}
		return root;
	}

	public Node insert(int key) {
		return insert(root, key);
	}

	private Node insert(Node node, int key) {
		if (node == null) {
			return new Node(key);
		} else if (node.key > key) {
			node.left = insert(node.left, key);
		} else if (node.key < key) {
			node.right = insert(node.right, key);
		} else {
			throw new RuntimeException("duplicate Key!");
		}
		return rebalance(node);
	}

	public Node delete(int key) {
		return delete(root, key);
	}

	private Node delete(Node node, int key) {
		if (node == null) {
			return node;
		} else if (node.key > key) {
			node.left = delete(node.left, key);
		} else if (node.key < key) {
			node.right = delete(node.right, key);
		} else {
			if (node.left == null || node.right == null) {
				node = (node.left == null) ? node.right : node.left;
			} else {
				Node mostLeftChild = mostLeftChild(node.right);
				node.key = mostLeftChild.key;
				node.right = delete(node.right, node.key);
			}
		}
		if (node != null) {
			node = rebalance(node);
		}
		return node;
	}

	private Node mostLeftChild(Node node) {
		Node current = node;
		/* loop down to find the leftmost leaf */
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	public Node find(int key) {
		Node current = root;
		while (current != null) {
			if (current.key == key) {
				break;
			}
			current = current.key < key ? current.right : current.left;
		}
		return current;
	}

}
