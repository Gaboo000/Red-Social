package ups;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class NodeGraph<T> implements Serializable {
    private T data;
    private Set<NodeGraph<T>> friends;

    public NodeGraph(T data) {
        this.data = data;
        this.friends = new HashSet<>();
    }

    public T getData() {
        return data;
    }

    public Set<NodeGraph<T>> getFriends() {
        return friends;
    }

    public void addFriend(NodeGraph<T> friend) {
        this.friends.add(friend);
        friend.getFriends().add(this);
    }

    /*@Override
    public String toString() {
        return data.toString();
    }*/
}
