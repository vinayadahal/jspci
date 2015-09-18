package system.service;

import java.util.ArrayList;

public class PostMapper {

    public ArrayList<String> post = new ArrayList();

    public void Post(String key) {
        post.add(key);
        System.out.println("Post setup complete...");
    }

    public ArrayList ObtainPostIndex() {
        System.out.println("obtainPostIndex...");
        return post;
    }
}
