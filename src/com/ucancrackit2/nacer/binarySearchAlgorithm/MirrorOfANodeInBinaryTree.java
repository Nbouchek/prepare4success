package com.ucancrackit2.nacer.binarySearchAlgorithm;

/**
 * Given a Binary tree, the problem is to find mirror of a given node. The mirror of a node is a node which exist at the mirror position of node in opposite subtree at the root.
 * <p>
 * Examples:
 * mirror_nodes
 * <p>
 * In above tree-
 * Node 2 and 3 are mirror nodes
 * Node 4 and 6 are mirror nodes.
 */

public class MirrorOfANodeInBinaryTree {

    public static void main(String[] args) {

        // populate tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.right = new Node(7);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);

        int target = root.right.left.left.data;
        int mirror = (new MirrorOfANodeInBinaryTree().findMirror(root, target));

        System.out.println(mirror);
    }

    int findMirrorRec(int target, Node left,
                      Node right) {
    /* if any of the Node is none then Node itself
       and decendent have no mirror, so return
       none, no need to further explore! */
        if (left == null || right == null)
            return 0;

    /* if left Node is target Node, then return
       right's key (that is mirror) and vice
       versa */
        if (left.data == target)
            return right.data;

        if (right.data == target)
            return left.data;

        // first recur external Nodes
        int mirror_val = findMirrorRec(target, left.left, right.right);
        if (mirror_val != 0) return mirror_val;

        // if no mirror found, recur internal Nodes
        return findMirrorRec(target, left.right, right.left);
    }

    int findMirror(Node root, int target) {
        if (root == null)
            return 0;
        if (root.data == target)
            return target;
        return findMirrorRec(target, root.left, root.right);
    }
}
