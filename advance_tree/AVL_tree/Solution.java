package advance_tree.AVL_tree;

class Node {
    int val;   //Value
    int ht;      //Height
    Node left;   //Left child
    Node right;   //Right child
}

class Solution {
    static Node insert(Node root, int val) {
        if (root == null) {
            Node node = new Node();
            node.val = val;
            return node;
        } else {
            if (root.val > val) {
                root.left = insert(root.left, val);
                if (height(root.left) - height(root.right) >= 2) {
                    if (height(root.left.right) - height(root.left.left) >= 1) {
                        return doubleRightLeftRotate(root);
                    } else {
                        return rightRotate(root);
                    }
                }
            } else if (root.val < val) {
                root.right = insert(root.right, val);
                if (height(root.right) - height(root.left) >= 2) {
                    if (height(root.right.left) - height(root.right.right) >= 1) {
                        return doubleLeftRightRotate(root);
                    } else {
                        return leftRotate(root);
                    }
                }
            }
            root.ht = Math.max(height(root.left), height(root.right)) + 1;
            return root;

        }
    }

    public static Node doubleLeftRightRotate(Node node) {
        node.right = rightRotate(node.right);

        return leftRotate(node);
    }

    public static Node doubleRightLeftRotate(Node node) {
        node.left = leftRotate(node.left);

        return rightRotate(node);
    }

    public static Node leftRotate(Node node) {
        Node righNode = node.right;
        node.right = righNode.left;
        righNode.left = node;
        node.ht = Math.max(height(node.left), height(node.right)) + 1;
        righNode.ht = Math.max(height(righNode.left), height(righNode.right)) + 1;
        return righNode;
    }

    public static Node rightRotate(Node node) {
        Node leftNode = node.left;
        node.left = (leftNode.right);
        leftNode.right = (node);
        node.ht = Math.max(height(node.left), height(node.right)) + 1;
        leftNode.ht = Math.max(height(leftNode.left), height(leftNode.right)) + 1;
        return leftNode;
    }

    static int height(Node node) {
        if (node != null) {
            return node.ht;
        } else {
            return -1;
        }
    }
}