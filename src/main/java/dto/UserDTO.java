package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserDTO implements Serializable {

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("job")
	private String job;
}