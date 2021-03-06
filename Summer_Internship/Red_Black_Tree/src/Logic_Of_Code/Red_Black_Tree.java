//Implementing Red-Black Tree in Java

package Logic_Of_Code;
import Interface.*;

public class Red_Black_Tree<T extends Comparable<T>> implements Red_Black_Tree_Interface<T>  {
	
	public  enum Color
	{
		RED,
		BLACK	
	}
	public class Node 
	{
		public T data;
		Node parent;
		Node left;
		Node right;
		Color color;
	}
	public Red_Black_Tree() {
		TNULL = new Node();
		TNULL.color = Color.BLACK;
		TNULL.left = null;
		TNULL.right = null;
		root = TNULL;
	}
	
	private Node root;
	private Node TNULL;

	// Preorder
	private void preOrderHelper(Node node) {
		if (node != TNULL) {
			System.out.print(node.data + " ");
			preOrderHelper(node.left);
			preOrderHelper(node.right);
		}
	}

	// Inorder
	private void inOrderHelper(Node node) {
		if (node != TNULL) {
			inOrderHelper(node.left);
			System.out.print(node.data + " ");
			inOrderHelper(node.right);
		}
	}

	// Post order
	private void postOrderHelper(Node node) {
		if (node != TNULL) {
			postOrderHelper(node.left);
			postOrderHelper(node.right);
			System.out.print(node.data + " ");
		}
	}

	// Search the tree
	private boolean searchTreeHelper(Node node, T key) {
		boolean found=false;
		while((node!=TNULL) && !found)
		{
			T rval = node.data;
            if (key.compareTo(rval) <0)
                node = node.left;
            else if (key.compareTo(rval) > 0)
                node = node.right;
            else
            {
                found = true;
                break;
            }
            searchTreeHelper(node, key);
		}
		return found;
	}

	// Balance the node after insertion
	private void fixInsert(Node k) {
		Node u;
		while (k.parent.color == Color.RED) {
			if (k.parent == k.parent.parent.right) {
				u = k.parent.parent.left;
				if (u.color == Color.RED) {
					u.color = Color.BLACK;
					k.parent.color = Color.BLACK;
					k.parent.parent.color = Color.RED;
					k = k.parent.parent;
				} else {
					if (k == k.parent.left) {
						k = k.parent;
						rightRotate(k);
					}
					k.parent.color = Color.BLACK;
					k.parent.parent.color = Color.RED;
					leftRotate(k.parent.parent);
				}
			} else {
				u = k.parent.parent.right;

				if (u.color == Color.RED) {
					u.color = Color.BLACK;
					k.parent.color = Color.BLACK;
					k.parent.parent.color = Color.RED;
					k = k.parent.parent;
				} else {
					if (k == k.parent.right) {
						k = k.parent;
						leftRotate(k);
					}
					k.parent.color = Color.BLACK;
					k.parent.parent.color = Color.RED;
					rightRotate(k.parent.parent);
				}
			}
			if (k == root) {
				break;
			}
		}
		root.color = Color.BLACK;
	}

	private void printHelper(Node root, String indent, boolean last) {
		if (root != TNULL) {
			System.out.print(indent);
			if (last) {
				System.out.print("R----");
				indent += "   ";
			} else {
				System.out.print("L----");
				indent += "|  ";
			}

			String sColor = root.color == Color.RED ? "RED" : "BLACK";
			System.out.println(root.data + "(" + sColor + ")");
			printHelper(root.left, indent, false);
			printHelper(root.right, indent, true);
		}
	}

	// Balance the tree after deletion of a node
	private void fixDelete(Node x) {
		Node s;
		while (x != root && x.color == Color.BLACK) {
			if (x == x.parent.left) {
				s = x.parent.right;
				if (s.color == Color.RED) {

					s.color = Color.BLACK;
					x.parent.color = Color.RED;
					leftRotate(x.parent);
					s = x.parent.right;
				}

				if (s.left.color == Color.BLACK && s.right.color == Color.BLACK) {
					
					s.color = Color.RED;
					x = x.parent;
				} else {
					if (s.right.color == Color.BLACK) {
						
						s.left.color = Color.BLACK;
						s.color = Color.RED;
						rightRotate(s);
						s = x.parent.right;
					} 

					
					s.color = x.parent.color;
					x.parent.color = Color.BLACK;
					s.right.color = Color.BLACK;
					leftRotate(x.parent);
					x = root;
				}
			} else {
				s = x.parent.left;
				if (s.color == Color.RED) {
					
					s.color = Color.BLACK;
					x.parent.color = Color.RED;
					rightRotate(x.parent);
					s = x.parent.left;
				}

				if (s.right.color == Color.BLACK && s.right.color == Color.BLACK) {
					
					s.color = Color.RED;
					x = x.parent;
				} else {
					if (s.left.color == Color.BLACK) {
						
						s.right.color = Color.BLACK;
						s.color = Color.RED;
						leftRotate(s);
						s = x.parent.left;
					} 

					
					s.color = x.parent.color;
					x.parent.color = Color.BLACK;
					s.left.color = Color.BLACK;
					rightRotate(x.parent);
					x = root;
				}
			} 
		}
		x.color = Color.BLACK;
	}

	  private void rbTransplant(Node u, Node v) {
	    if (u.parent == null) {
	      root = v;
	    } else if (u == u.parent.left) {
	      u.parent.left = v;
	    } else {
	      u.parent.right = v;
	    }
	    v.parent = u.parent;
	  }

