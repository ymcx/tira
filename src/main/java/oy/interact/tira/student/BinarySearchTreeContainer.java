package oy.interact.tira.student;

import oy.interact.tira.util.TIRAKeyedOrderedContainer;
import java.util.Comparator;
import java.util.function.Predicate;
import oy.interact.tira.util.Pair;
import oy.interact.tira.util.Visitor;

public class BinarySearchTreeContainer<K extends Comparable<K>, V> implements TIRAKeyedOrderedContainer<K, V> {
  private TreeNode<K, V> root;
  private int size = 0;
  private Comparator<K> comparator;

  public BinarySearchTreeContainer(Comparator<K> comparator) {
    this.comparator = comparator;
  }

  private void indexOf(TreeNode<K, V> node, int[] count, int[] result, K itemKey) {
    if (node == null) {
      return;
    }
    indexOf(node.left, count, result, itemKey);
    ++count[0];
    if (comparator.compare(node.key, itemKey) == 0) {
      result[0] = count[0];
    }
    indexOf(node.right, count, result, itemKey);
  }

  @Override
  public int indexOf(K itemKey) {
    int[] count = {-1};
    int[] result = {-1};
    indexOf(root, count, result, itemKey);
    return result[0];
  }
  
  private void getIndex(TreeNode<K, V> node, int[] count, Object[] result, int index) {
    if (node == null) {
      return;
    }
    getIndex(node.left, count, result, index);
    ++count[0];
    if (count[0] == index) {
      result[0] = node;
    }
    getIndex(node.right, count, result, index);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Pair<K,V> getIndex(int index) throws IndexOutOfBoundsException {
    if (index >= size) {
      throw new IndexOutOfBoundsException();
    }
    int[] count = {-1};
    Object[] result = {null};
    getIndex(root, count, result, index);
    return new Pair<K, V>(
      ((TreeNode<K, V>)result[0]).key,
      ((TreeNode<K, V>)result[0]).value
    );
  }
  
  private void findIndex(TreeNode<K, V> node, int[] count, int[] result, Predicate<V> searcher) {
    if (node == null) {
      return;
    }
    findIndex(node.left, count, result, searcher);
    ++count[0];
    if (searcher.test(node.value)) {
      result[0] = count[0];
    }
    findIndex(node.right, count, result, searcher);
  }
  
  @Override
  public int findIndex(Predicate<V> searcher) {
    int[] count = {-1};
    int[] result = {-1};
    findIndex(root, count, result, searcher);
    return result[0];
  }
  
  @Override
  public void accept(Visitor<K,V> visitor) throws Exception {
  }

  @Override
  public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
    if (key == null || value == null) {
      throw new IllegalArgumentException();
    }
    TreeNode<K, V> newNode = new TreeNode<K, V>(key, value);
    if (root == null) {
      root = newNode;
      ++size;
      return;
    }
    TreeNode<K, V> node = root;
    while (true) {
      if (node.value == value) {
        node.value = null;
        --size;
      }
      if (comparator.compare(node.key, key) < 0) {
        if (node.right == null) {
          node.right = newNode;
          node.right.parent = node;
          ++size;
          return;
        }
        node = node.right;
      }
      else {
        if (node.left == null) {
          node.left = newNode;
          node.left.parent = node;
          ++size;
          return;
        }
        node = node.left;
      }
    }
  }

  @Override
  public V get(K key) throws IllegalArgumentException {
    if (key == null) {
      throw new IllegalArgumentException();
    }
    TreeNode<K, V> node = findByKey(key);
    if (node == null) {
      return null;
    }
    return node.value;
  }

  @Override
  public V remove(K key) throws IllegalArgumentException {
    if (key == null) {
      throw new IllegalArgumentException();
    }
    TreeNode<K, V> node = findByKey(key);
    V copy = node.value;
    if (node.left == null) {
      transplant(node, node.right);
    }
    else if (node.right == null) {
      transplant(node, node.left);
    }
    else {
      TreeNode<K, V> nodeToLift = min(node.right);
      if (nodeToLift.parent != node) {
        transplant(nodeToLift, nodeToLift.right);
        nodeToLift.right = node.right;
        nodeToLift.right.parent = nodeToLift;
      }
      transplant(node, nodeToLift);
      nodeToLift.left = node.left;
      nodeToLift.left.parent = nodeToLift;
    }
    --size;
    return copy;
  }

  private void find(TreeNode<K, V> node, Object[] result, Predicate<V> searcher) {
    if (node == null) {
      return;
    }
    find(node.left, result, searcher);
    if (node.value != null && searcher.test(node.value)) {
      result[0] = node.value;
    }
    find(node.right, result, searcher);
  }

  @SuppressWarnings("unchecked")
  @Override
  public V find(Predicate<V> searcher) {
    Object[] result = new Object[1];
    find(root, result, searcher);
    return (V) result[0];
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public int capacity() {
    return Integer.MAX_VALUE;
  }

  @Override
  public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
    if (capacity <= size) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void clear() {
    root = null;
    size = 0;
  }

  private void toArrayHelp(TreeNode<K, V> node, int[] count, Pair<K, V>[] result) {
    if (node == null) {
      return;
    }
    toArrayHelp(node.left, count, result);
    ++count[0];
    result[count[0]] = new Pair<K, V>(node.key, node.value);
    toArrayHelp(node.right, count, result);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Pair<K, V>[] toArray() throws Exception {
    int[] count = {-1};
    Pair<K, V>[] result = new Pair[size];
    toArrayHelp(root, count, result);
    return result;
  }

  private TreeNode<K, V> min(TreeNode<K, V> node) {
    if (node.left == null) {
      return node;
    }
    return min(node.left);
  }

  @SuppressWarnings("unused")
  private TreeNode<K, V> max(TreeNode<K, V> node) {
    if (node.right == null) {
      return node;
    }
    return max(node.right);
  }
  
  private void transplant(TreeNode<K, V> u, TreeNode<K, V> v) {
    if (u.parent == null) {
      root = v;
    }
    else if (u == u.parent.left) {
      u.parent.left = v;
    }
    else {
      u.parent.right = v;
    }
    if (v != null) {
      v.parent = u.parent;
    }
  }
  
  private TreeNode<K, V> findByKey(K key) {
    TreeNode<K, V> node = root;
    while (node != null) {
      int comparison = comparator.compare(node.key, key);
      if (comparison == 0) {
        return node;
      }
      if (comparison < 0) {
        node = node.right;
      }
      else {
        node = node.left;
      }
    }
    return null;
  }
}
