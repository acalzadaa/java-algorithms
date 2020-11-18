package com.core.graph.temp;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Node<T> {

	private T data = null;
	private List<Node<T>> children = new ArrayList<>();
	private Node<T> parent = null;

	public Node(T data) {
		this.data = data;
	}

	public Node<T> addChild(Node<T> child) {
		child.setParent(this);
		this.children.add(child);
		return child;
	}

	public void addChildren(List<Node<T>> children) {
		children.forEach(each -> each.setParent(this));
		this.children.addAll(children);
	}

}
