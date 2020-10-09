package main.JAVA基础;

import java.util.ArrayList;

public class _20200715_Lockdemo {

    public static void main(String[] args) {
    }
}

/**
 * Thread 1: parent.addChild(child); //locks parent
 *           --> child.setParentOnly(parent);
 *
 * Thread 2: child.setParent(parent); //locks child
 *           --> parent.addChildOnly()
 */
class TreeNode {
    TreeNode parent = null;
    ArrayList<TreeNode> children = new ArrayList();

    public synchronized void addChild(TreeNode child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            child.setParentOnly(this);
        }
    }

    public synchronized void addChildOnly(TreeNode child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
        }
    }

    public synchronized void setParent(TreeNode parent) {
        this.parent = parent;
        parent.addChildOnly(this);
    }

    public synchronized void setParentOnly(TreeNode parent) {
        this.parent = parent;
    }
}