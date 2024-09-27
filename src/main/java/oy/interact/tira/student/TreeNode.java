package oy.interact.tira.student;

import java.util.Comparator;

public class TreeNode<K extends Comparable<K>, V> {
  K key;
  V value;
  TreeNode<K, V> left = null;
  TreeNode<K, V> right = null;
  TreeNode<K, V> parent = null;
  public TreeNode() {
  }
  public TreeNode(K key, V value) {
    this.key = key;
    this.value = value;
  }
  // public void add(TreeNode<K, V> node, Comparator<K> comparator) {
  //   TreeNode<K, V> temp = this;
  //   while (temp != null) {
  //     if (comparator.compare(this.key, node.key) < 0) {
  //       if (right == null) {
  //         right = node;
  //         right.parent = this;
  //       }
  //       else {
  //         temp = temp.right;
  //       }
  //     }
  //     else {
  //       if (left == null) {
  //         left = node;
  //         left.parent = this;
  //       }
  //       else {
  //         temp = temp.left;
  //       }
  //     }
  //   }
  // }
}
