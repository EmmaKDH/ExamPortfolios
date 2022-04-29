import java.util.ArrayList;

public class AdjacencyGraph {               //Creates the public AdjacencyGraph class
    ArrayList<City> Cities;                 //Create a list of our City-vertices called Cities/ initiates a constructor

    public AdjacencyGraph() {
        Cities = new ArrayList<City>();
    }

    public void addCity(City v) {       //Function that adds the different vertices to the list of cities
        Cities.add(v);
    }

    public void addEdge(City from, City to, Integer dist) {     //Function that adds an edge between two vertices with a predetermined distance
        if (!(Cities.contains(from) && Cities.contains(to))) {
            System.out.println("There are no cities in the graph");
            return;
        }
    //Makes each edge bidirectional by adding the from and to vertices twice in switched positions, to the variable Edge
        Edge newE = new Edge(from, to, dist);
        Edge newE1 = new Edge(to, from, dist);
    }

    public void Prims() {                               //Implements prims algorithm to the graph
    //Using the minHeap
        MinHeap<City> Q = new MinHeap<>();              //Create a minHeap
        ArrayList<City> CitiesInTree = new ArrayList<>();       //Create a list of used cities in the tree
        //Test if there are more unused cities and find and get them
        if (Cities.size() > 0) {
            Cities.get(0).distance = 0;
        } else {
            return;
        }
        for (City city : Cities) {
            Q.Insert(city);
        }
    //The algorithm
        int Tree = 0;
        City minCity = null;
        while (!Q.isEmpty()) {                          //Run until the list is empty
            minCity = Q.extractMin();                   //Asks minHeap to find the smallest value and finds minCity
            CitiesInTree.add(minCity);                  //Adds the minCity to the minimum spanning tree
            Tree += minCity.distance;                   //Adds the new addition and calculates the total distance of the tree
        //Defines minCity
            for (Edge outEdge : minCity.OutEdge) {      //Iterates the OutEdges
            if (!CitiesInTree.contains(outEdge.to) && outEdge.dist < outEdge.to.distance) {     //Checks if they have been used and is they are smaller than the distance
                outEdge.to.distance = outEdge.dist;     //Updates the distance
                outEdge.to.prev = minCity;              //Set the last visited to be minCity
                int pos = Q.getPosition(outEdge.to);    //Asks to find a new vertex to update
                Q.decreasekey(pos);                     //Updates minHeap
            }
        }
    }
    //Prints tree, the total distance and the total cost
        System.out.println("Minimum spanning tree distance: " +Tree);
        for(int i = 1; i< CitiesInTree.size(); i++)
        {
            System.out.println(" parent "+ CitiesInTree.get(i).prev.name + " to " + CitiesInTree.get(i).name +" EdgeDist: "+ CitiesInTree.get(i).distance);
        }
        System.out.println("Price for the power grid = " + (Tree*1000000) + " kr.");
}
    //Prints the AdjacencyGraph
    public void printGraph(){
        for (City city : Cities) {
            System.out.println(" City of " + city.name + " is connected to: ");
            City current = city;
            for (Edge e : current.OutEdge) {
                System.out.println(e.to.name + " is " + e.dist + " km from " + e.from.name);
                System.out.println();
            }
        }
    }

}
//Defines a City, and it's attributes
class City implements Comparable<City>{
    String name;
    ArrayList<Edge> OutEdge;                //Give City a list of other cities it is connected to
    Integer distance = Integer.MAX_VALUE;   //Gives it a so far unknown distance
    City prev = null;                       //Gives it a so far undefined previous visited City
    public City(String name) {
        this.name = name;
        OutEdge = new ArrayList<Edge>();
    }

    @Override
    public int compareTo(City o) {
        return this.distance.compareTo(o.distance);
    }
}
//Defines an Edge, and it's attributes
class Edge{
    City from;                    //Adds the first vertex
    City to;                      //Adds the second vertex
    Integer dist;                 //Adds the distance between the vertices
    public Edge(City from,City to, Integer dist){
        this.from=from;
        this.to=to;
        this.dist=dist;
        from.OutEdge.add(this);
    }
}