package com.qiheng.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.qiheng.DAO.PostDAO;
import com.qiheng.bean.Post;
import com.qiheng.bean.Reply;
import com.qiheng.service.PostService;
@Transactional
public class PostServiceImpl implements PostService {

	private PostDAO postDao;

	public PostDAO getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDAO postDao) {
		this.postDao = postDao;
	}

	public List<Post> list(int groudId) {
		return postDao.list(groudId);
	}

	public String findName(int userId) {
		return postDao.findPostAuthor(userId);
	}

	public void add(Post post) {
		postDao.save(post);
	}

	public Post listOne(int postId) {
		return postDao.findPostById(postId);
	}

	public void updatePost(Post post) {
		postDao.update(post);
	}

	public void addReply(Reply reply) {
		postDao.saveReply(reply);
		
	}

	public List<Reply> listReply(int postId, int offiset) {

		return postDao.listReply(postId, offiset);
	}

	public List listAndPage(final int offiset, final int groudId) {
		return postDao.QueryPage(offiset, groudId);
	}

	public int getCount(int groudId) {

		return postDao.getCount(groudId);
	}

	public int getReplyCount(int postId) {
		return postDao.getReplyCount(postId);
	}

	public int getPostCount(int userId) {
		return postDao.getPostCount(userId);
	}

	public List<Post> listALL(int offiset) {
		return postDao.listAll(offiset);
	}

	public int getAllPostCount() {
		return postDao.getAllPostCount();
	}

	public void delete(Post post) {
		postDao.delete(post);
	}

	public List<Post> userlist(int userId) {

		return null;
	}

	public List userlist(int offiset, int userId) {
		return postDao.userQueryPage(offiset, userId);
	}
}
