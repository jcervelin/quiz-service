package io.jcervelin.ideas.entities;

import java.io.Serializable;

public class State implements Serializable{
	
	private static final long serialVersionUID = -801800086483936723L;
	private String code;
	private Integer ibgeCode;
	private String name;
	
	public State (StateEnum stateEnum) {
		this.code = stateEnum.toString();
		this.ibgeCode = stateEnum.getIbgeCod();
		this.name = stateEnum.getName();
	}
	
	public State() {
		
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getIbgeCode() {
		return ibgeCode;
	}
	public void setIbgeCode(Integer ibgeCode) {
		this.ibgeCode = ibgeCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((ibgeCode == null) ? 0 : ibgeCode.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		State other = (State) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (ibgeCode == null) {
			if (other.ibgeCode != null)
				return false;
		} else if (!ibgeCode.equals(other.ibgeCode))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
