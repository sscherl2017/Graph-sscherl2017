import java.util.ArrayList;

/**
* Contains a Vertex class with many methods for interacting with the Vertex. The Vertex will contain
* a list of Edges that connect to the Vertex.
* @author Sam Scherl
* @version 2/17/16
*/
public class Vertex<E>
{
	/* The value at the Vertex. */
	private E value;
	
	/* The list of Edges connecting to the Vertex. */
	private ArrayList<Edge<E>> destinations;
	
	/* Shows whether the Vertex has been visited or not. */
	private boolean beenVisited;
	
	/*
	* A constructor that takes in a value.
	* @param	The value that will be initialized
	*/
	public Vertex(E v)
	{
		value = v;
		beenVisited = false;
		destinations = new ArrayList<Edge<E>>();
	}
	
	/*
	* Returns the value of the Vertex.
	* @return	The value of the Vertex
	*/
	public E getValue()
	{
		return value;
	}
	
	/*
	* Marks that the Vertex has been visited by setting beenVisited to true.
	*/
	public void visit()
	{
		beenVisited = true;
	}
	
	/*
	* Returns the ArrayList of all Edges connecting to the Vertex.
	* @return	All the Edges connecting to the Vertex
	*/
	public ArrayList<Edge<E>> getDestinations()
	{
		return destinations;
	}	
	
	/* 
	* Adds the given Vertex and cost to the ArrayList of Edges.
	* @param	The Vertex that will be added
	* @param	The cost of the Vertex that will be added
	*/
	public void addVertex(Vertex<E> vert, Integer cost)
	{
		destinations.add(new Edge<E>(vert, cost));
		vert.getDestinations().add(new Edge<E>(this, cost));
	}
	
	/*
	* Returns a String representation of the Vertex.
	* @return	A String representation of the Vertex
	*/
	public String toString()
	{
		return value.toString();
	}
	
	/*
	* Returns true if all Vertices that are connected have been visited, false if not
	* @return	true if all Vertices that are connected have been visited, false if not
	*/
	public boolean doneTraveling()
	{
		for (Edge e : destinations)
		{
			if (!e.getVertex().beenVisited)
				return false;
		}
		return true;
	}
	
	/*
	* Returns the Edge with the least value that also has a Vertex that has not yet been visited.
	* @return	The Edge with a Vertex that has not been visited and the least cost
	*/
	public Edge<E> least()
	{
		int index = -1;
		int least = Integer.MAX_VALUE;
		for (int i = 0; i < destinations.size(); i++)
		{
			if (destinations.get(i).getCost() < least && !destinations.get(i).getVertex().beenVisited)
			{
				index = i;
				least = destinations.get(i).getCost();
			}
		}
		return destinations.get(index);
	}
	
	
}