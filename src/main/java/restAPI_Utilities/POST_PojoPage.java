package restAPI_Utilities;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"name",
"job"
})
public class POST_PojoPage 
{

	@JsonProperty("name")
	private String name;
	@JsonProperty("job")
	private String job;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
	return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
	this.name = name;
	}

	public POST_PojoPage withName(String name) {
	this.name = name;
	return this;
	}

	@JsonProperty("job")
	public String getJob() {
	return job;
	}

	@JsonProperty("job")
	public void setJob(String job) {
	this.job = job;
	}

	public POST_PojoPage withJob(String job) {
	this.job = job;
	return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

	public POST_PojoPage withAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	return this;
	}

}
