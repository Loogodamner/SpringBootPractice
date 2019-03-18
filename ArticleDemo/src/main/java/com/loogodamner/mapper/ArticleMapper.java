package com.loogodamner.mapper;

import java.util.List;

import com.loogodamner.beans.Article;

public interface ArticleMapper {
	public List<Article> selectAllArticle() throws Exception;
	/*
	 * 
	 * 
	 */
	public int addArticle(Article article) throws Exception;
	/*
	 * 
	 * 
	 */
	public int editArticle(Article article) throws Exception;
	/*
	 * 
	 * 
	 */
	public int deleteArticle(int id) throws Exception;
	/*
	 * 
	 * 
	 */
	public Article getArticleById(int id) throws Exception;
	/*
	 * 
	 * 
	 */
}
