package ups;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Graph<User> graph = new Graph<>();

        // Crear usuarios
        User user1 = new User("Alice", 30, Arrays.asList("Music", "Art"));
        User user2 = new User("Bob", 25, Arrays.asList("Music", "Sports"));
        User user3 = new User("Charlie", 35, Arrays.asList("Art", "Movies"));
        User user4 = new User("Dave", 40, Arrays.asList("Sports", "Travel"));
        User user5 = new User("Eve", 28, Arrays.asList("Music", "Movies"));

        // Añadir usuarios al grafo
        graph.addUser(user1);
        graph.addUser(user2);
        graph.addUser(user3);
        graph.addUser(user4);
        graph.addUser(user5);

        // Añadir conexiones manualmente según la salida esperada
        graph.addConnection(user1, user2);  // Alice -> Bob
        graph.addConnection(user1, user3);  // Alice -> Charlie
        graph.addConnection(user2, user1);  // Bob -> Alice
        graph.addConnection(user2, user4);  // Bob -> Dave
        graph.addConnection(user2, user3);  // Bob -> Charlie
        graph.addConnection(user3, user1);  // Charlie -> Alice
        graph.addConnection(user3, user2);  // Charlie -> Bob
        graph.addConnection(user3, user5);  // Charlie -> Eve
        graph.addConnection(user4, user2);  // Dave -> Bob
        graph.addConnection(user5, user3);  // Eve -> Charlie

        // Imprimir las conexiones de los usuarios
        graph.printUserConnections();

        // Recomendaciones de Amigos
        RecommendationEngine engine = new RecommendationEngine();
        List <User> recommendations = engine.recommendFriends(user1, graph);
        System.out.println("Friend recommendations for " + user1.getName() + ": " + recommendations);
    }
}
