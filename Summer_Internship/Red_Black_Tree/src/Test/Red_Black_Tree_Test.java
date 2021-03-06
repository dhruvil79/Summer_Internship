package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Logic_Of_Code.Red_Black_Tree;
import Logic_Of_Code.Red_Black_Tree.Node;

public class Red_Black_Tree_Test {

	@Test
	public void test() {
		Red_Black_Tree<Integer> rbti=new Red_Black_Tree<>();
		rbti.insert(50);
		Node node=rbti.getRoot();
		assertEquals(node.data,50);
		
		rbti.insert(78);
		rbti.insert(4);
		rbti.insert(88);
		rbti.insert(15);
		rbti.insert(99);
		rbti.insert(26);
		rbti.insert(48);
		rbti.insert(69);
		
		node=rbti.minimum(rbti.getRoot());
		assertEquals(node.data,4);
		
		node=rbti.maximum(rbti.getRoot());
		assertEquals(node.data,99);
		
		boolean t=rbti.searchTree(15);
		assertEquals(t, true);
		

	}

}
