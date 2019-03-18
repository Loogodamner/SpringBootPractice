package com.loogodamner.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loogodamner.beans.Article;
import com.loogodamner.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/article")
	public String showArticles(Model model) {
		List<Article> articles = articleService.getAllArticles();
		model.addAttribute("articles",articles);
		return "/article/index";
	}
	
	@RequestMapping(value="/saveArticle",method=RequestMethod.POST)
	public String create(Article article) {
		article.setDate(new Date());
		if(articleService.addArticle(article)) {
			return "redirect:/article";
		}else {
			return "/article/create";
		}
	}
	
    @RequestMapping(value = "/details/{id}",method = RequestMethod.GET)
    public String details(@PathVariable("id") int id, Model model){
        Article article=articleService.getArticleById(id);
        model.addAttribute("article",article);
        return "/article/details";
    }
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String deleteArticle(@PathVariable("id") int id){
        if(articleService.deleteArticleById(id)){
            return "redirect:/article";
        }
        return "redirect:/article";
    }

    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id,Model model){
        Article article=articleService.getArticleById(id);
        model.addAttribute("article",article);
        return "/article/edit";
    }
    
    @RequestMapping(value = "/updateArticle",method = RequestMethod.POST)
    public String edit(Article article,Model model){
        if(articleService.editArticle(article)){
            return "redirect:/article";
        }
        model.addAttribute("article",article);
        return "/article/edit";
    }
    
    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return "Hello thymeleaf";
    }
    
    @RequestMapping("/test")
    public String testLayout(){
        return "/test";
    }
}
