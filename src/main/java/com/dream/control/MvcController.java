package com.dream.control;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.dream.model.Person;

@Controller
@RequestMapping("/mvc")
public class MvcController {
	 @RequestMapping("/hello")
      public String hello(){
    	  return "hello";
      }
	 @RequestMapping("/person")
	 public String toPerson(String name,double age){
	     System.out.println(name+" "+age);
	     return "hello";
	 }
	 //boxing automatically
	 @RequestMapping("/person1")
	 public String toPerson(Person p){
	     System.out.println(p.getName()+" "+p.getAge());
	     return "hello";
	 }
	//the parameter was converted in initBinder
	 @RequestMapping("/date")
	 public String date(Date date){
	     System.out.println(date);
	     return "hello";
	 }
	//pass the parameters to front-end
	 @RequestMapping("/show")
	 public ModelAndView showPerson(){
	     Person p =new Person();
	     p.setAge(20);
	     p.setName("jayjay");
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("p", p);
	     return new ModelAndView("show",data);
	 }
	 
	//pass the parameters to front-end using ajax
	 @RequestMapping("/getPerson")
	 public void getPerson(String name,PrintWriter pw){
	     pw.write("hello,"+name);        
	 }
	 
	 @RequestMapping("/redirect")
	 public String redirect(){
	     return "redirect:hello";
	 }
	 //At the time of initialization,convert the type "String" to type "date"
	 @InitBinder
	 public void initBinder(ServletRequestDataBinder binder){
	     binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
	             true));
	 }
}
