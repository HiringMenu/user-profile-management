package com.hiringmenu.models.userProfile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "user_profile_request")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty(value = "first_name")
    private String firstName;
    @JsonProperty(value = "last_name")
    private String lastName;
    @JsonProperty(value = "middle_name")
    private String middleName;
    @JsonProperty(value = "date_of_birth")
    private String dateOfBirth;
}
