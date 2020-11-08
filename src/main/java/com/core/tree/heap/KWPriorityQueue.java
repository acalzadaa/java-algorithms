package com.core.tree.heap;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class KWPriorityQueue<E> extends AbstractQueue<E> implements Queue<E> {

	private List<E> data;
	private Comparator<E> comparator;

	public KWPriorityQueue() {
		data = new ArrayList<>();
	}

	public KWPriorityQueue(int cap, Comparator<E> comp) {

		if (cap < 1) {
			throw new IllegalArgumentException();
		}
		data = new ArrayList<>();
		comparator = comp;
	}

	@SuppressWarnings("unchecked")
	private int compare(E left, E right) {

		if (comparator != null) {
			return comparator.compare(left, right);
		} else {
			return ((Comparable<E>) left).compareTo(right);
		}
	}

	public boolean offer(E item) {
		data.add(item);
		int child = data.size() - 1;
		int parent = (child - 1) / 2;

		while (parent >= 0 && compare(data.get(parent), data.get(child)) > 0) {

			swap(parent, child);
			child = parent;
			parent = (child - 1) / 2;
		}
		return true;
	}

	private void swap(int parent, int child) {
		Collections.swap(data, parent, child);
	}

	public E poll() {

		if (isEmpty()) {
			return null;
		}

		E result = data.get(0);

		if (data.size() == 1) {
			data.remove(0);
			return result;
		}

		data.set(0, data.remove(data.size() - 1));
		int parent = 0;
		while (true) {
			int leftChild = 2 * parent + 1;

			if (leftChild >= data.size()) {
				break;
			}

			int rightChild = leftChild + 1;
			int minChild = leftChild;

			if (rightChild < data.size() && compare(data.get(leftChild), data.get(rightChild)) > 0) {
				minChild = rightChild;
			}

			if (compare(data.get(parent), data.get(minChild)) > 0) {
				swap(parent, minChild);
				parent = minChild;
			} else { // Heap property is restored.
				break;
			}
		}

		return result;

	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return data.get(data.size());
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return data.size();
	}

}
