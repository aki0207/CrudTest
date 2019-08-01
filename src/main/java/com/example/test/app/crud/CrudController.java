package com.example.test.app.crud;

import java.util.Collection;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.example.test.domain.model.Crud;
import com.example.test.domain.service.CrudService;
import com.github.dozermapper.core.Mapper;


@Controller
@RequestMapping("crud")
public class CrudController {

	@Inject
	CrudService crudService;

	@Inject
	Mapper beanMapper;

	@ModelAttribute 
	public Form setUpForm() {
		Form form = new Form();
		return form;
	}


	@GetMapping("entry")
	public String entry(Model model) {
		Collection<Crud> cruds = crudService.findAll();
		model.addAttribute("cruds", cruds); 
		return "crud/entry"; 
	}

	@PostMapping("create")
	public String create(@Valid Form form, BindingResult bindingResult,
			Model model, RedirectAttributes attributes) {

		if (bindingResult.hasErrors()) {
			return entry(model);
		}
		Crud crud = beanMapper.map(form,Crud.class);

		try {
			crudService.create(crud);
		} catch(BusinessException e) {
			model.addAttribute(e.getResultMessages());
			return entry(model);
		}

		return "redirect:/crud/entry";
	}
	
	@GetMapping("login")
	public String login(Model model) {
		
		return "crud/login"; 
	}


	@PostMapping("login")
	public String login(@Valid Form form, BindingResult bindingResult,
			Model model, RedirectAttributes attributes) {
		
		if (bindingResult.hasErrors()) {
			return entry(model);
		}
		Crud crud = beanMapper.map(form,Crud.class);

		try {
			crud = crudService.findOne(crud);
			if(crud!= null) {
				model.addAttribute("crud", crud); 
				return "crud/top"; 
				//return "redirect:/crud/top"; 
			} else {
				return "redirect:/crud/login"; 
			}
		} catch(BusinessException e) {
			model.addAttribute(e.getResultMessages());
			return entry(model);
		}
	}
}