	  private void deleteNodeHelper(Node node, T key) {
	    Node z = TNULL;
	    Node x, y;
	    while (node != TNULL) {
	      if (node.data == key) {
	        z = node;
	      }

	      if( node.data.compareTo(key) <0  || node.data.compareTo(key) == 0)
			{
				node = node.right;
			} 
	      else {
	        node = node.left;
	      }
	    }

	    if (z == TNULL) {
	      System.out.println("Couldn't find key in the tree");
	      return;
	    }

	    y = z;
	    Color yOriginalColor = y.color;
	    if (z.left == TNULL) {
	      x = z.right;
	      rbTransplant(z, z.right);
	    } else if (z.right == TNULL) {
	      x = z.left;
	      rbTransplant(z, z.left);
	    } else {
	      y = minimum(z.right);
	      yOriginalColor = y.color;
	      x = y.right;
	      if (y.parent == z) {
	        x.parent = y;
	      } else {
	        rbTransplant(y, y.right);
	        y.right = z.right;
	        y.right.parent = y;
	      }

	      rbTransplant(z, y);
	      y.left = z.left;
	      y.left.parent = y;
	      y.color = z.color;
	    }
	    if (yOriginalColor == Color.BLACK) {
	      fixDelete(x);
	    }
	  }


	public void preorder() {
		preOrderHelper(this.root);
	}

	public void inorder() {
		inOrderHelper(this.root);
	}

	public void postorder() {
		postOrderHelper(this.root);
	}
	
	public boolean greaterThan(T d1,T d2){
    	if((d1.toString()).compareTo(d2.toString())>0) return true;
    	
    	return false;
    }
	
	public boolean searchTree(T key) {
		return searchTreeHelper(this.root, key);
	}

	public Node minimum(Node node) {
		while (node.left != TNULL) {
			node = node.left;
		}
		return node;
	}

	public Node maximum(Node node) {
		while (node.right != TNULL) {
			node = node.right;
		}
		return node;
	}

	public Node successor(Node x) {
		if (x.right != TNULL) {
			return minimum(x.right);
		}

		Node y = x.parent;
		while (y != TNULL && x == y.right) {
			x = y;
			y = y.parent;
		}
		return y;
	}

	public Node predecessor(Node x) {
		if (x.left != TNULL) {
			return maximum(x.left);
		}

		Node y = x.parent;
		while (y != TNULL && x == y.left) {
			x = y;
			y = y.parent;
		}

		return y;
	}

	public void leftRotate(Node x) {
		Node y = x.right;
		x.right = y.left;
		if (y.left != TNULL) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
	}

	public void rightRotate(Node x) {
		Node y = x.left;
		x.left = y.right;
		if (y.right != TNULL) {
			y.right.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.right) {
			x.parent.right = y;
		} else {
			x.parent.left = y;
		}
		y.right = x;
		x.parent = y;
	}

	public void insert(T key) {
		Node node = new Node();
		node.parent = null;
		node.data = key;
		node.left = TNULL;
		node.right = TNULL;
		node.color = Color.RED;

		Node y = null;
		Node x = this.root;

		while (x != TNULL) {
			y = x;
			if (node.data.compareTo(x.data) <0 ) {
				x = x.left;
			} else {
				x = x.right;
			}
		}

		node.parent = y;
		if (y == null) {
			root = node;
		} else if (node.data.compareTo(y.data) <0) {
			y.left = node;
		} else {
			y.right = node;
		}

		if (node.parent == null) {
			node.color = Color.BLACK;
			return;
		}

		if (node.parent.parent == null) {
			return;
		}

		fixInsert(node);
	}
	
	public int findHeight(Node node)
	{  
        //Check whether tree is empty
        if(node == null) 
        {  
            return 0;  
        }  

            int leftHeight = 0, rightHeight = 0;  
  
             leftHeight = findHeight(node.left);  
  
             rightHeight = findHeight(node.right);  
  
            //Compare height of left subtree and right subtree  
            //and store maximum of two in variable max  
            if(leftHeight > rightHeight) 
            	return 1+leftHeight;
            else
            	return 1+rightHeight;  
            //Calculate the total height of tree by adding height of root    

	}
	public int Height_Of_Tree()
	{
		return findHeight(this.root);
	}
	public Node getRoot() {
		return this.root;
	}
	 public void deleteNode(T data)
	 {
		 deleteNodeHelper(getRoot(), data);
	 }
	
	public void printTree() {
		printHelper(this.root, "", true);
	}

	/*public static void main(String[] args) throws Exception{
		//Scanner sc=new Scanner(System.in);
		Red_Black_Tree<String> bst = new Red_Black_Tree<>();
		
		System.out.println("-------------------------Insertion----------------------");
		System.out.println("");
		bst.insert("Dhruv");
		bst.insert("Chintan");
		bst.insert("Bhavuk");
		bst.insert("Aaaksh");
		bst.insert("sonu");
		bst.insert("Zojm");
		bst.printTree();
		System.out.println("");
		System.out.println("-------------------------Searching----------------------");
		boolean ans=bst.searchTree("Dhruv");
		if(ans==true)
		{
			System.out.println("Element Exist in Tree");
		}
		else
		{
			System.out.println("Element Doesn't Exist in Tree");
		}
		System.out.println("-------------------------Deletion-----------------------");
		bst.deleteNode("Aaaksh");
		bst.printTree();
		
		System.out.println("-------------------------Height Of the Tree----------------------");
		int height=bst.Height_Of_Tree();
		System.out.println("Height Of the Tree is :" +(height-1));
	}*/
}
