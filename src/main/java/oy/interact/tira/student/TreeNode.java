package oy.interact.tira.student;

public class TreeNode<K extends Comparable<K>, V> {
  K key;
  V value;
  TreeNode<K, V> left = null;
  TreeNode<K, V> right = null;
  TreeNode<K, V> parent = null;
  int size = 1;
  public TreeNode() {
  }
  public TreeNode(K key, V value) {
    this.key = key;
    this.value = value;
  }
}
