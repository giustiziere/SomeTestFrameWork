package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class DataItem implements Serializable {

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("id")
	private Integer id;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("email")
	private String email;
}