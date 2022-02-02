package challenge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
 @Table(name = "scripts")
@Data
public class Quote {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private int episode;

	private String episode_name;

	private String segment;

	private String type;

	private String actor;

	private  String character;

	private String detail;

	private Date record_date;

	private String series;

	private Date transmission_date;

//	@Id
//	public Integer id;
//
//	@NotNull
//	public String actor;
//
//	@NotNull
//	public String detail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getQuote() {
		return detail;
	}

	public void setQuote(String quote) {
		this.detail = quote;
	}

}
