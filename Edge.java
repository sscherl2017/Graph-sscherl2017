/**
* Contains an Edge class with many methods for interacting with the Edge.
* @author Sam Scherl
* @version 2/17/16
*/
public class Edge<E>
{
	/* The vertex that the Edge leads to. */
	private Vertex<E> vert;
	
	/* The cost of moving to the Vertex. */
	private Integer cost;
	
	/*
	* A constructor that takes in a Vertex and a cost. 
	* @param k	The Vertex that it leads to
	* @param v	The cost of moving to the Vertex
	*/
	public Edge(Vertex<E> k, Integer v)
	{
		vert = k;
		cost = v;
	}
	
	/*
	* Returns the Vertex
	* @return	The Vertex that the Edge leads to
	*/
	public Vertex<E> getVertex()
	{
		return vert;
	}
	
	/*
	* Returns the cost of moving to the Vertex
	* @return	The cost of moving to the Vertex
	*/
	public Integer getCost()
	{
		return cost;
	}
	
	/*
	* Returns a String representation of the Edge.
	* @return	A String representation of the Edge
	*/
	public String toString()
	{
		return vert + ": " + cost;
	}
}