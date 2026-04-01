package ejercicio2;

import java.util.List;

public class Tree {

	private TreeNode root;
	
	public Tree() {
		this.root = null;
	}
	
	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}
	
	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
			}
		}
	}

    public List getLongestBranch() {
        if (this.root == null) return null;

        List lista = new List();
        return getLongestBranch(this.root, lista);
    }

    private List getLongestBranch(TreeNode nodo, List lista) {
        if (nodo == null) return lista;

        lista.add(nodo.getValue());

        int heightLeft;
        if (nodo.getLeft() != null) {
            heightLeft = nodo.getLeft().getHeight();
        } else {
            heightLeft = -1;
        }

        int heightRight;
        if (nodo.getRight() != null) {
            heightRight = nodo.getRight().getHeight();
        } else {
            heightRight = -1;
        }

        if (heightLeft > heightRight) {
            return getLongestBranch(nodo.getLeft(), lista);
        } else {
            return getLongestBranch(nodo.getRight(), lista);
        }
    }
	
}