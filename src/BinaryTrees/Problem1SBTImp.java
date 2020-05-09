package BinaryTrees;
import java.util.ArrayList;
import java.util.List;

public class Problem1SBTImp {
public static interface Position<E> {
		
		public E getValue();

	}

	public static class BinaryTreeNode<E> implements Position<E> {

		private E value;
		private BinaryTreeNode<E> leftChild;
		private BinaryTreeNode<E> rightChild;
		private BinaryTreeNode<E> parent;

		

		public BinaryTreeNode(E value) {
			super();
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
			this.parent = null;

		}

		
		public BinaryTreeNode(E value, BinaryTreeNode<E> parent, BinaryTreeNode<E> leftChild, BinaryTreeNode<E> rightChild) {
			super();
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.parent = parent;
		}

		@Override
		public E getValue() {
			return this.value;

		}


		public BinaryTreeNode<E> getLeftChild() {
			return leftChild;
		}


		public void setLeftChild(BinaryTreeNode<E> leftChild) {
			this.leftChild = leftChild;
		}


		public BinaryTreeNode<E> getRightChild() {
			return rightChild;
		}


		public void setRightChild(BinaryTreeNode<E> rightChild) {
			this.rightChild = rightChild;
		}


		public void setValue(E value) {
			this.value = value;
		}


		public BinaryTreeNode<E> getParent() {
			return parent;
		}


		public void setParent(BinaryTreeNode<E> parent) {
			this.parent = parent;
		}

	}

	public static interface SimpleBinaryTree<E> {

		// get tree root
		public Position<E> root();
		
		// get left child of node
		public Position<E> left(Position<E> p);
		
		// get right child of node
		public Position<E> right(Position<E> p);
		
		// get sibling
		public Position<E> sibling(Position<E> p);

		// 
		public boolean isEmpty();
		
		// Get all the nodes in the path from root to node with value e
		// return empty list if node with valeu e is not  found.
		public List<Position<E>> getPath(E e);

		// return size of the tree
		public int size(); 

	}	

	public static class SimpleBinaryTreeImp<E> implements SimpleBinaryTree<E> {
		
		private BinaryTreeNode<E> root;
		

		
		public SimpleBinaryTreeImp(BinaryTreeNode<E> root) {
			super();
			this.root = root;
		}
		
		public SimpleBinaryTreeImp(BinaryTreeNode<E> root, 
				SimpleBinaryTree<E> T1, SimpleBinaryTree<E> T2) {
			super();
			this.root = root;
			if (T1 != null) {
				BinaryTreeNode<E> temp = (BinaryTreeNode<E>)T1.root();
				this.root.setLeftChild(temp);
				temp.setParent(this.root);
				
			}
			if (T2 != null) {
				BinaryTreeNode<E> temp = (BinaryTreeNode<E>)T2.root();

				this.root.setRightChild(temp);
				temp.setParent(this.root);

			}

		}



		@Override
		public Position<E> root() {
			return this.root;
		}


		private void check(Position<E> p) {
			if (p==null) {
				throw new IllegalArgumentException();
			}
		}
		@Override
		public Position<E> left(Position<E> p) {
			this.check(p);
			BinaryTreeNode<E> temp = (BinaryTreeNode<E>)p;
			return temp.getLeftChild();
		}


		@Override
		public Position<E> right(Position<E> p) {
			this.check(p);
			BinaryTreeNode<E> temp = (BinaryTreeNode<E>)p;
			return temp.getRightChild();

		}

		@Override
		public Position<E> sibling(Position<E> p) {
			this.check(p);
			BinaryTreeNode<E> temp = (BinaryTreeNode<E>)p;
			if (temp.getParent().getLeftChild() != temp) {
				return temp.getParent().getRightChild();
			}
			else {
				return temp.getParent().getLeftChild();
			}

		}
		
		@Override
		public boolean isEmpty() {
			return this.size() == 0;
		}

		//////////////////////////////////////////////////
		// FOR STUDENTS
		// Find the positions that form the path from root to first
		// copy of e in the tree. The value is search for in pre-order.
		// Asume e has method equals() implemented correctly.
		// Returns a list of positions from root to e. 
		// Returns empty list if e is not found.
		@Override
		public List<Position<E>> getPath(E e) {
			List<Position<E>> L = new ArrayList<Position<E>>();
			Position<E> p = this.root();
//			return L;
			return this.getPathAux(p, e, L);
			
		}
		public List<Position<E>> getPathAux(Position<E> p,E e,List<Position<E>> L) {
			if (p==null)
				return L;
			else {
				if (p.getValue().equals(e)) {
					L.add(p);
//					L.add(this.left(p));
//					L.add(this.right(p));
					
				}
				else {
					getPathAux(left(p), e, L);getPathAux(right(p), e, L);
				}
				return L;
			}
			
		}
	
		//////////////////////////////////////////////////


		//////////////////////////////////////////////////
		// FOR STUDENTS
		// Finds the size of the tree. Hint: use recursion.
		// Empty tree has size 0, and tree with one node has size 1.
		@Override
		public int size() {
			// ADD YOUR CODE HERE
			
			return this.sizeAux(root());
			// CHANGE THIS RETURN VALUE

		}
		public int sizeAux(Position<E> p) {
			if(p==null)
				return 0;
			else
				if (left(p)==null && right(p) ==null)
					return 1;
				else
					return 1 + sizeAux(left(p)) +sizeAux(right(p));
		}

		
		//////////////////////////////////////////////////
		public void print() {
			this.printAux(this.root, 0);
		}

		private void printAux(BinaryTreeNode<E> N, int i) {
			if (N != null) {
				this.printAux(N.getRightChild(), i + 4);
				for (int j=0; j < i; ++j) {
					System.out.print(" ");
				}
				System.out.println(N.getValue());
				this.printAux(N.getLeftChild(), i + 4);
			}
			
		}

	}

}
