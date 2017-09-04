package com.mkdika.cloudblog.post.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class UserProfile implements Serializable {
    
    @Id
    @NotEmpty(message = "UID can not empty.")
    private String uid;
    
    @NotEmpty(message = "Email can not empty.")    
    private String email;    
}