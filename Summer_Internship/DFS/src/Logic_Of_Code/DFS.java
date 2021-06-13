package Logic_Of_Code;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	private int Size; // No. of vertices
	 
    // Array  of lists for
    // Adjacency List Representation
    private LinkedList<Integer> adj[];
 
    // Constructor
    DFS(int Size)
    {
        this.Size = Size;
        adj = new LinkedList[Size];
        for (int i = 0; i < Size; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v's list.
    }
    
    void printgraph()
	{
		System.out.println("-------------------------------------------------");
		for(int i=0;i<Size;i++)
		{
			System.out.print("Node" +i);
			for(int x:adj[i])
			{
				System.out.print(" -> " +x);
			}
			System.out.println();
		}
		System.out.println("-------------------------------------------------");
	}
	
    // A function used by DFS
    void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
 
        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[Size];
 
        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }
	public static void main(String args[])
	{
		DFS g = new DFS(4);

		 	g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);	
	        g.printgraph();
	        System.out.println("Following is Depth First Traversal "+"(starting from vertex 2)");
	        g.DFS(2);
	}

}
