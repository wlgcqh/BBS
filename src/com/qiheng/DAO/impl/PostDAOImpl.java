package com.qiheng.DAO.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.qiheng.DAO.PostDAO;
import com.qiheng.bean.Post;
import com.qiheng.bean.Reply;

public class PostDAOImpl implements PostDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<Post> list(int groudId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String findPostAuthor(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Post post) {
		Session session = getSession();
		session.save(post);

	}

	public Post findPostById(int postId) {

		Session session = getSession();

		return (Post) session.get(Post.class, postId);
	}

	public void update(Post post) {

		Session session = getSession();
		session.update(post);

	}

	public void saveReply(Reply reply) {
		Session session = getSession();
		session.save(reply);

	}

	public List listReply(int postId, int offiset) {

		Session session = getSession();

		List list = session
				.createQuery(
						"from Reply r where r.post.id = :postId order by r.replyTime")
				.setInteger("postId", postId).setFirstResult((offiset - 1) * 6)
				.setMaxResults(6).list();
		return list;
	}

	public List QueryPage(int offiset, int groudId) {

		Session session = getSession();

		List list = session
				.createQuery(
						"from Post p where p.groud.id = :groudId order by p.id desc")
				.setInteger("groudId", groudId)
				.setFirstResult((offiset - 1) * 10).setMaxResults(10).list();

		return list;
	}

	public List userQueryPage(int offiset, int userId) {
		Session session = getSession();

		List list = session
				.createQuery(
						"from Post p where p.user.id = :userId order by p.createTime desc")
				.setInteger("userId", userId)
				.setFirstResult((offiset - 1) * 10).setMaxResults(10).list();

		return list;
	}

	public int getCount(int groudId) {

		Session session = getSession();
		Long count = (Long) session
				.createQuery(
						"select count(*) from Post p where p.groud.id = :groudId")
				.setInteger("groudId", groudId).uniqueResult();
		System.out.println(count);
		return count.intValue();
	}

	public int getReplyCount(int postId) {
		// int count =
		// ((Long)this.hibernateTemplate.iterate("select count(*) from Reply r where r.post.id = '"
		// + postId + "'").next()).intValue();
		Session session = getSession();
		Long count = (Long) session
				.createQuery(
						"select count(*) from Reply r where r.post.id = :postId")
				.setInteger("postId", postId).uniqueResult();
		System.out.println(count);
		return count.intValue();
	}

	public int getPostCount(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List listAll(int offiset) {

		Session session = getSession();

		List<Post> list = session
				.createQuery("from Post p order by p.createTime desc")
				.setFirstResult((offiset - 1) * 10).setMaxResults(10).list();
		return list;
	}

	public int getAllPostCount() {

		Session session = getSession();
		Long count = (Long) session.createQuery("select count(*) from Post")
				.uniqueResult();
		return count.intValue();
	}

	public void delete(Post post) {
		Session session = getSession();
		
		session.delete(post);

	}

}
