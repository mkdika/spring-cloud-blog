package com.mkdika.cloudblog.post.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer id;
    private String title;
    private String content;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createtime;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date releasetime;
    
    @Transient
    List<String> tags;
}