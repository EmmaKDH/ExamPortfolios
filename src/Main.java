
public class Main {

    public static void main(String[] args) {
        AdjacencyGraph adjDirectedG=createDirectedAdj();    // Creates a common name for calling the method, including calling other class through the method
        adjDirectedG.printGraph();                          // Calls method printGraph, from AdjacencyGraph class, through AdjacencyGraph method
        adjDirectedG.Prims();                               // Calls method Prims, from AdjacencyGraph class, through AdjacencyGraph method
    }
    public static AdjacencyGraph createDirectedAdj(){       // Creates AdjacencyGraph method, for storing and adding new cities(vertices) and edges to the graph
        AdjacencyGraph newG=new AdjacencyGraph();           //Calls the AdjacencyGraph class, which creates a connection to the class through the AdjacencyGraph method

    //Creates new Citys(vertices) with the names
        City C0=new City("Eskildstrup");
        City C1=new City("Haslev");
        City C2=new City("Holbæk");
        City C3=new City("Jægerspris");
        City C4=new City("Kalundborg");
        City C5=new City("Korsør");
        City C6=new City("Køge");
        City C7=new City("Maribo");
        City C8=new City("Næstved");
        City C9=new City("Ringsted");
        City C10=new City("Slagelse");
        City C11=new City("Nykøbing F");
        City C12=new City("Vordingborg");
        City C13=new City("Sorø");
        City C14=new City("Roskilde");
        City C15=new City("Nakskov");
    //Adds the different City-vertices to the Adjacency graph newG
        newG.addCity(C0);
        newG.addCity(C1);
        newG.addCity(C2);
        newG.addCity(C3);
        newG.addCity(C4);
        newG.addCity(C5);
        newG.addCity(C6);
        newG.addCity(C7);
        newG.addCity(C8);
        newG.addCity(C9);
        newG.addCity(C10);
        newG.addCity(C11);
        newG.addCity(C12);
        newG.addCity(C13);
        newG.addCity(C14);
        newG.addCity(C15);

    //Adds Egdes to the graph with the distance from one City(vertex) to another
        newG.addEdge(C0,C7,28);

        newG.addEdge(C0,C11,13);

        newG.addEdge(C0,C12,24);

        newG.addEdge(C1,C5,60);

        newG.addEdge(C1,C6,24);

        newG.addEdge(C1,C8,25);

        newG.addEdge(C1,C9,19);

        newG.addEdge(C1,C14,47);

        newG.addEdge(C1,C10,48);

        newG.addEdge(C1,C13,34);

        newG.addEdge(C1,C12,40);

        newG.addEdge(C2,C3,34);

        newG.addEdge(C2,C4,44);

        newG.addEdge(C2,C5,66);

        newG.addEdge(C2,C9,36);

        newG.addEdge(C2,C14,32);

        newG.addEdge(C2,C10,46);

        newG.addEdge(C2,C13,34);

        newG.addEdge(C3,C5,95);

        newG.addEdge(C3,C6,58);

        newG.addEdge(C3,C9,56);

        newG.addEdge(C3,C14,33);


        newG.addEdge(C3,C10,74);

        newG.addEdge(C3,C13,63);

        newG.addEdge(C4,C9,62);

        newG.addEdge(C4,C14,70);

        newG.addEdge(C4,C10,39);

        newG.addEdge(C4,C13,51);

        newG.addEdge(C5,C8,45);

        newG.addEdge(C5,C10,20);

        newG.addEdge(C6,C8,45);

        newG.addEdge(C6,C9,28);

        newG.addEdge(C6,C14,25);

        newG.addEdge(C6,C12,60);

        newG.addEdge(C7,C15,27);

        newG.addEdge(C7,C11,26);

        newG.addEdge(C8,C14,57);

        newG.addEdge(C8,C9,26);

        newG.addEdge(C8,C10,37);

        newG.addEdge(C8,C13,32);

        newG.addEdge(C8,C12,28);

        newG.addEdge(C9,C14,31);

        newG.addEdge(C9,C13,15);

        newG.addEdge(C9,C12,58);

        newG.addEdge(C10,C13,14);


        return newG;
    }
}
