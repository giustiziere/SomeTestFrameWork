package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Support implements Serializable {

	@SerializedName("text")
	private String text;

	@SerializedName("url")
	private String url;
}