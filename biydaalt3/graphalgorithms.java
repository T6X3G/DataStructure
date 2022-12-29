package biydaalt3;
import java.io.BufferedReader;

//bellman ford-iin bogino zamiin bodlogo

import java.io.*;
import java.lang.*;
import java.util.*;
public class graphalgorithms {

	// irmegiin baiguulagch function
	public class Edge {
		int src, dest, weight;
		Edge() { src = dest = weight = 0; }
	};

	int V, E;
	Edge edge[];

	// undsen ajilgaanii function irmeg ba untsug
	graphalgorithms(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[e];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

	// undsen function ba hamgiin bogino zamiig olj ilruulne
	//zarimdaa surug utga ilruuldeg
	public void BellmanFord(graphalgorithms graph, int src)
	{
		int V = graph.V, E = graph.E;
		int dist[] = new int[V];

		// Step 1: Initialize distances from src to all
		// other vertices as INFINITE
		for (int i = 0; i < V; ++i)
			dist[i] = Integer.MAX_VALUE;
		dist[src] = 0;

		// Step 2: Relax all edges |V| - 1 times. A simple
		// shortest path from src to any other vertex can
		// have at-most |V| - 1 edges
		for (int i = 1; i < V; ++i) {
			for (int j = 0; j < E; ++j) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;
				if (dist[u] != Integer.MAX_VALUE
					&& dist[u] + weight < dist[v])
					dist[v] = dist[u] + weight;
			}
		}

		// Step 3: check for negative-weight cycles. The
		// above step guarantees shortest distances if graph
		// doesn't contain negative weight cycle. If we get
		// a shorter path, then there is a cycle.
		for (int j = 0; j < E; ++j) {
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int weight = graph.edge[j].weight;
			if (dist[u] != Integer.MAX_VALUE&& dist[u] + weight < dist[v]) {
				System.out.println(
					"Graph contains negative weight cycle");
				return;
			}
		}
		hevleh(dist, V);
	}

	// A utility function used to print the solution
	void hevleh(int dist[], int V)
	{
		System.out.println("Vertex Distance from Source");
		for (int i = 0; i < V; ++i)
			System.out.println(i + "\t\t" + dist[i]);
	}
	// Driver's code
	public static void main(String[] args)
	{
		int V,w=0;
		int E;
		int a,b,c;
		Scanner input= new Scanner(System.in);
		System.out.println("!!!uildelee songo!!!");
		System.out.println("1.text file unshih(5 oroi 8 untsugtei)");
		System.out.println("2.utgaa garaar oruulah");
		int q=input.nextInt();
		if(q==1) {
			graphalgorithms graph = new graphalgorithms(5, 8);
				try {
					BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\Tugul\\OneDrive\\Desktop\\ugugdl\\CS203\\src\\biydaalt3\\biy3.txt"));
					String data[];
					String l;
					while((l=reader.readLine())!=null) {
						data=l.split(" ");
						a=Integer.parseInt(data[0]);
						b=Integer.parseInt(data[1]);
						c=Integer.parseInt(data[2]);
						graph.edge[w].src = a;
					    graph.edge[w].dest = b;
						graph.edge[w].weight = c;
						w=w+1;
						
					}

					}
	
					catch(Exception e){
						System.out.println("");}
		
			graph.BellmanFord(graph, 0);}
		if(q==2) {
		System.out.println("Oroin toog oruulna uu");
		V=input.nextInt();
		System.out.println("Untsgiin toog oruulnauu");
		E=input.nextInt();
		graphalgorithms graph = new graphalgorithms(V, E);
		for(int i=0;i<E;i++) {
			System.out.println("Baigaa gazar-iig oruulna uu");
			a=input.nextInt();
			graph.edge[i].src = a;
			System.out.println("Ochih gazar-iig oruulna uu");
			b=input.nextInt();
			graph.edge[i].dest = b;
			System.out.println("URT-iig oruulna uu");
			c=input.nextInt();
			graph.edge[i].weight = c;		
		}
		graph.BellmanFord(graph, 0);
		}
		// Function call
		
	}
}
