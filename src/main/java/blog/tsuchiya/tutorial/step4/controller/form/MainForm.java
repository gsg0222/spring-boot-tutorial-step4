package blog.tsuchiya.tutorial.step4.controller.form;

import java.util.Objects;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
