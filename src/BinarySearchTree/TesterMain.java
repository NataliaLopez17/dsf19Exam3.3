package BinarySearchTree;

public class TesterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Problem2BST.LinkedBinarySearchTree<String, String> T1 = new Problem2BST.LinkedBinarySearchTree<String,String>();
		T1.add("Moe", "Moe");
		T1.add("Ned", "Ned");
		T1.add("Apu", "Apu");
		T1.add("Cal", "Cal");
		T1.add("Joe", "Joe");
		T1.add("Xi", "Xi");
		T1.add("Ron", "Ron");
		T1.add("Al", "Al");
		
		
		
		int result  = T1.leafCount();
		
		System.out.println(result);

	}

}
