package com.man1s.arithmetic;

public class Tree {

    public static void main(String[] args) {
        Node root = new Node(50, 24);
        Tree tree = new Tree(root);
        tree.insert(20, 530);
        tree.insert(540, 520);
        tree.insert(4, 540);
        tree.insert(0, 550);
        tree.insert(8, 520);
        tree.show(root);
    }

    private Node root;

    public Tree() {

    }

    public Tree(Node root) {
        this.root = root;
    }

    public void insert(int key, Object value) {
        Node node = new Node(key, value);
        if (this.root == null) {
            this.root = node;
        } else {
            Node currentNode = this.root;
            while (true) {
                if (key > currentNode.key) {
                    if (currentNode.rightChildNode == null) {
                        currentNode.rightChildNode = node;
                        return;
                    } else {
                        currentNode = currentNode.rightChildNode;
                    }
                } else {
                    if (currentNode.leftChildNode == null) {
                        currentNode.leftChildNode = node;
                        return;
                    } else {
                        currentNode = currentNode.leftChildNode;
                    }
                }
            }
        }

    }

    public Node find(int key) {
        Node currentNode = this.root;
        if (this.root != null) {
            while (currentNode.key != key) {
                if (key > currentNode.key) {
                    currentNode = currentNode.rightChildNode;
                } else {
                    currentNode = currentNode.leftChildNode;
                }
                if (currentNode == null) {
                    return null;
                }
            }
        }
        return currentNode;
    }

    public void show(Node node) {
        if (node != null) {
            this.show(node.leftChildNode);
            System.out.println(node.key + ":" + node.value);
            this.show(node.rightChildNode);

        }
    }

}

class Node {
    /* key */
    int key;

    /* 值 */
    Object value;

    /* 左节点 */
    Node leftChildNode;

    /* 右节点 */
    Node rightChildNode;

    /** 
     * 构造方法 
     *  
     * @param key 
     *            关键字 
     * @param value 
     *            值 
     */
    public Node(int key, Object value) {
        super();
        this.key = key;
        this.value = value;
    }

}