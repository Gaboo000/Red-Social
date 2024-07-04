package ups;

import java.io.Serializable;

import java.util.Set;

public class User implements Serializable {
    private String name;
    private Set<User> friends;
    


    public void setName(String name) {
        this.name = name;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void addFriend(User friend) {
        this.friends.add(friend);
        friend.getFriends().add(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
