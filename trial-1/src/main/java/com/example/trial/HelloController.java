package com.example.trial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@Controller
public class HelloController {

//	String[] name = {"orion","artemis","uranos","herios","iris"};
//	String[] mails = {"orion@star.gmobb.jp","artemis@star.gmobb.jp","uranos@star.gmobb.jp","herios@star.gmobb.jp","iris@star.gmobb.jp"};
/*
	@RequestMapping("/{id}")
	public DataObject index(@PathVariable int id) {
		return new DataObject(id,name[id],mails[id]);
//		return "nekoneko";
	}
*/
/*
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "current data");
		DataObject obj = new DataObject(123,"orion","orion@star.gmobb.jp");
		mav.addObject("object", obj);
		return mav;
	}
*/
/*
	@RequestMapping("/")
	public String index() {
		return "index";
	}
*/
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
}

class DataObject{
	private int id;
	private String name;
	private String value;

	public DataObject(int id, String name, String value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}


public int getId() {return id; }
public void setId(int id) {this.id = id; }
public String getName() {return name;}
public void setName(String name) {this.name = name;}
public String getValue() {return value;}
public void setValue(String value) {this.value = value;}
}