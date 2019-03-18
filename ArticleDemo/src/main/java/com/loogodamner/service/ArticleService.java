package com.loogodamner.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.loogodamner.Tools.DBTools;
import com.loogodamner.beans.Article;
import com.loogodamner.mapper.ArticleMapper;

@Service
public class ArticleService {
	public List<Article> getAllArticles(){
		SqlSession session = DBTools.getSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		List<Article> articles = null;
		try {
			articles = mapper.selectAllArticle();
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();;
			session.rollback();
		}finally {
			session.close();
		}
		return articles;
	}
	
	public boolean addArticle(Article article) {
		SqlSession session = DBTools.getSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		int result = 0;
		try {
			result = mapper.addArticle(article);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public Article getArticleById(int id) {
		SqlSession session = DBTools.getSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		Article article = null;
		try {
			article = mapper.getArticleById(id);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return article;
	}
	
    public boolean deleteArticleById(int id){
        SqlSession session=DBTools.getSession();
        ArticleMapper mapper=session.getMapper(ArticleMapper.class);

        int result=0;
        try {
            result=mapper.deleteArticle(id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally{
            session.close();
        }
        return result>0;
    }
    
    public boolean editArticle(Article article){
        SqlSession session=DBTools.getSession();
        ArticleMapper mapper=session.getMapper(ArticleMapper.class);

        int result=0;
        try {
            result=mapper.editArticle(article);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally{
            session.close();
        }

        return result>0;
    }
}
