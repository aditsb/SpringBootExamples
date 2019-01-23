package com.example.springBoot.SpringBootExamples.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.springBoot.SpringBootExamples.model.PostBean;
@Component
public class PostDAOService {

	public static List<PostBean> posts = new ArrayList<PostBean>();
	private static int postCount = 4;
	static {
		posts.add(new PostBean(1, "Good Post",1,"Jeff"));
		posts.add(new PostBean(2, "Excellant Post",1,"Alistair"));

		posts.add(new PostBean(3, "Need improvement in Post",2,"Darren"));
		posts.add(new PostBean(4, "Good Post",3,"Andy"));


	}

	public List<PostBean> findPosts() {
		return posts;

	}

	public PostBean findOne(int id) {
		for (PostBean postBean : posts) {
			if (id == postBean.getId()) {
				return postBean;
			}
		}
		return null;

	}

	public List<PostBean> findPostsforUser(int id) {
		List<PostBean>userPosts=new ArrayList<PostBean>();
		for (PostBean postBean : posts) {
			if (id == postBean.getPostId()) {
				userPosts.add(postBean);
			}
		}
		return userPosts;

	}
	public PostBean SavePost(PostBean post) {
		if (post.getId() == 0) {
			post.setId(++postCount);
		}

		posts.add(post);
		
		return post;
	}
}
