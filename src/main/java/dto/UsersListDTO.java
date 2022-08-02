package dto;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class UsersListDTO implements Serializable {

	@SerializedName("per_page")
	private Integer perPage;

	@SerializedName("total")
	private Integer total;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("page")
	private Integer page;

	@SerializedName("total_pages")
	private Integer totalPages;

	@SerializedName("support")
	private Support support;
}