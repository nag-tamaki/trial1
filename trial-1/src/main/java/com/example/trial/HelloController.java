package com.example.trial;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.trial.repositories.MyDataRepository;

//@RestController
@Controller
public class HelloController {

	@Autowired
	MyDataRepository repository;

	@PersistenceContext
	EntityManager entityManager;

	MyDataDaoImpl dao;

	@PostConstruct
	public void init() {
		dao = new MyDataDaoImpl(entityManager);
		MyData d1 =new MyData();
		d1.setName("orion");
		d1.setAge(14);
		d1.setMail("orion@star.gmobb.jp");
		d1.setMemo("オリオンです");
//		repository.saveAndFlush(d1);
	}
/*
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {

		mav.setViewName("index");
		mav.addObject("msg", "My Data Sample");
//		Iterable<MyData> list = dao.getAll();
		Iterable<MyData> list = dao.findByAge(0,10);
		mav.addObject("datalist", list);
		return mav;
	}
*/

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {

		mav.setViewName("index");
		mav.addObject("title", "FindPage");
		mav.addObject("msg", "Find Page sample");
//		Iterable<MyData> list = repository.findAllOrderByName();
		Iterable<MyData> list = repository.findByAge(8, 15);
		mav.addObject("datalist", list);
		return mav;
	}

	@RequestMapping(value="/find", method = RequestMethod.GET)
	public ModelAndView find(ModelAndView mav) {
		mav.setViewName("find");
		mav.addObject("title", "FindPage");
		mav.addObject("msg", "find cats sample");
		mav.addObject("value", "");
		Iterable<MyData> list = dao.getAll();
		mav.addObject("datalist", list);
		return mav;
	}

	@RequestMapping(value="/find", method = RequestMethod.POST)
		public ModelAndView search(
				HttpServletRequest req,
				ModelAndView mav) {

		mav.setViewName("find");
		String param = req.getParameter("fstr");
		if(param == "") {
			mav = new ModelAndView("redirect:/find");
		}else {
			mav.addObject("title", "find result");
			mav.addObject("msg", "[" + param + "] search result");
			mav.addObject("value", param);
			List<MyData> list = dao.find(param);
			mav.addObject("datalist", list);
		}
		return mav;
	}
	/*
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView edit(
			@ModelAttribute("formModel") MyData mydata,
			ModelAndView mav) {

		mav.setViewName("index");
		mav.addObject("msg", "list cats data");
		Iterable<MyData> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}


@RequestMapping(value="/", method = RequestMethod.POST)
@Transactional(readOnly=false)
	public ModelAndView form(
			@ModelAttribute("formModel") MyData mydata,
			ModelAndView mav) {

	repository.saveAndFlush(mydata);
	return new ModelAndView("redirect:/");
}
}
*/
/*
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
		public ModelAndView edit(
				@ModelAttribute MyData mydata,
				@PathVariable int id, ModelAndView mav) {

			mav.setViewName("edit");
			mav.addObject("title", "edit cats data");
			Optional<MyData> data = repository.findById((long) id);
			mav.addObject("formModel", data.get());
			return mav;
		}


	@RequestMapping(value="/edit", method = RequestMethod.POST)
	@Transactional(readOnly=false)
		public ModelAndView update(
				@ModelAttribute MyData mydata,
				ModelAndView mav) {

		repository.saveAndFlush(mydata);
		return new ModelAndView("redirect:/");
	}
}
*/
	/*
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(
			@PathVariable int id, ModelAndView mav) {

		mav.setViewName("delete");
		mav.addObject("title", "delete cats data");
		Optional<MyData> data = repository.findById((long) id);
		mav.addObject("formModel", data.get());
		return mav;
	}


@RequestMapping(value="/delete", method = RequestMethod.POST)
@Transactional(readOnly=false)
	public ModelAndView remove(
			@RequestParam long id,
			ModelAndView mav) {

	repository.deleteById(id);
	return new ModelAndView("redirect:/");
}
}
*/

/*
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {

		mav.setViewName("index");
		mav.addObject("msg", "we are cats");
		Iterable<MyData> list = repository.findAll();
		mav.addObject("data", list);
		return mav;
	}
*/
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
/*
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
*/


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
}
