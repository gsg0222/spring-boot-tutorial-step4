package blog.tsuchiya.tutorial.step4.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import blog.tsuchiya.tutorial.step4.controller.form.MainForm;

@Controller
public class MainController {

	@GetMapping
	public String index(Model model) {
		model.addAttribute("mainForm", new MainForm());
		return "index";
	}
	
	@PostMapping("action")
	// @Validアノテーションを付けた引数は入力チェックが行われる
	// 結果は直後の引数BindingResultに格納される。
	// BindingResultは@Validのすぐあとになくてはならない
	public String action(Model mode, @ModelAttribute @Valid MainForm mainForm, BindingResult result) {
		// 入力チェックに引っかかったらindex.htmlに戻る
		if(result.hasErrors()) {
			return "index";
		}
		return "action";
	}
}
