package TestUnitTrees;
import BinaryTrees.Problem1SBTImp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.Before;

class P1SBTTester {

	Problem1SBTImp.SimpleBinaryTreeImp<String> T1 ;
	Problem1SBTImp.SimpleBinaryTreeImp<String> T2 ;
	Problem1SBTImp.SimpleBinaryTreeImp<String> T3 ;
	Problem1SBTImp.SimpleBinaryTreeImp<String> T4 ;
	Problem1SBTImp.SimpleBinaryTreeImp<String> T5 ;


	@Before
	public void setUp() throws Exception {
		// T1
		T1 = new Problem1SBTImp.SimpleBinaryTreeImp<String>(null);
		
		// T2
		T2 = new Problem1SBTImp.SimpleBinaryTreeImp<String>(new Problem1SBTImp.BinaryTreeNode<String>("Ned"));
		
		// T3
		Problem1SBTImp.SimpleBinaryTreeImp<String> t2  = new Problem1SBTImp.SimpleBinaryTreeImp<String>(new Problem1SBTImp.BinaryTreeNode<String>("Ned"));
		Problem1SBTImp.SimpleBinaryTreeImp<String> t3 = new Problem1SBTImp.SimpleBinaryTreeImp<String>(new Problem1SBTImp.BinaryTreeNode<String>("Jim"));
		Problem1SBTImp.SimpleBinaryTreeImp<String> t4 = new Problem1SBTImp.SimpleBinaryTreeImp<String>(new Problem1SBTImp.BinaryTreeNode<String>("Bob"), t2, t3);
		Problem1SBTImp.SimpleBinaryTreeImp<String> t5 = new Problem1SBTImp.SimpleBinaryTreeImp<String>(new Problem1SBTImp.BinaryTreeNode<String>("Joe"));
		Problem1SBTImp.SimpleBinaryTreeImp<String> t6 = new Problem1SBTImp.SimpleBinaryTreeImp<String>(new Problem1SBTImp.BinaryTreeNode<String>("Kim"));
		Problem1SBTImp.SimpleBinaryTreeImp<String> t7 = new Problem1SBTImp.SimpleBinaryTreeImp<String>(new Problem1SBTImp.BinaryTreeNode<String>("Al"), t5, t6);
		T3 = new Problem1SBTImp.SimpleBinaryTreeImp<String>(new Problem1SBTImp.BinaryTreeNode<String>("Moe"), t7, t4);
		
		// T4
		t2 = new Problem1SBTImp.SimpleBinaryTreeImp<String>(new Problem1SBTImp.BinaryTreeNode<String>("Ned"));
		t3 = new Problem1SBTImp.SimpleBinaryTreeImp<String>(new Problem1SBTImp.BinaryTreeNode<String>("Jim"));
		T4 =  new Problem1SBTImp.SimpleBinaryTreeImp<String>(new Problem1SBTImp.BinaryTreeNode<String>("Bob"), t2, t3);

		// T5
		t2 = new Problem1SBTImp.SimpleBinaryTreeImp<String>(new Problem1SBTImp.BinaryTreeNode<String>("Ned"));
		T5 =  new Problem1SBTImp.SimpleBinaryTreeImp<String>(new Problem1SBTImp.BinaryTreeNode<String>("Apu"), t2, null);

	}

	@Test
	public void testSize1() {
		assertEquals("Fails size() on empty tree", 0, this.T1.size());
		
	}
	@Test
	public void testSize2() {
	
		assertEquals("Fails size() on tree with one node", 1, this.T2.size());
		
	}
	@Test
	public void testSize3() {
	
		assertEquals("Fails size() on tree with 3 nodes", 3, this.T4.size());
	
	}
	
	@Test
	public void testSize4() {
	
		assertEquals("Fails size() on tree with 2 nodes", 2, this.T5.size());
	
	}
	
	@Test
	public void testSize5() {

		assertEquals("Fails size() on tree with 7 nodes", 7, this.T3.size());
	}
	
	
	@Test
	public  void testGetPath1() {
		assertEquals("Fails getPath(\"Ned\") on empty tree", 0, this.T1.getPath("Ned").size());
	}

	@Test
	public  void testGetPath2() {
		assertEquals("Fails getPath(\"Ned\") on tree with one node.", 1, this.T2.getPath("Ned").size());
	}

	@Test
	public  void testGetPath3() {
		assertEquals("Fails getPath(\"Apu\") on tree with one node.", 0, this.T2.getPath("Apu").size());
		
	}
	@Test
	public  void testGetPath4() {

		List<Problem1SBTImp.Position<String>> L = this.T4.getPath("Ned");

		assertTrue("Fails getPath(\"Ned\") on tree with 3 node.", L.get(0).getValue().equals("Bob") 
				&& L.get(1).getValue().equals("Ned"));
	}
	@Test
	public  void testGetPath5() {

		List<Problem1SBTImp.Position<String>> L = this.T3.getPath("Ned");

		assertTrue("Fails getPath(\"Ned\") on tree with 7 node.", L.get(0).getValue().equals("Moe") && L.get(1).getValue().equals("Bob") 
					&& L.get(2).getValue().equals("Ned"));
	}
	@Test
	public  void testGetPath6() {

		List<Problem1SBTImp.Position<String>> L = this.T3.getPath("Jacinto");
		assertEquals("Fails getPath(\"Jacinto\") on tree with one node.", 0, L.size());
	}

}
