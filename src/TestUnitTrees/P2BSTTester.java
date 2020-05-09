package TestUnitTrees;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import BinarySearchTree.Problem2BST;
import java.util.Iterator;

import org.junit.Before;


class P2BSTTester {

	//empty
		Problem2BST.LinkedBinarySearchTree<String, String> T1 ;
		// one node
		Problem2BST.LinkedBinarySearchTree<String, String> T2 ;
		// 3 nodes
		Problem2BST.LinkedBinarySearchTree<String, String> T3 ;
		// 4 nodes
		Problem2BST.LinkedBinarySearchTree<String, String> T4 ;
		// 8 nodes
		Problem2BST.LinkedBinarySearchTree<String, String> T8 ;


		@Before
		public void setUp() throws Exception {
			this.T1 = new Problem2BST.LinkedBinarySearchTree<String,String>();
			
			this.T2 = new Problem2BST.LinkedBinarySearchTree<String,String>();
			T2.add("Joe", "Joe");
			
			this.T3 = new Problem2BST.LinkedBinarySearchTree<String,String>();
			T3.add("Moe", "Moe");
			T3.add("Ned", "Ned");
			T3.add("Apu", "Apu");




			this.T4 = new Problem2BST.LinkedBinarySearchTree<String,String>();
			T4.add("Moe", "Moe");
			T4.add("Ned", "Ned");
			T4.add("Apu", "Apu");
			T4.add("Cal", "Cal");

			this.T8 = new Problem2BST.LinkedBinarySearchTree<String,String>();
			T8.add("Moe", "Moe");
			T8.add("Ned", "Ned");
			T8.add("Apu", "Apu");
			T8.add("Cal", "Cal");
			T8.add("Joe", "Joe");
			T8.add("Xi", "Xi");
			T8.add("Ron", "Ron");
			T8.add("Al", "Al");

		}
		
		@Test
		public void testleafCount1() {
			assertEquals("Fails leafCount() on empty tree", 0, this.T1.leafCount());
			
		}

		@Test
		public void testleafCount2() {
			assertEquals("Fails leafCount() on one node tree", 1, this.T2.leafCount());
			
		}
		@Test
		public void testleafCount3() {
			assertEquals("Fails leafCount() on 3-node tree", 2, this.T3.leafCount());
			
		}
		@Test
		public void testleafCount4() {
			assertEquals("Fails leafCount() on 5-node tree", 2, this.T4.leafCount());
			
		}
		
		@Test
		public void testleafCount5() {
			//T8.print();
			assertEquals("Fails leafCount() on 5-node tree", 3, this.T8.leafCount());
			
		}
		
		@Test
		public void testInternals1() {
			//T1.print();
			Iterator<Problem2BST.Entry<String, String>> I = this.T1.internals().iterator();
			assertEquals("Fails internals() on empty tree", false, I.hasNext());
			
		}
		
		@Test
		public void testInternals2() {
			//T2.print();
			Iterator<Problem2BST.Entry<String, String>> I = this.T2.internals().iterator();
			assertEquals("Fails internals() on one node tree", false, I.hasNext());
		}
		
		@Test
		public void testInternals3() {
			//T3.print();
			Iterator<Problem2BST.Entry<String, String>> I = this.T3.internals().iterator();
			assertEquals("Fails internals() on 3-node tree", "Moe", I.next().getKey());
		}
		
		
		@Test
		public void testInternals4() {
			//T4.print();
			
			Iterator<Problem2BST.Entry<String, String>> I = this.T4.internals().iterator();
//			List<Problem2BST.Entry<String, String>> list = new ArrayList<Problem2BST.Entry<String, String>>();
//			I.forEachRemaining(list::add);
//			for (Problem2BST.Entry<String, String> a: list) {
//				System.out.println("element: "+ a.getKey());
//			}
			
			
			assertEquals("Fails internals() on 4-node tree", "Moe", I.next().getKey());
			assertEquals("Fails internals() on 4-node tree", "Apu", I.next().getKey());

		}
		@Test
		public void testInternals5() {
			//T8.print();
			Iterator<Problem2BST.Entry<String, String>> I = this.T8.internals().iterator();
//			List<Problem2BST.Entry<String, String>> list = new ArrayList<Problem2BST.Entry<String, String>>();
//			I.forEachRemaining(list::add);
//			for (Problem2BST.Entry<String, String> a: list) {
//				System.out.println("element: "+ a.getKey());
//			}
			assertEquals("Fails internals() on 8-node tree", "Moe", I.next().getKey());
			assertEquals("Fails internals() on 8-node tree", "Apu", I.next().getKey());
			assertEquals("Fails internals() on 8-node tree", "Cal", I.next().getKey());
			assertEquals("Fails internals() on 8-node tree", "Ned", I.next().getKey());
			assertEquals("Fails internals() on 8-node tree", "Xi", I.next().getKey());

		}

}
