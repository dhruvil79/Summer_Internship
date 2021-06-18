package Logic_Of_Code;
import java.io.*;
import java.util.*;

public class Cycle_Detection_Undirected_Graph 
{
	private int Size;
	private LinkedList<Integer> adj[];
	
	Cycle_Detection_Undirected_Graph(int Size)
	{
		this.Size=Size;
		adj= new LinkedList[this.Size];
		   for (int i=0; i<Size; ++i)
	            adj[i] = new LinkedList();	
	}
	
	void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v);
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
	
	
	Boolean isCyclicUtil(int v,Boolean visited[], int parent)
	{
		// 	Mark the current node as visited
		visited[v] = true;
		Integer i;
	
		// Recur for all the vertices
		// adjacent to this vertex
		Iterator<Integer> it =
				adj[v].iterator();
		while (it.hasNext())
		{
			i = it.next();
	
			// If an adjacent is not
			// visited, then recur for that
			// adjacent
			if (!visited[i])
			{
				if (isCyclicUtil(i, visited, v))
					return true;
			}
	
			// If an adjacent is visited
			// and not parent of current
			// vertex, then there is a cycle.
			else if (i != parent)
				return true;
		}
	return false;
	}
	
	Boolean isCyclic()
	{
		
		// Mark all the vertices as
		// not visited and not part of
		// recursion stack
		Boolean visited[] = new Boolean[Size];
		for (int i = 0; i < Size; i++)
			visited[i] = false;
	
		// Call the recursive helper
		// function to detect cycle in
		// different DFS trees
		for (int u = 0; u < Size; u++)
		{
			// Don't recur for u if already visited
			if (!visited[u])
				if (isCyclicUtil(u, visited, -1))
					return true;
		}
	
		return false;
	}
	
	
	public static void main(String args[])
	{
		// Create a graph given
		// in the above diagram
		Cycle_Detection_Undirected_Graph g1 = new Cycle_Detection_Undirected_Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		g1.printgraph();
		if (g1.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");

		Cycle_Detection_Undirected_Graph g2 = new Cycle_Detection_Undirected_Graph(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.printgraph();
		if (g2.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");
		
	}	
}
