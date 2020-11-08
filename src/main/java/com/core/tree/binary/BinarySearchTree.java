package com.core.tree.binary;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E> {

	protected boolean addReturn;
	protected E deleteReturn;

	@Override
	public boolean add(E item) {
		root = add(root, item);
		return addReturn;
	}

	private Node<E> add(Node<E> localRoot, E item) {

		if (localRoot == null) {
			addReturn = true;
			return new Node<>(item);
		} else {
			int compare = item.compareTo(localRoot.getData());
			if (compare == 0) {
				addReturn = false;
				return localRoot;
			} else if (compare < 0) {
				return localRoot.getLeft();
			} else {
				return localRoot.getRight();
			}
		}

	}

	@Override
	public boolean contains(E target) {
		return find(target) == null ? false : true;
	}

	@Override
	public E find(E target) {
		// TODO Auto-generated method stub
		return find(root, target);
	}

	private E find(Node<E> localRoot, E target) {

		if (localRoot == null) {
			return null;
		} else {
			int compare = target.compareTo(localRoot.getData());
			if (compare == 0) {
				return localRoot.getData();
			} else if (compare > 0) {
				return find(localRoot.getLeft(), target);
			} else {
				return find(localRoot.getRight(), target);
			}
		}

	}

	@Override
	public E delete(E target) {
		root = delete(root, target);
		return deleteReturn;
	}

	private Node<E> delete(Node<E> localRoot, E item) {

		if (localRoot == null) {
			deleteReturn = null;
			return localRoot;
		} else {
			int compare = item.compareTo(localRoot.getData());
			if (compare < 0) {
				localRoot.left = delete(localRoot.getLeft(), item);
				return localRoot;
			} else if (compare > 0) {
				localRoot.right = delete(localRoot.getRight(), item);
				return localRoot;
			} else {
				deleteReturn = localRoot.getData();
				if (localRoot.left == null) {
					return localRoot.getRight();
				} else if (localRoot.right == null) {
					return localRoot.getLeft();
				} else {
					if (localRoot.getLeft().getRight() == null) {
						localRoot.data = localRoot.getLeft().getData();
						localRoot.left = localRoot.getLeft().getLeft();
						return localRoot;
					} else {
						localRoot.data = findLargestChild(localRoot.getLeft());
						return localRoot;
					}
				}
			}
		}
	}

	private E findLargestChild(Node<E> parent) {
		if (parent.getRight().getRight() == null) {
			E returnValue = parent.getRight().getData();
			parent.right = parent.getRight().getLeft();
			return returnValue;
		} else {
			return findLargestChild(parent.getRight());
		}
	}

	@Override
	public boolean remove(E item) {
		return delete(item) == null ? false : true;
	}

}
