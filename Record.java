import java.util.Date;

public class Record {

	private int id;
	private String name;
	private String email;
	private String startDtae;
	private Date endDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStartDtae() {
		return startDtae;
	}
	public void setStartDtae(String startDtae) {
		this.startDtae = startDtae;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDtae == null) ? 0 : startDtae.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startDtae == null) {
			if (other.startDtae != null)
				return false;
		} else if (!startDtae.equals(other.startDtae))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Record [id=" + id + ", name=" + name + ", email=" + email + ", startDtae=" + startDtae + ", endDate="
				+ endDate + "]";
	}
	public Record(int id, String name, String email, String startDtae, Date endDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.startDtae = startDtae;
		this.endDate = endDate;
	}

	
}