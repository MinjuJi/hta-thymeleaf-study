package com.sample.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	
	@GetMapping("/signup")
	public String form(Model model) {
		model.addAttribute("userSignupForm", new UserSignupForm());
		return "register-form"; // src/main/resource/templates/register-form.html
	}
	
	@PostMapping("/signup")
	public String form(@Valid @ModelAttribute("userSignupForm") UserSignupForm form, BindingResult errors) {
		
		// BindingResult 객체에 오류가 있으면, 유효성 체크를 통과하지 못한 것임으로 회원가입폼으로 내부이동시킨다.
		if(errors.hasErrors()) {
			return "register-form";
		}
		return "redirect:/user/completed";
	}
	
	@GetMapping("/completed")
	public String completed() {
		return "completed"; // src/main/resource/templates/completed.html
	}
}
