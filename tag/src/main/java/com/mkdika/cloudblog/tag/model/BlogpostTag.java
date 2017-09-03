package com.mkdika.cloudblog.tag.model;

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
public class BlogpostTag implements Serializable {

    @Id
    private Integer id;
    private Integer postId;
    private String tag;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createtime;
}
