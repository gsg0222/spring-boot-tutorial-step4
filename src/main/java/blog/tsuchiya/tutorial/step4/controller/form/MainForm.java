package blog.tsuchiya.tutorial.step4.controller.form;

import java.util.Objects;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MainForm {

	@NotEmpty(message="エラーメッセージを独自定義")
	@Email
	private String email;
	
	@Min(10)
	@Max(100)
	private Integer integer;
	
	@NotNull
	@Size(min=8, max=16)
	@Pattern(regexp="^[0-9a-zA-Z]+$")
	private String password1;
	
	@NotNull
	@Size(min=8, max=16)
	@Pattern(regexp="^[0-9a-zA-Z]+$")
	private String password2;
	
	@AssertTrue(message="パスワードが一致しません")
	public boolean isSamePassword() {
		return Objects.equals(this.password1, this.password2);
	}
}
