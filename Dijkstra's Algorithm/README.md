# Dijkstra's Algorithm

Dijkstra's Algorithm is for computing the shortest path from a designated vertex (A) to a designated vertex (B).

The program is an implementation of this algorithm.

It reads the graph from a text file that has the same format as the input file. 
Each input file starts with a line containing the number of vertices in the graph.
The vertices are assumed to be numbered alphabetically starting with vertex A. 
Each subsequent line in the input file contains the tail of an edge followed by a space, the head of the edge followed by a space, and the weight of the edge, respectively.

The program outputs the weight of a shortest path from vertex A to vertex B in the graph and the sequence of vertices on a shortest path from A to B.

------------------
## The code files contain:
GraphD ---- class to store and manipulate information of a connected graph. 

Info ---- built-up data structure to store pairs of vertex and weight value.

InfoComparator ---- comparator for comparing two instances of Info based on the weight value.

TestDriver ---- test driver to run the algorithm and output results.
