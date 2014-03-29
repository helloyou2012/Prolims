package com.helloyou.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.helloyou.util.JsonDateSerializer;

@MappedSuperclass
public class Po implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7241459272914572522L;
	private Long id;
	private Date time;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	@Transient
	public boolean isNew() {
        return (this.id == null);
    }
}
