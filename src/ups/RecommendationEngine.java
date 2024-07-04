package ups;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecommendationEngine implements Serializable {

    /*public <T> Set<NodeGraph<T>> recommendFriends(NodeGraph<T> node) {
        Set<NodeGraph<T>> recommendations = new HashSet<>();
        Set<NodeGraph<T>> friends = node.getFriends();

        for (NodeGraph<T> friend : friends) {
            for (NodeGraph<T> friendsOfFriend : friend.getFriends()) {
                if (!friends.contains(friendsOfFriend) && !friendsOfFriend.equals(node)) {
                    recommendations.add(friendsOfFriend);
                }
            }
        }

        return recommendations;
    }*/

    public List<User> recommendFriends(User user1, Graph<User> graph) {
        List<User> recommendations = new ArrayList<>();
        for (NodeGraph<User>potentialFriendNode :graph.getAllNodes()){
            User potentialFriend = potentialFriendNode.getData();
            if(!user1.getFriends().contains(potentialFriend)&& !user1.getData().equals(potentialFriend)){
                double similarity = calculateSimilarity (user1.getData(), potentialFriend);
                if(similarity > 0.3) { 
                    recommendations.add(potentialFriend);
                }

            }
        }
        return recommendations;
    }

    // Método para calcular similitud
    public double calculateSimilarity(User user1, User user2) {
        Set<String> interests1 = new HashSet<>(user1.getInterests());
        Set<String> interests2 = new HashSet<>(user2.getInterests());
        Set<String> intersection = new HashSet<>(interests1);
        intersection.retainAll(interests2);
        Set<String> union = new HashSet<>(interests1);
        union.addAll(interests2);
        double similarity = (double) intersection.size() / union.size();
        System.out.println("Valor - " + similarity); // Mostrar valor de similitud
        return similarity;
    }
}
