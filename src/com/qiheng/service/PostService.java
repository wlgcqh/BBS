package com.qiheng.service;

import java.util.List;

import com.qiheng.bean.Post;
import com.qiheng.bean.Reply;


public interface PostService {
	public List<Post> list(int groudId) ;
	public List<Post> userlist(int userId) ;
	public String findName(int userId);
	public void add(Post post);
	public Post listOne(int postId);
	public void updatePost(Post post);
	public void addReply(Reply reply);
	public List<Reply> listReply(int postId, int offiset);
	public List listAndPage(final int offiset, final int groudId);
	public List userlist(final int offiset, final int userId);
	public int getCount(int groudId);
	public int getReplyCount(int postId);
	public int getPostCount(int id);
	public List<Post> listALL(int offiset);
	public int getAllPostCount();
	public void delete(Post post);
}
