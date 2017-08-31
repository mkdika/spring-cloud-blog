package com.mkdika.cloudblog.post.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
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
public class BlogPost implements Serializable {

    @Id
    private Integer id;
    private String title;
    private String content;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date releasedate;
}
