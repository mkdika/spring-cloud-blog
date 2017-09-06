package com.mkdika.cloudblog.tag.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlogpostTag implements Serializable {

    @Id
    @NotNull(message = "ID can not null.")    
    private Integer id;
    
    @NotNull(message = "Post ID can not null.")
    private Integer postId;
    
    @NotEmpty(message = "Tag can not empty.")
    private String tag;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createtime;
}