package ups;

import java.io.Serializable;
import java.util.*;

public class Graph<T> implements Serializable {
    private Map<T, NodeGraph<T>> nodes;

    public Graph() {
        this.nodes = new HashMap<>();
    }

    public void addUser(T data) {
        nodes.putIfAbsent(data, new NodeGraph<>(data));
    }

    public void addConnection(T data1, T data2) {
        NodeGraph<T> node1 = nodes.get(data1);
        NodeGraph<T> node2 = nodes.get(data2);
        if (node1 != null && node2 != null) {
            node1.addFriend(node2);
        }
    }

    public NodeGraph<T> getNode(T data) {
        return nodes.get(data);
    }

    public Set<NodeGraph<T>> getAllNodes() {
        return Set.copyOf(nodes.values());
    }

    public Set<String> getInterestsUnion(User user1, User user2) {
        Set<String> union = new HashSet<>(user1.getInterests());
        union.addAll(user2.getInterests());
        return union;
    }

    public Set<String> getInterestsIntersection(User user1, User user2) {
        Set<String> intersection = new HashSet<>(user1.getInterests());
        intersection.retainAll(user2.getInterests());
        return intersection;
    }

    // Método para calcular similaridad
    public double calculateSimilarity (User user1, User user2){
        Set <String> interests1 = new HashSet <>(user1.getInterests());
        Set <String> interests2 = new HashSet <>(user1.getInterests());
        Set <String> intersection = new HashSet <>(interests1);
        intersection.retainAll(interests2);
        Set <String> union = new HashSet <>(interests1);
        union.addAll(interests2);
        return 0;
    }

    public void printUserConnections() {
        for (NodeGraph<T> node : nodes.values()) {
            User user = (User) node.getData();
            System.out.print("Vertex " + user.getName() + ": ");
            for (NodeGraph<T> friend : node.getFriends()) {
                User friendUser = (User) friend.getData();
                System.out.print("-> " + friendUser.getName() + " ");
            }
            System.out.println();
        }
    }
}
