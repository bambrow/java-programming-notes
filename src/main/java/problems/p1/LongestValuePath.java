package problems.p1;


import java.util.LinkedList;
import java.util.List;

public class LongestValuePath {
	
	public static class Vertex {
		public int val;
		public List<Vertex> adj;
		public int maxDepth;
		public Vertex(int x) {
			this.val = x;
			this.adj = new LinkedList<>();
			this.maxDepth = 0;
		}
		@Override
		public String toString() {
			StringBuilder str = new StringBuilder();
			str.append(this.val);
			str.append(" [ ");
			for (Vertex v : adj) {
				str.append(v.val);
				str.append(",");
			}
			str.deleteCharAt(str.length()-1);
			str.append(" ]");
			return str.toString();
		}
	}
	
	private int val = 0;
		
    public int longestValuePath(Vertex[] vertices) {
        for (Vertex v : vertices) {
        	if (v.maxDepth == 0) {
        		depthSameValue(v, v.val);
			}
        }
        return val;
    }
    
    private int depthSameValue(Vertex vertex, int value) {
        if (vertex.val != value) return 0;
        if (vertex.maxDepth != 0) return vertex.maxDepth;
        int first = 0, second = 0;
        for (Vertex v : vertex.adj) {
        	int d = depthSameValue(v, value);
        	if (d > first) {
        		second = first;
        		first = d;
        	} else if (d > second) {
        		second = d;
        	}
        }
        vertex.maxDepth = first + 1;
        val = Math.max(val, first + second);
        return first + 1;
    }
    
    public Vertex[] constructTree(int[] labels, int[] edges) {
		Vertex[] vertices = new Vertex[labels.length];
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = new Vertex(labels[i]);
		}
		for (int i = 0; i < edges.length; i+=2) {
			vertices[edges[i]-1].adj.add(vertices[edges[i+1]-1]);
			// vertices[edges[i+1]-1].adj.add(vertices[edges[i]-1]); // this should be a tree, so comment this line
		}
		return vertices;
	}

	public static void main(String[] args) {
		
		LongestValuePath l1 = new LongestValuePath();
		int[] labels = {3,3,2,2,3,2,2};
		int[] edges = {1,2,1,3,2,5,6,7,3,4,4,6};
		Vertex[] vertices = l1.constructTree(labels, edges);
		/*
		for (Vertex v : vertices) {
			System.out.println(v);
		}
		*/
		System.out.println(l1.longestValuePath(vertices));
		
		LongestValuePath l2 = new LongestValuePath();
		labels = new int[] {1,1,1,1,1,1,3,3,2,1,1,2,2,2,3,2,1,2,1,3,2,3,3,2,2,3,3,3,2,2,3,2,3,3};
		edges = new int[] {1,2,1,3,1,4,1,5,2,6,2,7,2,8,4,9,4,10,5,11,6,12,6,13,6,14,7,15,9,16,9,17,9,18,9,19,11,20,13,21,15,22,15,23,16,24,18,25,20,26,20,27,20,28,22,29,22,30,23,31,25,32,26,33,31,34};
		vertices = l2.constructTree(labels, edges);
		System.out.println(l2.longestValuePath(vertices));
		
		LongestValuePath l3 = new LongestValuePath();
		labels = new int[] {1,2,3,4,5,6,7,8};
		edges = new int[] {1,2,1,3,1,4,2,5,2,6,2,7,4,8};
		vertices = l3.constructTree(labels, edges);
		System.out.println(l3.longestValuePath(vertices));
		
	}

}
