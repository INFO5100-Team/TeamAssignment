/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lab7.entities.Comment;
import lab7.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {
public void userWithMostLikes(){
        Map<Integer,Integer> userLikesCount = new HashMap<>();
        Map<Integer,User> users = DataStore.getInstance().getUsers();
        
        for(User user:users.values()){
            for(Comment c: user.getComments()){
                int likes = 0;
                if(userLikesCount.containsKey(user.getId())){
                    likes = userLikesCount.get(user.getId());
                }
                likes += c.getLikes();
                userLikesCount.put(user.getId(), likes);
            }
        }
        
        int max = 0;
        int maxId = 0;
        for(int id: userLikesCount.keySet()){
            if(userLikesCount.get(id) > max){
                max = userLikesCount.get(id);
                maxId = id;
            }
        }
        
        System.out.println("User with most likes: " + max + "\n"
                + users.get(maxId));
}
    public void getFiveMostLikeComment() {
        Map<Integer,Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        
        // add a comparator to the Collection.sort(), and implement this comparator
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override
            public int compare(Comment c1, Comment c2) {
                return c2.getLikes() - c1.getLikes();
            }
        });
        
        System.out.println("5 Most Lkied Comments: ");
        for(int i = 0; i< commentList.size() && i<5; i++){
            System.out.println(commentList.get(i));
        }
}
}