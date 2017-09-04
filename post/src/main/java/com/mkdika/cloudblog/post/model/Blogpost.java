package com.mkdika.cloudblog.post.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blogpost implements Serializable {

    @Id
    @NotNull(message = "ID can not null.")
    private Integer id;  
    
    @NotEmpty(message = "Title can not empty.")
    private String title;
    
    private String content;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createtime;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date releasetime;
    
    @Transient
    List<String> tags;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="created_by")
    private UserProfile createdBy;
}
